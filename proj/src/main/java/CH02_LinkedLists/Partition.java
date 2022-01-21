package CH02_LinkedLists;

// write code to partition a linked list around a value x, such that all nodes less than x come before
// all nodes greater than or equal to x. If x is contained within the list, the value of x only need to
// e after the elements less than x (see below). The partition element x can appear anywhere in the
// "right partition"; it does not need to appear between the left and right partitions.
// EXAMPLE
// Input: 3->5->8->5->10->2->1 [partition = 5]
// Output: 3->1->2->10->5->5->8
// Hints: #3, #24

import Common.AssortedMethods;
import Common.LinkedListNode;

public class Partition {

    // time O(N)
    public static LinkedListNode partition_v1(LinkedListNode head, int partition) {
        if (head == null) return head;
        LinkedListNode p = head;
        LinkedListNode leftPart = null;
        LinkedListNode leftLast = null;
        LinkedListNode rightPart = null;
        LinkedListNode rightLast = null;
        while (p != null) {
            if (p.data >= partition) {
                // move to right part;
                if (rightPart == null) {
                    rightPart = p;
                    rightLast = p;
                } else {
                    rightLast.setNext(p);
                    rightLast = p;
                }
            } else {
                // move to left part;
                if (leftPart == null) {
                    leftPart = p;
                    leftLast = p;
                } else {
                    leftLast.setNext(p);
                    leftLast = p;
                }
            }
            p = p.next;
        }
        if (leftLast != null) {
            leftLast.setNext(null);
        }

        if (leftPart == null) {
            head = rightPart;
        } else if (rightPart == null) {
            head = leftPart;
        } else { // if (leftPart != null && rightPart != null) {
            leftLast.setNext(rightPart);
            rightPart.setPrevious(leftLast);
            head = leftPart;
        }

        return head;
    }

    // version 2
    public static LinkedListNode partition_v2(LinkedListNode head, int partition) {
        if (head == null) return head;
        // move all elements that smaller than partition to the beginning of the list

        LinkedListNode p = head.next;
        LinkedListNode temp = null;
        while (p != null) {
            temp = p.next;
            if (p.data < partition) {
                head = removeNode(head, p);
                head = insertAtBeginning(head, p);
            }
            p = temp;
        }
        return head;
    }

    public static LinkedListNode removeNode(LinkedListNode head, LinkedListNode node) {
        if (node == null) return head;

        if (node == head) {
            head = head.next;
        }

        if (node.next != null) {
            node.next.setPrevious(node.prev);
        }
        if (node.prev != null) {
            node.prev.setNext(node.next);
        }

        node.setNext(null);
        node.setPrevious(null);

        return head;
    }

    public static LinkedListNode insertAtBeginning(LinkedListNode head, LinkedListNode node) {
        if (node == null) return head;

        node.setNext(head);
        head = node;
        return head;
    }

    // version 3
    public static LinkedListNode partition_v3(LinkedListNode head, int partition) {
        LinkedListNode leftPart = null;
        LinkedListNode rightPart = null;
        LinkedListNode temp = null;
        while (head != null) {
            temp = head.next;
            if (head.data < partition) {
                head.next = leftPart;
                leftPart = head;
            } else {
                head.next = rightPart;
                rightPart = head;
            }
            head = temp;
        }

        // concatenate‚
        if (leftPart == null) {
            head = rightPart;
        } else {
            temp = leftPart;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = rightPart;
            head = leftPart;
        }
        return head;
    }

    // version 4
    public static LinkedListNode partition_v4(LinkedListNode head, int partition) {
        LinkedListNode pHead = head;
        LinkedListNode pTail = head;
        LinkedListNode p = head;
        LinkedListNode temp;
        while (p != null) {
            temp = p.next;
            if (p.data < partition) {
                p.next = pHead;
                pHead = p;
            } else {
                pTail.next = p;
                pTail = p;
            }
            p = temp;
        }
        pTail.next = null;

        return pHead;
    }

    // test
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 3, 7);
        System.out.println(head.printForward());
        int partition = 5;
        System.out.println("partition = " + partition);

        LinkedListNode l1 = head.clone();
        l1 = partition_v1(l1, partition);
        System.out.println(l1.printForward());

        LinkedListNode l2 = head.clone();
        l2 = partition_v2(l2, partition);
        System.out.println(l2.printForward());

        LinkedListNode l3 = head.clone();
        l3 = partition_v3(l3, partition);
        System.out.println(l3.printForward());

        LinkedListNode l4 = head.clone();
        l4 = partition_v4(l4, partition);
        System.out.println(l4.printForward());
    }
}
