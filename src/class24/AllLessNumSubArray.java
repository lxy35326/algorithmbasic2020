package class24;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class AllLessNumSubArray {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int num = (int)st.nval;
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            arrs[i] = (int)st.nval;
        }
        int count = 0;
        int R = 0;

        Deque<Integer> qmax = new LinkedList<>();
        Deque<Integer> qmin = new LinkedList<>();
        for (int L = 0; L < n; L++) {
            while (R < n) {
                while (!qmax.isEmpty() && arrs[qmax.peekLast()] <= arrs[R]) {
                    qmax.pollLast();
                }
                qmax.offerLast(R);
                while (!qmin.isEmpty() && arrs[qmin.peekLast()] >= arrs[R]) {
                    qmin.pollLast();
                }
                qmin.offerLast(R);
                if (arrs[qmax.peekFirst()] - arrs[qmin.peekFirst()] <= num) {
                    R++;
                } else {
                    break;
                }
            }

            count += R - L;
            if(qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
        }
        System.out.println(count);
    }
}
