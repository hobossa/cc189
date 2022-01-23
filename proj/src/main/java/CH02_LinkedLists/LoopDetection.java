package CH02_LinkedLists;

// Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
// so as to make a loop in the linked list.
// EXAMPLE
// Input:   A -> B -> C -> D -> E -> C (the same C as earlier)
// Output:  C
// Hints: #50, #69, #83, #90

import Common.LinkedListNode;

import java.util.HashSet;

public class LoopDetection {

    // If there is a loop, return the beginning of the loop, else return null.

    // version 1
    // time O(n), space O(n)
    public static LinkedListNode getLoopBeginning_v1(LinkedListNode head) {
        if (null == head) return null;

        HashSet<LinkedListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // version 2
    // time O(n) space O(1)
    public static LinkedListNode getLoopBeginning_v2(LinkedListNode head) {
        if (null == head) return null;

        LinkedListNode p = head;
        LinkedListNode runner = head; // 2x faster runner
        do {
            p = p.next;
            for (int i = 0; i < 2; i++) {
                if (null == runner) {
                    return null;
                }
                runner = runner.next;
            }
        } while (p != runner);

        p = head;
        while (p != runner) {
            p = p.next;
            runner = runner.next;
        }

        return p;
    }

    // test
    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = getLoopBeginning_v1(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }

        LinkedListNode loop2 = getLoopBeginning_v2(nodes[0]);
        if (loop2 == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop2.data);
        }
    }
}
