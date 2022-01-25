package CH03_StacksAndQueues.SortStack;

import java.util.Stack;

// similar to insert sort
// average, worst time complexity are O(n*n). best time complexity is O(n)
public class SortStack_v2 {
    public static <T extends Comparable<? super T>> void  sort(Stack<T> stack) {
        if (stack.empty()) return;

        // keep the tempStack is sorted, which the biggest element is on the top.
        Stack<T> tempStack = new Stack<>();
        while (!stack.empty()) {
            // int n = 0; // number of moved element.
            T e = stack.pop();
            while (!tempStack.empty()) {
                if (e.compareTo(tempStack.peek()) < 0) {
                    // n++;
                    // use the original stack to temporary these elements which are bigger than e
                    stack.push(tempStack.pop());
                } else {
                    break;
                }
            }
            // push e into tempStack
            tempStack.push(e);

            // actually we don't need the following 3 lines, and the variable n
            // because even if we don't do the following 3 line code,  at the next loop e.compareTo() < 0 is false
            // and the code above will put these elements back.
            // push bigger elements back
            // while (n-- >0) {
            //     tempStack.push(stack.pop());
            // }
        }
        // now the tempStack are sorted but the biggest element is on the top. we need to put is back to
        // the stack which is passed in as the argument.
        while(!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
    }
}
