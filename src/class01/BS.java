package class01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BS {
    public static int binarySearch(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0, R = arr.length - 1;
        while (L <= R) {
            int M = L + (R - L >> 1);
            if (arr[M] == key) return M;
            else if (arr[M] > key) R = M - 1;
            else L = M + 1;
        }
        return -1;
    }

    //for test
    static int test(int[] arr, int key) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    //for test
    static int[] generateRandomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int temp =  (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            while (set.contains(temp)) {
                temp =  (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            }
            set.add(temp);
            arr[i] = temp;
        }
        return arr;
    }

    //for test
    public static void main(String[] args) {
        int testTime = 50_000_0;
        int maxSize = 20;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int key = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr,key) != binarySearch(arr,key))
            {
                System.out.println("failed! test:" + test(arr,key) +", bs : "+binarySearch(arr,key) + " " + i);
                System.out.println("---");
                System.out.println(key);
                System.out.println("---");
                for (int i1 : arr) {
                    System.out.println(i1);
                }
                return ;
            }
        }
        System.out.println("Success!");
    }
}
