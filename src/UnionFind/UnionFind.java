package UnionFind;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
    public class Node {
        int val;
        Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> list) {

            makeSet(list);
        }

        private void makeSet(List<Node> list) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (Node n : list) {
                fatherMap.put(n, n);
                sizeMap.put(n, 1);
            }
        }

        //找到起始节点
        private Node findFather(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findFather(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findFather(a);
            Node bHead = findFather(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(a);
                int bSetSize = sizeMap.get(b);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }


    }


}
