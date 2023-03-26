import java.util.*;
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int x) {
        val = x;
    }
}
public class Codec {


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        //先序遍历方式
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(',');
            return;
        }
        sb.append(root.val).append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    static  public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        String[] s = data.split(",");
        return deserialize(s,0);
        // return head;
    }
    static   TreeNode deserialize(String[] s, int i) { //5 4 3
        if (i <= s.length - 2) {
            if (s[i].equals("null")) {
                return null;
            } else {
                TreeNode t = new TreeNode(Integer.parseInt(s[i]));
                t.left = deserialize(s, i + 1);
                t.right = deserialize(s, i + 2);
                return t;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);

        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        _1.left=_2;
        _1.right=_3;
        _2.left=_2.right=null;
        _3.left=_4;
        _3.right=_5;
        _4.left=_4.right=_5.left=_5.right=null;
        String s = serialize(_1);
        deserialize(s);
    }
}