package class24;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxArray {
    static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w)
            return null;
        //里面要放下标
        Deque<Integer> qmax = new LinkedList<>();
        int n = arr.length;
        int[] res = new int[n - w + 1];
        int index = 0;

        for (int R = 0; R < n; R++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]){
                qmax.pollLast();
            }
            qmax.offerLast(R);
            if (R - w == qmax.peekFirst()) {
                qmax.pollFirst();
            }
            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;

    }
    public static void main(String[] args) {

    }
}
