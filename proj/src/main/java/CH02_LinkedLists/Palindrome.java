package CH02_LinkedLists;

// Implement a function to check if a linked list is a palindrome.
// Hints: #5, #13, #29, #61, #101

import Common.AssortedMethods;
import Common.LinkedListNode;

import java.util.Stack;

public class Palindrome {

    // version 1, get a reverse list and compare
    // time O(n), space O(n)
    public static boolean isPalindrome_v1(LinkedListNode head) {
        LinkedListNode listReverse = reverseList(head);
        // use a 2x faster runner to make sure that we only need to compare half of the list
        LinkedListNode runner = head;
        while (head != null && listReverse != null && runner != null) {
            // System.out.println("Compare: " + head.data + " - " + listReverse.data);
            if (head.data != listReverse.data) {
                return false;
            }
            head = head.next;
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
            }
            listReverse = listReverse.next;
        }
        return true;
    }

    public static LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode ret = null;
        LinkedListNode temp;
        while (head != null) {
            temp = new LinkedListNode(head.data);
            temp.next = ret;
            ret = temp;
            head = head.next;
        }
        return ret;
    }

    // version 2, time O(n), space O(n)
    public static boolean isPalindrome_v2(LinkedListNode head) {
        LinkedListNode listReverse = reverseLastHalf(head);
        while (listReverse != null && head != null) {
            if (listReverse.data != head.data) {
                return false;
            }
            listReverse = listReverse.next;
            head = head.next;
        }
        return true;
    }

    // only reverse the last part of the list by using a 2x runner.
    public static LinkedListNode reverseLastHalf(LinkedListNode head) {
        LinkedListNode cur = head;
        LinkedListNode runner = head;
        while (runner != null) {
            cur = cur.next;
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
            }
        }

        LinkedListNode ret = null;
        LinkedListNode temp;
        while (cur != null) {
            temp = new LinkedListNode(cur.data);
            temp.next = ret;
            ret = temp;
            cur = cur.next;
        }
        return  ret;
    }

    // version 3, use a stack, time O(n), space O(n)
    public static boolean isPalindrome_v3(LinkedListNode head) {
        LinkedListNode runner = head;
        boolean odd = false;
        Stack<Integer> st = new Stack<>();
        // push the first half into the stack.
        while (runner != null) {
            st.push(head.data);
            head = head.next;
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
            } else {
                odd = true;
            }
        }

        if (odd) {
            st.pop();   // pop the middle element
            //System.out.println(st.pop());
        }
        // if (head != null) System.out.println(head.printForward());

        while (head != null) {
            if (head.data != st.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    // version 4, recursive
    public static boolean isPalindrome_v4(LinkedListNode head) {
        int len = length(head);
        Result res =  isPalindromeInner_v4(head, len);
        return  res.isPalindrome;
    }

    public static class Result {
        public LinkedListNode lastNode;
        public boolean isPalindrome;

        public Result(LinkedListNode lastNode, boolean isPalindrome) {
            this.lastNode = lastNode;
            this.isPalindrome = isPalindrome;
        }
    }

    public static int length(LinkedListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static Result isPalindromeInner_v4(LinkedListNode head, int len) {
        if ( 0 == len) {
            return new Result(head, true);
        }
        if (1 == len) {
            return new Result(head.next, true);
        }

        Result res = isPalindromeInner_v4(head.next, len -2);
        if (!res.isPalindrome || head.data != res.lastNode.data) {
            return new Result(null, false);
        }
        return new Result(res.lastNode.next, true);
    }

    // test
    public static void main(String[] args) {
        // for (int i = 0; i < 10; i++) {
        //     LinkedListNode a = AssortedMethods.randomLinkedList(7, 0, 9);
        //     System.out.println();
        //     System.out.println(a.printForward());
        //     System.out.println(reverseList(a).printForward());
        //     System.out.println(reverseLastHalf(a).printForward());
        // }

        LinkedListNode lA1 = new LinkedListNode(1, null, null);
        LinkedListNode lA2 = new LinkedListNode(2, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(3, null, lA2);
        LinkedListNode lA4 = new LinkedListNode(2, null, lA3);
        LinkedListNode lA5 = new LinkedListNode(1, null, lA4);
        //LinkedListNode lA6 = new LinkedListNode(1, null, lA5);
        System.out.println(lA1.printForward());
        System.out.println(isPalindrome_v1(lA1));
        System.out.println(isPalindrome_v2(lA1));
        System.out.println(isPalindrome_v3(lA1));
        System.out.println(isPalindrome_v4(lA1));


    }
}
