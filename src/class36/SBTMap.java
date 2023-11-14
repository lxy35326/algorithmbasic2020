package class36;

public class SBTMap<K extends Comparable<K>, V> {
    SBTNode<K, V> root;

    static class SBTNode<K extends Comparable<K>, V> {
        K key;
        V value;
        SBTNode<K, V> left, right;
        int size = 1;

        SBTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    void update(SBTNode<K, V> node) {
        node.size = (node.left == null ? 0 : node.left.size) + (node.right == null ? 0 : node.right.size);
    }

    SBTNode<K, V> leftRotate(SBTNode<K, V> node) {
        SBTNode<K, V> right = node.right;
        node.right = right.left;
        right.left = node;
        right.size = node.size;
        update(node);
        return right;
    }

    SBTNode<K, V> rightRotate(SBTNode<K, V> node) {
        SBTNode<K, V> left = node.left;
        node.left = left.right;
        left.right = node;
        left.size = node.size;
        update(node);
        return left;
    }

    SBTNode<K, V> maintain(SBTNode<K, V> node) {
        if (node == null) return null;
        int leftSize = node.left == null ? 0 : node.left.size;
        int rightSize = node.right == null ? 0 : node.right.size;
        int leftLeftSize = node.left == null ? 0 : node.left.left == null ? 0 : node.left.left.size;
        int leftRightSize = 0;
        if (node.left != null && node.left.right != null)
            leftRightSize = node.left.right.size;
        int rightRightSize = 0;
        if (node.right != null && node.right.right != null) rightRightSize = node.right.right.size;
        int rightLeftSize = 0;
        if (node.right != null && node.right.left != null) rightLeftSize = node.right.left.size;
        if (leftSize < rightRightSize) {
            node = leftRotate(node);
            node.left = maintain(node.left);
            node = maintain(node);
        } else if (leftSize < rightLeftSize) {
            node.right = rightRotate(node.right);
            node = leftRotate(node);
            node.left = maintain(node.left);
            node.right = maintain(node.right);
            node = maintain(node);
        } else if (rightSize < leftLeftSize) {
            node = rightRotate(node);
            node.right = maintain(node.right);
            node = maintain(node);
        } else if (rightSize < leftRightSize) {
            node.left = leftRotate(node.left);
            node = rightRotate(node);
            node.left = maintain(node.left);
            node.right = maintain(node.right);
            node = maintain(node);
        }
        return node;
    }

    /**
     * 插入过程中的最后一个经过的点，就是要进行操作的点
     *
     * @param key key
     * @return 点
     */
    private SBTNode<K, V> findLastIndex(K key) {
        SBTNode<K, V> cur = root, pre = null;
        while (cur != null) {
            pre = cur;
            if (cur.key.compareTo(key) == 0) {
                break;
            } else if (cur.key.compareTo(key) < 0) {
                cur = cur.right;
            } else cur = cur.left;
        }
        return pre;
    }

    /**
     * 找到在查找过程中的最后一个大于key的节点
     *
     * @param key
     * @return
     */
    private SBTNode<K, V> findLastNoSmallIndex(K key) {
        SBTNode<K, V> cur = root;
        SBTNode<K, V> pre = null;
        while (cur != null) {
            if (key.compareTo(cur.key) == 0) {
                pre = cur;
                break;
            } else if (key.compareTo(cur.key) > 0) {
                cur = cur.right;
            } else {
                pre = cur;
                cur = cur.left;
            }
        }
        return pre;
    }

    private SBTNode<K, V> findLastNoBigIndex(K key) {
        SBTNode<K, V> cur = root;
        SBTNode<K, V> pre = null;
        while (cur != null) {
            if (key.compareTo(cur.key) == 0) {
                pre = cur;
                break;
            } else if (key.compareTo(cur.key) > 0) {
                pre = cur;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return pre;
    }

    private SBTNode<K, V> add(SBTNode<K, V> node, K key, V value) {
        if (node == null) {
            return new SBTNode<>(key, value);
        }
        node.size++;
        //不可以加重复的值
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }
        node = maintain(node);
        return node;
    }

    //这个方法存疑
    private SBTNode<K, V> delete(SBTNode<K, V> node, K key) {
        if (node == null) return null;
        node.size--;
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left == null) {
            //如果右侧不为空
            node = node.right;
        } else if (node.right == null) {
            node = node.left;
        } else {
            //两侧全不为空
            SBTNode<K, V> cur = node, pre = null;
            cur = node.right;
            while (cur.left != null) {
                pre = cur;
                cur.size--;
                cur = cur.left;
            }
            //目前cur是最左侧的节点
            if (pre != null) {
                pre.left = cur.right;
                cur.right = node.right;
            }

            cur.left = node.left;
            cur.size = node.size;
            node = cur;
        }
        return node;
    }

    private SBTNode<K, V> getIndex(SBTNode<K, V> node, int kth) {
        int temp = (node.left == null ? 0 : node.left.size);
        if (kth == temp + 1) {
            return node;
        } else if (kth <= temp) {
            return getIndex(node.left, kth);
        } else {
            return getIndex(node.right, kth - temp - 1);
        }
    }

    public int getSize() {
        return root == null ? 0 : root.size;
    }

    public boolean containsKey(K key) {
        if (key == null)
            throw new RuntimeException("key不能为null");
        SBTNode<? extends K,?> lastIndex = findLastIndex(key);
        if (lastIndex == null || lastIndex.key.compareTo(key) != 0) {
            return false;
        }
        return true;
    }
}
