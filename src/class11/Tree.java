package class11;

import java.util.*;

public class Tree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return null;
        Deque<Node> stack = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                List<Node> children = root.children;
                if (children != null && children.size() > 0) {
                    //如果有左孩子，则root变为左孩子
                    map.put(root, 0);
                    root = children.get(0);
                } else root = null;
            }
            root = stack.pop();
            List<Node> children = root.children;
            int index = map.getOrDefault(root, -1) + 1;
            if (children != null && children.size() > index) {
                //一定有下一个,要跳到右边
                // stack.push(root);
                Node t = children.get(index);
                map.put(root, index);
                root = t;
            } else {
                //没有下一个
                res.add(root.val);
                root = null;
            }
        }

        return res;
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public static void main(String[] args) {
        Node _1 = new Node(1);
        Node _2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        _1.children = Arrays.asList(_3,_2,_4);
        _3.children=Arrays.asList(_5,_6);
        postorder(_1);
    }

    static List<Integer> list = new ArrayList<>();
    static public int widthOfBinaryTree(TreeNode root) {
//        return dfs(root, 0, 0);
        int times = 1_000;
        int maxValue = 100;
        int max,left,right;
        for (int i = 0; i < times; i++) {
            left =(int)( Math.random() * maxValue);
            max =(int)( Math.random() * maxValue);
            right =(int)( Math.random() * maxValue);
            int t = max <= left ? left <= right ? right : left : max;
            int t1 = Math.max(max, Math.max(left,right));
            if (t != t1){
                System.out.println("-------------error---");
                System.out.println(left);
                System.out.println(right);
                System.out.println(max);
                System.out.println("t:" +t);
                System.out.println("t1:"+t1);
            }
        }
        return 0;
    }
    static int dfs(TreeNode root, int level, int index) {
        if (root == null)
            return 0;
        if (level == list.size()) {
            list.add(index);
        }
        int max = index - list.get(level) + 1;
        int left = dfs(root.left, level + 1,index * 2 + 1);
        int right = dfs(root.right, level + 1, (index * 2) + 2);
        return max <= left ? (left < right ? right : left) : max;
//        return Math.max(max,Math.max(left,right));
    }




}
