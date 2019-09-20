package Graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> hashSet = new HashSet<>();
        stack.add(node);
        hashSet.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!hashSet.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    hashSet.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
