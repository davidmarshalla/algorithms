package ArrayStackQueue;

import java.util.Stack;

/**
 * 用一个栈对栈排序
 */
public class StackSortStack {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> stackAux = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!stackAux.isEmpty() && stackAux.peek() > cur) {
                stack.push(stackAux.pop());
            }
            stackAux.push(cur);
        }
        while (!stackAux.isEmpty()) {
            stack.push(stackAux.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
