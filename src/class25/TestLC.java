package class25;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import static java.lang.Math.max;

class Solution {
    public static  int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        int[][] ans = new int[len][2];
        int[] sums = new int[len + 2];

        int[] stack = new int[len];
        int top = -1;
        int result = 0;
        //sums[i]的意义为：arr[0] + ... + arr[i - 1]
        for (int i = 0; i < len + 1; i++) {
            if (i < len)
                sums[i + 1] = sums[i] + nums[i];
            int temp = i == len ? 0 : nums[i];
            while (top != -1 && nums[stack[top]] >= temp) {
                int cur = stack[top--];
                //右侧就是i的位置，i的位置到达不了
                int left = top == -1 ? -1 : stack[top];
                //左侧就是left的位置，left的位置也到达不了
                //子数组的范围是nums[left + 1] - nums[i - 1], 也就是sums[i] - sums[left + 2]
                //left = -1时，sums[left + 2] = sums[1]，符合
                //i
                result = Math.max(result, nums[cur] * (sums[i] - sums[left + 1]));
            }
            stack[++top] = i;
        }
        return result;

    }
}

public class TestLC {
    public static void main(String[] args) {
        int[] nums = new int[]{ 2, 3,3,1, 2};
        int len = nums.length;
        System.out.println(Solution.maxSumMinProduct(nums));
        System.out.println();
        //注意， 两个数组的0位置都不用，用到的位置从1开始
        int[][] res = new int[len][2];
        int[] arr = new int[len + 1];


        Deque<Integer> stack = new LinkedList<>();
        //arr数组的下标是从0-len  arr[i]: 0-i-1下标的前缀和
        for (int i = 1; i < len + 1; i++) {
            arr[i] = arr[i - 1] + nums[i - 1];
            //遍历原数组的时候，用i - 1作下标就可以
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i - 1]) {
                int cur = stack.pop();
                res[cur][1] = i - 1;
                int left = stack.isEmpty() ? -1 : stack.peek();
                res[cur][0] = left;
            }
            stack.push(i - 1);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            res[cur][1] = -1;
            int left = stack.isEmpty() ? -1 : stack.peek();
            res[cur][0] = left;
        }
        System.out.println("arr数组为：" + Arrays.toString(arr));
        System.out.println("Res数组为：");
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
        long r = 0;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            int left = res[i][0];// left + 1下标处能取到
            int right = res[i][1]; //right - 1处能取到 【right - 1, left + 1】
            // arr[right - 1] - arr[left]
            if (right == -1) right = len;
            long sum = arr[right] - arr[left + 1];
            long temp = sum * min;
            if (r < temp) r = temp;
        }
        System.out.println(r % (int) (Math.pow(10, 9) + 7));
        System.out.println((int) Math.pow(10, 9));
        System.out.println(Integer.MAX_VALUE);
    }

}
