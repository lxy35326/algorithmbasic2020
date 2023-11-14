package class35;

public class AVLTree<K extends Comparable<K>, V> {
    static class AVLNode<K extends Comparable<K>, V> {
        K key;
        V value;
        AVLNode<K, V> left, right;
        int h = 1;

        AVLNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    AVLNode<K, V> root;
    int size = 0;

    void updateHeight(AVLNode<K, V> node) {
        node.h = 1 + Math.max(node.left == null ? 0 : node.left.h, node.right == null ? 0 : node.right.h);
    }

    AVLNode<K, V> leftRotate(AVLNode<K, V> node) {
        AVLNode<K, V> right = node.right;
        node.right = right.left;
        right.left = node;
        updateHeight(node);
        updateHeight(right);
        return right;
    }

    AVLNode<K, V> rightRotate(AVLNode<K, V> node) {
        AVLNode<K, V> left = node.left;
        node.left = left.right;
        left.right = node;
        updateHeight(node);
        updateHeight(left);
        return left;
    }
    int getSize(){
        return size;
    }
    AVLNode<K, V> add(AVLNode<K, V> node, K key, V value) {
        size++;
        //一定是不能加重复值的
        if (node == null) return new AVLNode<>(key, value);

        if (key.compareTo(node.key) < 0) {
            //向左滑
            node.left = add(node.left, key, value);

        } else if (key.compareTo(node.key) > 0) {
            //向右滑
            node.right = add(node.right, key, value);
        } else {
            //相等

        }
        node.h = Math.max(node.left == null ? 0 : node.left.h, node.right == null ? 0 : node.right.h) + 1;
        return maintain(node);
    }

    AVLNode<K, V> maintain(AVLNode<K, V> node) {
        if (node == null) return null;
        int leftSize = node.left == null ? 0 : node.left.h;
        int rightSize = node.right == null ? 0 : node.right.h;
        int leftLeftSize, leftRightSize, rightLeftSize, rightRightSize;
        leftRightSize = leftLeftSize = rightLeftSize = rightRightSize = 0;
        if (node.left != null) {
            if (node.left.left != null) leftLeftSize = node.left.left.h;
            if (node.left.right != null) leftRightSize = node.left.right.h;
        }
        if (node.right != null) {
            if (node.right.left != null) rightLeftSize = node.right.left.h;
            if (node.right.right != null) rightRightSize = node.right.right.h;
        }

        if (Math.abs(leftLeftSize - rightLeftSize) > 1) {

            if (leftSize > rightSize) {
                //说明左侧的高
                if (leftLeftSize > rightSize) {
                    //右旋
                    node = rightRotate(node);
                } else {
                    node.left = leftRotate(node.left);
                    node = rightRotate(node);
                }
            } else {
                //说明右侧的高
                if (rightRightSize > leftSize) {
                    //左旋
                    node = leftRotate(node);
                } else {
                    //右左旋
                    assert node.right != null;
                    node.right = rightRotate(node.right);
                    node = leftRotate(node);
                }
            }
        }

        return node;

    }
    //找到小于key最右的
    AVLNode<K, V> findLastKey(K key){
        AVLNode<K, V> cur = root;
        AVLNode<K,V> pre = root;
        while (cur != null) {
            pre = cur;
            if (cur.key.compareTo(key) == 0){
                break;
            } else if(cur.key.compareTo(key) < 0) {
                //向右滑
//                pre = cur;
                cur = cur.right;
            } else {
//                pre = cur;
                cur = cur.left;
            }
        }
        return pre;
    }
    public void put(K key, V value) {
        size++;
        add(root, key, value);
    }

}
