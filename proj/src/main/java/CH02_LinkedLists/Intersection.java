package CH02_LinkedLists;

// Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
// Note that the intersection is defined based on reference, not value. That is, if the kth node of the first
// linked list is the exact same node (by reference) as the jth node of the second linked list, then they are
// intersecting.
// Hints: #20, #45, $55, #65, #76, #93, #111, #120, #129

import Common.AssortedMethods;
import Common.LinkedListNode;

import java.util.HashSet;
import java.util.Hashtable;

public class Intersection {

    // If two singly linked lists intersect return the intersection node, otherwise return null.
    // time O(a+b), space O(a)
    public static LinkedListNode isIntersect_v1(LinkedListNode a, LinkedListNode b) {
        HashSet<LinkedListNode> nodeSet = new HashSet<>();
        while (a != null) {
            nodeSet.add(a);
            a = a.next;
        }
        while (b != null) {
            if (nodeSet.contains(b)) {
                return b;
            }
            b = b.next;
        }
        return null;
    }

    // time O(a+b), space O(1)
    public static LinkedListNode isIntersect_v2(LinkedListNode a, LinkedListNode b) {
        int lenA = length(a);
        int lenB = length(b);
        int diff = Math.abs(lenA - lenB);
        LinkedListNode shorter = lenA < lenB ? a : b;
        LinkedListNode longer = lenA < lenB ? b : a;
        while (diff-- > 0) {
            longer = longer.next;
        }
        while (shorter != null) {
            if (shorter == longer) {
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
    }

    public static int length(LinkedListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // test
    public static void main(String[] args) {
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next.next = list1.next.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());

        System.out.println(isIntersect_v1(list1, list2).printForward());
        System.out.println(isIntersect_v2(list1, list2).printForward());
    }
}
