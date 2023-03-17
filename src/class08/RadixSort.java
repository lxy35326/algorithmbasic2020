package class08;

import java.util.Arrays;

public class RadixSort {
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 101;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                System.out.println();
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }
    static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    static void radixSort(int[] arr, int start, int end, int maxBits) {
        int[] count = new int[10];
        int len = end - start + 1;
        int[] help = new int[len];
        for (int i = 0; i < maxBits; i++) {
            for (int j = start; j <= end; j++) {
                int t = getDigit(arr[j], i);
                count[t]++;
            }
            for (int j = 1; j < 10; j++) {
                count[j] += count[j - 1];
            }
            for (int j = end; j >= start; j--) {
                int t = getDigit(arr[j],i);
                help[count[t] - 1] = arr[j];
                count[t] --;
            }
            System.arraycopy(help,0,arr,start,len);
            for (int j = 0; j < 10; j++) {
                count[j] = 0;
            }
        }
    }

    static int getDigit(int val, int i) {
        return val / ((int) Math.pow(10, i)) % 10;
    }

    static int maxBits(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        int res = 0;
        while (max != 0) {
            max /= 10;
            res++;
        }
        return res;
    }
}