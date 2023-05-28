package class12;

import java.awt.*;
import java.awt.event.ActionListener;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class A {
    int m;

    int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }
}

class B extends A {
    int m;


    public int getM() {
        return m - 5;
    }
}
class Mammal{
    Mammal(){
        System.out.println("Four");
    }
}
class Dog extends Mammal{
    Dog(){
        System.out.println("Three");
    }
    Dog(String n) {
        System.out.println(n);
    }
}
class HotDog extends Dog{
    HotDog(){
        super("Two");
        System.out.println("One");
    }


}
class Solution {
    static int a = 1;

    public static void main(String[] args) {
        HotDog h = new HotDog();
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        TreeNode _6 = new TreeNode(6);
        TreeNode _7 = new TreeNode(7);
        TreeNode _8 = new TreeNode(8);
        TreeNode _0 = new TreeNode(0);
        _3.left = _5;
        _3.right = _1;
        _1.right = _8;
        _1.left = _0;
        _5.left = _6;
        _5.right = _2;
        _2.right = _4;
        _2.left = _7;
        lowestCommonAncestor(_3, _5, _4);
    }

    static class Info {
        boolean findA;
        boolean findB;
        TreeNode root;

        Info(boolean findA, boolean findB, TreeNode root) {
            this.findA = findA;
            this.findB = findB;
            this.root = root;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        return process(root, p, q).root;
    }

    static Info process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Info(false, false, null);
        }
        Info left = process(root.left, p, q);
        Info right = process(root.right, p, q);
        boolean findA = false, findB = false;
        TreeNode ans = null;
        if (left.findA || right.findA || root == p) {
            findA = true;
        }

        if (right.findB || left.findB || root == q) {
            findB = true;
        }
        if (left.root != null) {
            ans = left.root;
        } else if (right.root != null) {
            ans = right.root;
        }
        //这里这么判断有问题，可能左侧也找不到A也找不到B
//        else if (left.findA && (right.findB || root == q)) {
//            ans = root;
//        } else if (left.findB && (right.findA || root == p)) {
//            ans = root;
//        }
        return new Info(findA, findB, ans);

    }
}
