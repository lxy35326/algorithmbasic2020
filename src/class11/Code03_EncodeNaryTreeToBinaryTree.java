package class11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 本题测试链接：https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
public class Code03_EncodeNaryTreeToBinaryTree {

    // 提交时不要提交这个类
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    // 提交时不要提交这个类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 只提交这个类即可
    class Codec {

        public TreeNode encode1(Node root) {
            if (root == null) return null;
            TreeNode head = new TreeNode(root.val);
            head.left = en(root.children);
            return head;
        }

        Node decode1(TreeNode root) {
            if (root == null) return null;
            Node head = new Node(root.val);
            head.children = de1(root.left);
            return head;
        }


        TreeNode en1(List<Node> children) {
            TreeNode head = null;
            TreeNode cur = null;
            for (Node child : children) {
                TreeNode n = new TreeNode(child.val);
                if (head == null) {
                    head = n;
                } else {
                    cur.right = n;
                }
                cur = n;
                n.left = en(child.children);
            }
            return head;
        }

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            TreeNode head = new TreeNode(root.val);
            head.left = en(root.children);
            return head;
        }

        private TreeNode en(List<Node> children) {
            TreeNode head = null;
            TreeNode cur = null;
            for (Node child : children) {
                TreeNode tNode = new TreeNode(child.val);
                if (head == null) {
                    head = tNode;
                } else {
                    cur.right = tNode;
                }
                cur = tNode;
                cur.left = en(child.children);
            }
            return head;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }


        //将二叉树转化为n叉树
        List<Node> de1(TreeNode root) {
//            List<Node> res = new LinkedList<>();
//            TreeNode cur = root;
//            while (cur != null) {
//                Node t = new Node(cur.val);
//                t.children = de1(cur.left);
//                res.add(t);
//                cur = cur.right;
//            }
            List<Node> res = new LinkedList<>();
            while (root != null) {
                Node t = new Node(root.val);
                t.children = de1(root.left);
                res.add(t);
                root = root.right;
            }
            return res;
        }

        public List<Node> de(TreeNode root) {
            List<Node> children = new ArrayList<>();
            while (root != null) {
                Node cur = new Node(root.val, de(root.left));
                children.add(cur);
                root = root.right;
            }
            return children;
        }

    }

}
