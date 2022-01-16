package CH02_LinkedLists;

// write code to remove duplicates from an unsorted linked list.
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?
// Hints: #9, #40

import Common.LinkedListNode;

import java.util.HashSet;
import java.util.Hashtable;

public class RemoveDups {

    //
    public static boolean removeDups_v1(LinkedListNode head) {
        HashSet<Integer> setValue = new HashSet<>();
        LinkedListNode p = head;
        while (p != null) {
            int data = p.data;
            if (!setValue.contains(data)) {
                setValue.add(data);
                p = p.next;
                continue;
            }
            // remove p
            p.prev.setNext(p.next);
            if (p.next != null) {
                p.next.setPrevious(p.prev);
            }
            p = p.next;
        }

        return true;
    }

    // test
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        head.last = head;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 3, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());

        LinkedListNode cloneA = head.clone();
        removeDups_v1(cloneA);
        System.out.println(cloneA.printForward());

    }
}
