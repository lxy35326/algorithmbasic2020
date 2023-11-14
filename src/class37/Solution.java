package class37;

import java.math.BigDecimal;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (double v : solution.medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, 1, 3, -2147483648, -100, 8, 17, 22, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 6)) {
            BigDecimal bigDecimal = new BigDecimal(v);
            System.out.println(bigDecimal.toPlainString());
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        //支持加重复的数
        //支持删除操作
        //支持查找特定位置的数
        int len = nums.length;
        SBT tree = new SBT();
        double[] ans = new double[len - k + 1];
        int count = 0;
        int i;
        for ( i = 0; i < k; i++) {
            tree.root = tree.add(tree.root, new Node(i, nums[i]));
        }
        //是否是偶数
        boolean flag = (k % 2 == 0);
        if (flag) {
            int temp = k / 2;
            int a = temp, b = temp - 1;
            ans[count++] = (tree.getKIndex(tree.root, temp + 1).key.value  + tree.getKIndex(tree.root, b + 1).key.value ) / 2.0 ;
        } else {
            int temp = k - 1 >> 1;
            ans[count++] = tree.getKIndex(tree.root, temp + 1).key.value;
        }

        // i = k
        while (i < len) {
            tree.root = tree.add(tree.root, new Node(i, nums[i]));
            tree.root = tree.delete(tree.root, new Node(i - k, nums[i - k]));
            if (flag) {
                int temp = k / 2;
                int a = temp, b = temp - 1;
                ans[count++] = (tree.getKIndex(tree.root, temp + 1).key.value + tree.getKIndex(tree.root, b + 1).key.value ) / 2.0 ;
            } else {
                int temp = k - 1 >> 1;
                ans[count++] = tree.getKIndex(tree.root, temp + 1).key.value;
            }
            i++;

        }
        return ans;
    }

    static class Node implements Comparable<Node> {
        int index;
        long value;
        @Override
        public int compareTo(Node other) {
            if (value == other.value) {
                return index - other.index;
            }
            return (int)Math.signum(value - other.value);
        }
        Node(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }

    static class SBTNode{
        Node key;
        int size = 1;
        SBTNode left, right;

        SBTNode(Node key){
            this.key = key;
        }

    }

    static class SBT {
        SBTNode root;

        SBTNode leftRotate(SBTNode node) {
            SBTNode right = node.right;
            node.right = right.left;
            right.left = node;
            right.size = node.size;
            node.size = 1 + (node.left == null ? 0 : node.left.size) + (node.right == null ? 0 : node.right.size);
            return right;
        }

        SBTNode rightRotate(SBTNode node) {
            SBTNode left = node.left;
            node.left = left.right;
            left.right = node;
            left.size = node.size;
            node.size = 1 + (node.left == null ? 0 : node.left.size) + (node.right == null ? 0 : node.right.size);
            return left;
        }

        SBTNode maintain(SBTNode node) {
            if (node == null) return node;
            int leftSize = (node.left == null ? 0 : node.left.size);
            int rightSize = (node.right == null ? 0 : node.right.size);
            int ll, lr, rl, rr;
            ll = lr = rl = rr = 0;
            if (node.left != null) {
                if (node.left.left != null) ll = node.left.left.size;
                if (node.left.right != null) lr = node.left.right.size;
            }
            if (node.right != null) {
                if (node.right.left != null) rl = node.right.left.size;
                if (node.right.right != null) rr = node.right.right.size;
            }
            if (leftSize < rr) {
                node = leftRotate(node);
                node.left = maintain(node.left);
                node = maintain(node);
            } else if (leftSize < rl) {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
                node.left = maintain(node.left);
                node.right = maintain(node.right);
                node = maintain(node);
            } else if (rightSize < ll) {
                node = rightRotate(node);
                node.right = maintain(node.right);
                node = maintain(node);
            } else if (rightSize < lr) {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
                node.left = maintain(node.left);
                node.right = maintain(node.right);
                node = maintain(node);
            }

            return node;
        }

        SBTNode delete (SBTNode node, Node key) {
            if (node == null) return node;
            node.size--;
            if (key.compareTo(node.key) < 0) {
                node.left = delete(node.left, key);
            } else if (key.compareTo(node.key) > 0) {
                node.right = delete(node.right, key);
            } else {
                SBTNode left = node.left, right = node.right;
                if (null == right && left == null) {
                    node = null;
                } else if (left != null && right == null) {
                    node = left;
                } else if (right != null && left == null) {
                    node = right;
                } else {
                    SBTNode pre = null, cur = right;
                    cur.size--;
                    while (cur.left != null) {
                        pre = cur;
                        cur = cur.left;
                        cur.size--;
                    }
                    if (pre != null) {
                        pre.left = cur.right;
                        cur.right = right;
                    }

                    cur.left = left;
                    cur.size = cur.left.size + (cur.right == null ? 0 : cur.right.size) + 1;
                    node = cur;
                }
            }
            return node;
        }

        SBTNode getKIndex(SBTNode node, int k) {
            int left = node.left == null ? 0 : node.left.size;
            // int cur = node.size - (node.right == null ? 0 : node.right.size);
            if (k <= left) {
                return getKIndex(node.left, k);
            } else if (k == left + 1) {
                return node;
            } else {
                return getKIndex(node.right, k - left - 1);
            }
        }

        SBTNode add(SBTNode node, Node key) {
            if (node == null) {
                node =  new SBTNode(key);
                return node;
            }
            node.size++;
            if (key.compareTo(node.key) < 0) {
                node.left = add(node.left, key);
            } else if (key.compareTo(node.key) > 0) {
                node.right = add(node.right, key);
            }
            node = maintain(node);
            return node;
        }
    }
}
