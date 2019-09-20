package BinaryTree;

/**
 * 假设来到当前节点cur：
 * 1.如果节点没有左孩子，节点向右移动
 * 2.如果节点有左孩子，节点找到左子树的最右节点
 * 2.1 如果最右节点右指针指向空，让其指向当前节点cur，cur向左移动
 * 2.2 如果最右节点右指针指向cur，让其指向空，cur向右移动
 */


public class MorrisTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void morrisTraversal(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        //判断最后的状态
        while (cur != null) {
            mostRight = cur.left;
            //满足if，就进入2，否则跳到1
            if (mostRight != null) {
                //找到左子树最有节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //2.1,如果左子树最右节点右指针指向空，代表第一次来到这个节点
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    //2.2 如果左子树最右节点右指针指向cur，代表第二次来到这个节点
                    mostRight.right = null;
                }
            }
            //1
            //如果一个节点有左子树，cur会回到这个节点两次，否则只会回到cur一次，
            //在第二次回到这个节点时，打印这个节点，就是中序遍历
            cur = cur.right;
        }

    }

    public static void morrisInOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("in order : ");
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void morrisPreOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("pre order : ");
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    //第一次来到这个节点就打印
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();

    }

    /**
     * morris遍历，只关注能够回到自己两次的节点，每次回到自己的节点，
     * 逆序打印其左子树的右边界，最后逆序打印整棵树的右边界
     *
     * @param head
     */
    public static void morrisPosOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("pos order : ");
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    /**
     * 逆序打印节点左子树的右边界
     *
     * @param head
     */
    private static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while(from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);

        morrisInOrder(head);
        morrisPreOrder(head);
    }


}
