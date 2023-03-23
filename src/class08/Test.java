//package class08;
//
//import java.io.File;
//class ListNode{
//    int val;
//    ListNode next;
//
//    public ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
////        int res = 0;
////        for (int i = 1; i <= 100000; i++) {
////            res += func(i);
////        }
////        System.out.println(res);
////
////        System.out.println( (int)Math.pow(9,5));
////        System.out.println(System.getProperty("file.separator"));
////        System.out.println(File.separatorChar);
////        System.out.println(File.pathSeparator);
////        System.out.println(System.getProperty("user.dir"));
//        ListNode head = new ListNode(3,null);
//        ListNode h1 = new ListNode(2,null);
//        ListNode h2 = new ListNode(0,null);
//        ListNode h3 = new ListNode(-4,null);
//        head.next = h1;
//        h1.next=h2;
//        h2.next=h3;
//        h3.next=h1;
//        detectCycle(head);
//
//    }if (head == null) return null;
//    ListNode slow = head, fast = head;
//        while ( fast != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//        if (slow == fast) {
//            fast = head;
//            while (fast != slow) {
//                slow = slow.next;
//                fast = fast.next;
//            }
//            return slow;
//        }
//    }
//        return null;
//
//    public static ListNode detectCycle(ListNode head) {
//
//
//    }
//
//    static int func(int val) {
//        int res = 0;
//        int p = val;
//        int r = 0;
//        while (p != 0) {
//            res++;
//            p /= 10;
//        }
//        for (int i = 0; i < res; i++) {
//            if (val / ((int) Math.pow(10, i)) % 10 == 9) {
//                r++;
//            }
//        }
//        return r;
//    }
//}
