package class30;
class Node{
    Node left, right;
    int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }
}
public class Morris {
    static void morris(Node head) {
        if (head == null) return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            //根据有无左子树分情况，如果没有左子树，直接跳到右子树
            //如果有左子树，先找左子树的最右结点
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right != cur) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } 
                mostRight.right = null;
            }
            //如果无左子树
            cur = cur.right;
        }
    }
    public static void main(String[] args) {
       Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        morris(head);
    }
}
