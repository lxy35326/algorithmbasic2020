package class13;

import class14.UnionFind;

public class TestCBT {
    static class TreeNode{
        TreeNode left,right;
        int val;

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static TreeNode t;
    /**
     * [1,2,3,4,5,6]
     * [1,2,3,4,5,6,7,8,9,10,11,12,13,null,null,15]
     * @param args
     */
    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        TreeNode _6 = new TreeNode(6);
        TreeNode _7 = new TreeNode(7);
        TreeNode _8 = new TreeNode(8);
        TreeNode _9 = new TreeNode(9);
        TreeNode _10 = new TreeNode(10);
        TreeNode _11= new TreeNode(11);
        TreeNode _12= new TreeNode(12);
        TreeNode _13 = new TreeNode(13);
        TreeNode _15 = new TreeNode(15);
        _1.left=_2;
        _1.right=_3;
        _2.left=_4;
        _2.right=_5;
        _3.left=_6;
        _3.right=_7;
        _4.left=_8;
        _4.right=_9;
        _5.left=_10;
        _5.right=_11;
        _6.left=_12;
        _6.right = _13;
        _8.left=_15;
        t =_1;
        System.out.println(isCompleteTree(_1));


    }
    static class Info{
        boolean man;
        boolean wanquan;
        int ceng;
        Info(boolean man, boolean wanquan, int ceng) {
            this.man = man;
            this.wanquan = wanquan;
            this.ceng = ceng;
        }
    }
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        return method(root).wanquan;
    }
    static Info method(TreeNode root){
        if (root == null) return null;
        if(root == t)
        {
            System.out.println(1);
        }
        Info left = method(root.left);
        Info right = method(root.right);
        boolean man = false;
        boolean wanquan = false;
        int ceng = 0;
        if (left == null) {
            if (right == null) {
                man = wanquan = true;
                ceng = 1;
            }
            else {
                man = wanquan = false;
                ceng = right.ceng + 1;
            }
        }
        //如果左侧满
        else if (left.man) {
            if (right == null) {
                if (left.ceng == 1) {
                    wanquan = true;
                    man = false;
                    ceng = 2;
                } else {
                    man = wanquan = false;
                    ceng = left.ceng + 1;
                }
            }
            else if (right.man) {
                if(left.ceng == right.ceng)
                {
                    wanquan = man = true;
                    ceng = left.ceng + 1;
                } else if(left.ceng == right.ceng + 1){
                    man = false;
                    wanquan = true;
                    ceng = left.ceng + 1;
                } else {
                    man = wanquan = false;
                    ceng = Math.max(left.ceng, right.ceng ) + 1;
                }
            } else if (right.wanquan) {
                if (left.ceng == right.ceng) {
                    man = false;
                    wanquan = true;
                    ceng = left.ceng + 1;
                } else {
                    man = false;
                    wanquan = false;
                    ceng = Math.max(left.ceng, right.ceng ) + 1;
                }
            } else {
                man = false;
                wanquan = false;
                ceng = Math.max(left.ceng, right.ceng) + 1;
            }
        }
        else if (left.wanquan) {
            if (right == null) {
                ceng = left.ceng + 1;
                wanquan = man = false;

            }
            else if (right.man == true && right.ceng == left.ceng - 1) {
                ceng = left.ceng + 1;
                wanquan = true;
                man = false;
            } else {
                wanquan = man = false;
                ceng = Math.max(left.ceng, right.ceng) + 1;
            }
        }
        else {
            //也不满，也不完全
            wanquan = man = false;
            ceng = Math.max(left.ceng, right.ceng) + 1;
        }

        return new Info(man, wanquan, ceng);
    }
}
