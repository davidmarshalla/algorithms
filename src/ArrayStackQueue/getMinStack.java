package ArrayStackQueue;

import java.util.Stack;

public class getMinStack {

    public static class Stack1 {
        private Stack<Integer> stack;
        private Stack<Integer> min;

        public Stack1() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                min.push(Math.min(val, min.peek()));
            }
        }

        public int pop() {
            if (stack.isEmpty() || min.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            min.pop();
            return stack.pop();
        }

        public int getMin() {
            if (min.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return min.peek();
        }
    }

    public static class Stack2 {
        private Stack<Integer> stack;
        private Stack<Integer> min;

        public Stack2() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min.isEmpty() || val < min.peek()) {
                min.push(val);
            }
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }

            if (min.peek() == stack.peek()) {
                min.pop();
            }

            return stack.pop();
        }

        public int getMin() {
            if (min.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return min.peek();
        }

    }

    public static void main(String[] args) {
        Stack1 stack1 = new Stack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        Stack2 stack2 = new Stack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }


}
