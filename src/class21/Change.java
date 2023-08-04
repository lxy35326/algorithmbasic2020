package class21;

public class Change {
    //0-1背包问题，求需要的最少货币数
    static int func(int[] arr, int aim) {
        if (arr == null || arr.length < 1 || aim == 0) return 0;
        return process(arr, 0, aim);
    }
    static int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        int len = arr.length;
        if (index == len) {
            return -1;
        }
        int p1 = process(arr, index + 1, rest);
        int temp =  process(arr, index + 1, rest - arr[index]);
        if (temp != -1)
            temp += 1;
        int ans = Integer.MAX_VALUE;
        if (p1 != -1) {
            ans = p1;
        }
        if (temp != -1) {
            ans = Math.min(ans, temp);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
//    static int dp(int[] arr, int aim) {
//        if (arr == null || arr.length < 1 || aim == 0) return 0;
//        int len = arr.length;
//
//    }
    public static void main(String[] args) {
        System.out.println(func(new int[]{1,1,2,2,1,1},4));
    }
}
