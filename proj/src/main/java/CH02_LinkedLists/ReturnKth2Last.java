package CH02_LinkedLists;

// Implement an algorithm to find the kth to last element of a singly linked list.
// Hints: #8, #25, #41, #67, #126

import Common.LinkedListNode;

public class ReturnKth2Last {

    // issue: The question doesn't mention what should be return when the k is greater than the length of the list.
    // Here we will return null when the above situation happens.
    // And return the original list when k = 1.
    public static LinkedListNode getKth2Last_v1(LinkedListNode head, int k) {
        LinkedListNode p = head;
        int c = 1;
        while (c < k && p != null) {
            p = p.next;
            c++;
        }
        return p;
    }

    // test
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        head.last = head;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        for (int i = 1; i < 10; i++) {
            LinkedListNode temp = getKth2Last_v1(head, i);
            System.out.println(temp != null ? temp.printForward() : "null");
        }
    }
}
