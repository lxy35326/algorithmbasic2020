import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
//        A.add(3);
        A.add(2);
        A.add(1);
        A.add(0);

//        s.hanota2(A.size(),A, B, C);
        s.hanota(A, B, C);
    }

    static class Solution {

        void hanota2(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
            if (size == 1) {
                C.add(A.remove(A.size() - 1));
                return;
            }
            hanota2(size - 1, A, C, B);
            hanota2(1, A, B, C);
            if (B.size() == 3 && C.size() == 1){
                System.out.println(1);
            }
            hanota2(size - 1, B, A, C);
        }

        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            System.out.println("-----------");
            System.out.println("A:" + A);
            System.out.println("B:" + B);
            System.out.println("C:" + C);
            if (A == null || A.size() < 1) return;
            else if (A.size() == 1) {
                C.add(A.remove(0));
                System.out.println("-----------");
                System.out.println("A:" + A);
                System.out.println("B:" + B);
                System.out.println("C:" + C);
            } else {
                //后面的n个from -> other
                //1个from -> to
                //n个other -> to
                int t = A.remove(0);
                hanota(A, C, B);
                C.add(t);
                System.out.println("-----------");
                System.out.println("A:" + A);
                System.out.println("B:" + B);
                System.out.println("C:" + C);
                if (C.size() == 1 && B.size() == 3) {
                    System.out.println(1);
                }
                hanota(B, A, C);
            }
        }
    }
}
