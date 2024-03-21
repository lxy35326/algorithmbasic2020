package Utils;

public class Util {
    public static int[] generateArray(int len, int maxValue) { // [-maxValue, maxValue - 1] = [-maxValue, 0] + [0,maxValue - 1] [0,maxValue]
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }
    public static int[] copyArray(int[] arr){
        int[] res = null;
        if (arr != null){
            res = new int[arr.length];
            System.arraycopy(arr,0,res,0,arr.length);
        }
        return res;
    }

    public static boolean isSame(int[] a, int[] b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        int aLen = a.length, bLen = b.length;
        if (aLen != bLen) return false;
        for (int i = 0; i < aLen; i++) {
            if (a[i] != b[i]) {
               return false;
            }
        }
        return true;
    }
    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
