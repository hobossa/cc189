package CH02_LinkedLists;

// Implement an algorithm to delete a node in the middle in the middle (i.e., any node
// but the first and the last node, not necessarily the exact middle) of a singly linked list,
// given only access to that node.
// EXAMPLE
// Input: the node c form the linked list a->b->c->d->e->f
// Result: nothing is returned, but the new linked list looks like a->b->d->e->f
// Hints: #72

import Common.LinkedListNode;

public class DeleteMiddleNode {

    public static boolean deleteMiddleNode_v1(LinkedListNode head) {
        if (null == head) return false;
        LinkedListNode p = head;
        LinkedListNode runner = head;
        while (p != null) {
            if (runner.next != null && runner.next.next != null) {
                p = p.next;
                runner = runner.next.next;
            } else {
                break;
            }
        }
        if (p == head) {
            return false;
        }

        // delete p
        p.next.setPrevious(p.prev);
        p.prev.setNext(p.next);
        return true;
    }

    // test
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        head.last = head;
        LinkedListNode second = first;
        for (int i = 1; i < 9; i++) {
            second = new LinkedListNode(i, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteMiddleNode_v1(head);
        System.out.println(head.printForward());
    }
}
