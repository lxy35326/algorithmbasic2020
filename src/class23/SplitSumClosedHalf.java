package class23;

public class SplitSumClosedHalf {

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(3));
        System.out.println(Integer.bitCount(4));
    }

    static int process(int[] arr, int i, int picks, int rest) {

        if (arr.length == i) {
            return picks == 0 ? 0 : -1;
        }
        int p1 =process(arr, i + 1, picks, rest);

        int p2 = -1;
        if (rest - arr[i] >= 0) {
            int temp = process(arr, i + 1, picks - 1, rest - arr[i]);
            if (temp != -1)
                p2 = temp + arr[i];
        }
        return Math.max(p1, p2);

    }

    static int right(int[] arr) {
        if (arr == null || arr.length < 1) return 0;
        int len = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (len % 2 == 0) {
            //如果有偶数个
            return process(arr, 0, len / 2, sum / 2);
        } else {
            //奇数个
            return Math.max(process(arr, 0, len >> 1, sum / 2), process(arr, 0, (len >> 1)  + 1, sum / 2));
        }
    }
}
