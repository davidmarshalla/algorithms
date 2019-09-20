package ArrayStackQueue;

import java.util.Stack;

public class twoStackImplementQueue {
    public static class Queue2Stacks {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public Queue2Stacks() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void add(int val) {
            stackPush.push(val);
        }

        public int poll() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
                return stackPop.pop();
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
                return stackPop.peek();
            }
            return stackPop.peek();
        }

        public static void main(String[] args) {
            Queue2Stacks test = new Queue2Stacks();
            test.add(1);
            test.add(2);
            test.add(3);
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
        }

    }

}
