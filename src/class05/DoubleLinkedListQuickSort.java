//package class05;
//
//
///**
// * 快排的思想：
// * 随机选取一个轴值，然后将轴值与最后一个位置交换。进行排序。
// * 排序完成之后，对左部分和右部分循环进行该过程。
// * 该代码作废
// */
//public class DoubleLinkedListQuickSort {
//    static class Node {
//        int value;
//        Node pre;
//        Node next;
//
//        Node(int v) {
//            value = v;
//        }
//    }
//
//    static class HeadTail {
//        Node head;
//        Node tail;
//
//        HeadTail(Node head, Node tail) {
//            this.head = head;
//            this.tail = tail;
//        }
//    }
//
//    static Node quickSort(Node h) {
//        if (h == null) return null;
//        int count = 0;
//        Node cur = h;
//        Node end = null;
//        while (cur != null) {
//            count++;
//            end = cur;
//            cur = cur.next;
//        }
//        return process(h, end, count).head;
//    }
//
//    static HeadTail process(Node start, Node end, int count) {
//        if (count == 1) {
//            return new HeadTail(start, start);
//        }
//
//        int randomIndex = (int) (Math.random() * count);
//        Node randomNode = start;
//        while (randomIndex-- != 0) {
//            randomNode = randomNode.next;
//        }
//        return null;
//    }
//
//    static class Info {
//        Node lh, lt, gh, gl, eh, el;
//        int ls, gs;
//
//        Info(Node lh, Node lt, Node gh, Node gl, Node eh, Node el, int ls, int gs) {
//            this.lh = lh;
//            this.lt = lt;
//            this.gh = gh;
////            this.gl = gl;
//            this.eh = eh;
//            this.el = el;
//            this.ls = ls;
//            this.gs = gs;
//        }
//    }
//
//    static Info partition(Node start, Node pivot) {
//        Node lh, lt, gh, gl, eh, el;
//        int ls, gs;
//        lh = lt = gh = gl = eh = el = null;
//        gs = ls = 0;
//
//        return null;
//    }
//}
