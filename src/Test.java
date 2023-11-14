class Test{
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.countRangeSum(new int[]{0,0}, 0, 0);
    }
}

class Solution1 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long[] pre = new long[len];
        pre[0] = nums[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        return (int)mergeSort(pre, 0, len - 1, lower, upper);
    }

    long mergeSort(long[] arr, int l, int r, int lower, int upper){
        if (l == r) {
            if (arr[l] >= lower && arr[l] <= upper)
                return 1;
            return 0;
        }
        int m = l + (r - l >> 1);
        return mergeSort(arr, l, m, lower, upper) + mergeSort(arr, m + 1, r, lower, upper) + merge(arr, l, m, r, lower, upper);
    }

    long merge(long[] arr, int l, int m, int r, int lower, int upper) {
        int len = r - l + 1;
        long[] help = new long[len];
        int i = l, j;
        int ll, rr;
        long ans = 0;
        ll = rr = m + 1;
        for (; i <= m; i++) {
            long lo = lower + arr[i];
            long hi = upper + arr[i];
            while (ll <= r && arr[ll] <= lo) {
                ll++;
            } // ll = r + 1

            while (rr <= r && arr[rr] <= hi ) {
                rr++;
            }
            ans += (rr - ll);
        }
        int count = 0;

        i = l;
        j = m + 1;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                help[count++] = arr[i++];
            } else  {
                help[count++] = arr[j++];
            }
        }
        while (i <= m) {
            help[count++] = arr[i++];
        }

        while (j <= r) {
            help[count++] = arr[j++];
        }

        System.arraycopy(help, 0, arr, l, len);
        return ans;
    }
}