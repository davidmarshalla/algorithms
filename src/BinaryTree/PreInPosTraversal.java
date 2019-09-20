package BinaryTree;

import java.util.Stack;

public class PreInPosTraversal {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int value) {

            val = value;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head != null) {
            System.out.print(head.val + " ");
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }
    }

    public static void inOrderRecur(Node head) {
        if (head != null) {
            inOrderRecur(head.left);
            System.out.print(head.val + " ");
            inOrderRecur(head.right);
        }
    }

    public static void posOrderRecur(Node head) {
        if (head != null) {
            posOrderRecur(head.left);
            posOrderRecur(head.right);
            System.out.print(head.val + " ");
        }
    }

    public static void preOrder(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrder(Node head) {
        if (head != null) {
            Stack<Node> s = new Stack<>();
            while (head != null || !s.isEmpty()) {
                if (head != null) {
                    s.push(head);
                    head = head.left;
                } else {
                    head = s.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrder(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        System.out.println("==============unrecursive==============");
//        System.out.print("pre-order: ");
//        preOrder(head);
        System.out.print("in-order: ");
        inOrder(head);
        System.out.print("pos-order: ");
        posOrder(head);
    }
}
