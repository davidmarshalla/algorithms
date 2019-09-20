package BinaryTree;

public class RecursiveTraversal {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int value) {

            val = value;
        }
    }

    /**
     * 遍历过程中每个节点会路过3次
     * @param head
     */
    public static void process(Node head) {
        if (head == null) {
            return;
        }
        process(head.left);
        process(head.right);
    }

    public static void main(String[] args) {

    }

}
