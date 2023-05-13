package class08;

import Utils.Util;

import java.util.Arrays;

/**
 * 这里面包含基数排序，shell排序，计数排序
 */
public class CountSort {
    static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int path = len / 2; path >= 1; path /= 2) {
            for (int i = path; i < len; i++) {
                for (int j = i - path; j > -1 && arr[j] > arr[j + path]; j -= path) {
                    Util.swap(arr, j, j + path);
                }
            }
        }
    }

    static void shellSort2(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int len = arr.length;
        for (int gap = len / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j -= gap) {
                    Util.swap(arr,j,j+gap);
                }
            }
        }
    }

    static void radixSort(int[] arr) {

        if (arr == null || arr.length < 2)
            return;
//        System.out.println("--------------------------");
        int len = arr.length;
        int[] help = new int[len];
        int max = arr[0];
        for (int i = 0; i < len; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        int maxBits = 0;
        while (max != 0) {
            maxBits++;
            max /= 10;
        }
//        System.out.println(maxBits+"----");
        //maxBits代表最多是几位数
        int[] buckets = new int[10];
        for (int i = 0; i < maxBits; i++) {
            for (int item : arr) {
                int t = item / (int) Math.pow(10, i) % 10;
                buckets[t]++;
            }
            for (int j = 1; j < 10; j++) {
                buckets[j] = buckets[j - 1] + buckets[j];
            }

            for (int j = len - 1; j > -1; j--) {
                int t = arr[j] / (int) Math.pow(10, i) % 10; // t = 1 buckets[1] = 2
                help[buckets[t] - 1] = arr[j];
                buckets[t]--;
            }
            for (int j = 0; j < 10; j++) {
                buckets[j] = 0;
            }
            System.arraycopy(help, 0, arr, 0, len);
        }
    }

    // only for 0-200
    static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int len = arr.length;
        int max = arr[0];
        for (int i = 1; i < len; i++)
            if (max < arr[i]) max = arr[i];
        int[] bucket = new int[max + 1];
        for (int item : arr) {
            bucket[item]++;
        }
        int count = 0;
        for (int i = 0; i < max + 1; i++) {
            while (bucket[i]-- != 0) {
                arr[count++] = i;
            }
        }
    }

    //only for test
    static int[] generateArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr2 == arr1;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;


    }

    public static void main(String[] args) {
        int testTimes = 10_000_00;
        int maxSize = 100;
        int maxValue = 200;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            Arrays.sort(arr1);
//            countSort(arr2);
//            radixSort(arr2);
            shellSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                for (int i1 : arr2) {
                    System.out.println(i1);
                }
                System.out.println("Fucked!");
                return;
            }
        }
        System.out.println("Nice!");
    }
}
