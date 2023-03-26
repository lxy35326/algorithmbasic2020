package class11;

import java.util.LinkedList;
import java.util.List;

public class Tree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Node {
        int val;
        List<Node> list;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, List<Node> list) {
            this(val);
            this.list = list;
        }
    }

    TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.list);
        return head;
    }

    TreeNode en(List<Node> list) {
        TreeNode head = null;
        TreeNode cur = head;
        for (Node child : list) {
            if (head == null) {
                head = new TreeNode(child.val);
                cur = head;
            } else {
                cur.right = new TreeNode(child.val);
                cur = cur.right;
            }
            cur.left = en(child.list);
        }
        return head;
    }

    Node decode(TreeNode root) {
        if (root == null) return null;
        Node head = new Node(root.val);
        head.list = de(root.left);
        return head;
    }

    /**
     * 传入的是头结点
     * @param root
     * @return
     */
    List<Node> de(TreeNode root) {
        List<Node> list = new LinkedList<>();
        while (root != null) {
            Node t = new Node(root.val);
            t.list = de(root.left);
            list.add(t);
            root= root.right;
        }
        return list;
    }


}
