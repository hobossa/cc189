package CH02_LinkedLists;

// You have two numbers represented by a linked list, where each node contains a single digit.
// The digits are stored in reverse order, such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list.
// EXAMPLE
// Input: (7->1->6) + (5->9->2). That is 617+295.
// Output: 2->1->9. That is 912.
// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem.
// EXAMPLE
// Input: (6->1->7) + (2->9->5). That is, 617 + 295.
// Output: 9->1->2. That is 912.
// Hints: #30, #71, #109

import Common.AssortedMethods;
import Common.LinkedListNode;

public class SumLists {

    // Sum reverse represented digit version 1, time O(max(N, M)), space O(max(N,M))
    public static LinkedListNode SumR_v1(LinkedListNode a, LinkedListNode b) {
        LinkedListNode result = null;
        LinkedListNode cur = null;
        int carry = 0;
        while (a != null || b != null || carry != 0) {
            int temp = carry +
                    (a != null ? a.data : 0) +
                    (b != null ? b.data : 0);
            carry = temp / 10;
            temp = temp % 10;
            if (a != null) a = a.next;
            if (b != null) b = b.next;

            if (cur == null) {
                result = new LinkedListNode(temp);
                cur = result;
            } else {
                cur.next = new LinkedListNode(temp);
                cur = cur.next;
            }
        }

        return result;
    }

    // Sum reverse represented digit version 2, time O(max(N, M)),
    // space O(1) by using the original list to save the result.
    // I don't recommend in the real product. we should not change the input arguments.
    public static LinkedListNode SumR_v2(LinkedListNode a, LinkedListNode b) {
        if (a == null) return b;
        LinkedListNode result = a;
        LinkedListNode cur = a;
        int carry = 0;
        while (a != null || b != null) {
            int temp = carry +
                    (a != null ? a.data : 0) +
                    (b != null ? b.data : 0);
            carry = temp / 10;
            temp = temp % 10;

            if (a != null) a = a.next;
            if (b != null) b = b.next;
            cur.data = temp;
            if (cur.next == null) {
                if (b != null) {
                    // switch to list b,
                    // todo: or we can use the longer list at the very beginning to avoid this switch
                    cur.next = b;
                } else {
                    if (0 != carry) {
                        // we need a new node to save the carry.
                        cur.next = new LinkedListNode();
                    }
                }
            }
            cur = cur.next;
        }
        if (carry != 0) {
            cur.data = carry;
        }

        return result;
    }

    // Sum reverse represented digit version 3, use recursive
    // time O(max(N, M)), space O(max(N,M))
    public static LinkedListNode SumR_v3(LinkedListNode a, LinkedListNode b) {
        return SumRInner_v3(a, b, 0);
    }

    public static LinkedListNode SumRInner_v3(LinkedListNode a, LinkedListNode b, int carry) {
        if (a == null && b == null && carry == 0) return null;

        int temp = (a != null ? a.data : 0) + (b != null ? b.data : 0) + carry;
        carry = temp / 10;
        temp = temp % 10;
        LinkedListNode ret = new LinkedListNode(temp);
        ret.next = SumRInner_v3((a != null ? a.next : null), (b != null ? b.next : null), carry);
        return ret;
    }

    // version 4, tail recursive.
    // using tail recursive cannot get much benefit in this case, because each recursive only has one recursive call
    // into the next level.
    public static LinkedListNode SumR_v4(LinkedListNode a, LinkedListNode b) {
        return SumRInner_v4(a, b, 0, null, null);
    }
    public static LinkedListNode SumRInner_v4(LinkedListNode a, LinkedListNode b, int carry,
                                              LinkedListNode ret, LinkedListNode last) {
        if (a == null && b == null && carry == 0) return ret;

        int temp = (a != null ? a.data : 0) + (b != null ? b.data : 0) + carry;
        carry = temp / 10;
        temp = temp % 10;

        if (last == null) {
            last = new LinkedListNode(temp);
            ret = last;
        } else {
            last.next = new LinkedListNode(temp);
            last = last.next;
        }

        return SumRInner_v4((a != null ? a.next : null), (b != null ? b.next : null), carry, ret, last);
    }

    // FOLLOW UP
    // For the follow-up question, you can reverse the list first.
    public static LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode ret = null;
        LinkedListNode temp;
        while (head != null) {
            if (ret == null) {
                ret = new LinkedListNode(head.data);
            } else {
                temp = new LinkedListNode(head.data);
                temp.next = ret;
                ret = temp;

            }
            head = head.next;
        }
        return ret;
    }

    // As the sum algorithm, we can also reverse the list in place rather than build a new list;
    // Again, I don't believe it is a good approach to modify arguments.
    public static LinkedListNode reverseListInPlace(LinkedListNode head) {
        if (head == null) return head;
        LinkedListNode cur = head.next;
        head.next = null;
        LinkedListNode ret = head;
        LinkedListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = ret;
            ret = cur;
            cur = temp;
        }
        return ret;
    }

    // test
    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(0, null, lB2);

        System.out.println();
        System.out.println(lA1.printForward());
        System.out.println(lB1.printForward());
        LinkedListNode r1 = SumR_v1(lA1, lB1);
        System.out.println(r1.printForward());
        LinkedListNode r2 = SumR_v2(lA1, lB1);
        System.out.println(r2.printForward());


        for (int i = 0; i < 10; i++) {
            LinkedListNode a = AssortedMethods.randomLinkedList(3, 0, 9);
            LinkedListNode b = AssortedMethods.randomLinkedList(4, 0, 9);
            System.out.println();
            System.out.println(a.printForward());
            System.out.println(b.printForward());
            LinkedListNode r = SumR_v1(a, b);
            System.out.println(r.printForward());
            LinkedListNode rrr = SumR_v3(a, b);
            System.out.println(rrr.printForward());
            LinkedListNode rrrr = SumR_v4(a, b);
            System.out.println(rrrr.printForward());
            // version 2 will destroy the argument, so we put it at the end
            LinkedListNode rr = SumR_v2(a, b);
            System.out.println(rr.printForward());
            System.out.println("test list reverse:");
            System.out.println(reverseList(rr).printForward());
            System.out.println(reverseListInPlace(rr).printForward());
        }

    }
}
