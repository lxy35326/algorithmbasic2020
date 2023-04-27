package class02;

public class _493_fanzhuandui {
    public static void main(String[] args) {
        System.out.println(Solution.reversePairs(new int[]{1,3,2,3,1}));
    }
    static class Solution {
        public static int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            return mergeSort(nums, 0, nums.length - 1);
        }

        static int mergeSort(int[] nums, int l, int r) {
            if (l == r) { return 0; }
            int m = l + r >> 1;
            int ans = mergeSort(nums, l, m) + mergeSort(nums, m + 1, r);
            return ans + merge(nums, l, m, r);
        }

        static int merge(int[] nums, int l, int m, int r) {
            int[] help = new int[r - l + 1];
            int count = 0;
            int ans = 0;
            for (int p1 = l, p2 = m + 1; p1 <= m; p1++) {
                while (p2 <= r && nums[p2] * 2 < nums[p1]) {
                    p2++;
                } //p2是第一个不符合的位置
                ans += p2 - m - 1;
            }
            for (int p1 = l, p2 = m + 1; p1 <= m || p2 <= r; count++) {
                if (p2 > r) {
                    help[count] = nums[p1++];
                }
                else if (p1 > m) {
                    help[count] = nums[p2++];
                } else if (nums[p1] <= nums[p2])
                    help[count] = nums[p1++];
                else help[count] = nums[p2++];
            }
            System.arraycopy(help, 0, nums, l, count);
            return ans;
        }
    }
}


