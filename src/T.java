import java.util.*;

public class T {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",");
        sj.add(null);
        System.out.println(sj);

    }
}
class Node {
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
class Solution {
    public static List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<Node> stack = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                List<Node> children = root.children;
                if (children == null || children.size() == 0) {
                    break;
                } else {
                    root = children.get(0);
                }
            }
            root = stack.pop();
            List<Node> children = root.children;
            int index = map.getOrDefault(root, 0); // root = 1 index = 1
            //还需要一个表示当前索引位置的值
            if (children != null && children.size() > index + 1) {
                map.put(root, index + 1);
                root = children.get(index + 1);
            } else {
                root = null;
            }

        }
        return res;
    }
}