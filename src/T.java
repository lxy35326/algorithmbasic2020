import com.sun.jndi.toolkit.url.Uri;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

public class T {
    public static void main(String[] args)throws IOException {
        StringJoiner sj = new StringJoiner(",");
        sj.add(null);
        System.out.println(sj);
        System.out.println("\u8bf7");
        System.out.println("\u6c42");
        System.out.println("\u6210");
        System.out.println("\u529f");
        String de = URLEncoder.encode("请求成功");
        System.out.println(de);

        System.out.println("\u8bf7\u6c42\u6210\u529f");
        System.out.println("\u8bf7\u6c42\u6210\u529f".equals("请求成功"));
//        Uri uri =
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