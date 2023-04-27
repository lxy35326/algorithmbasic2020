package class05;

import java.util.Arrays;

public class QuickSort {
    static void swap(int[] arr, int l, int r) {
        if (l != r) {
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];
        }
    }

    static int[] netherlandsFlag(int[] arr, int l, int r) {
        int slow = l, fast = r - 1;
        int pivot = arr[r];
        for (int i = l; i < r; ) {
            if (arr[i] < pivot) {
                swap(arr, slow++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, fast--, i);
            } else {
                i++;
            }
        }
        swap(arr, fast + 1, r); //fast是等于区的最后一个位置
        return new int[]{slow, fast};
    }

    static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        process(nums, 0, nums.length - 1);
    }

    static void process(int[] nums, int l, int r) { // 0 2, 1 3
        if (l >= r) return;
        swap(nums, r, (int) (Math.random() * (r - l + 1)) + l);
        int[] equalArea = netherlandsFlag(nums, l, r);
        process(nums, l, equalArea[0] - 1);
        process(nums, equalArea[1] + 1, r);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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
        quickSort(new int[]{5,2,3,1,4});
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            int[] arr3 = copyArray(arr1);
            Arrays.sort(arr1);
            quickSort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }
}
