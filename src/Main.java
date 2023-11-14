public class Main {

    static class Solution {
        public static int countRangeSum(int[] nums, int lower, int upper) {
            long[] arr = new long[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                arr[i] = arr[i - 1] + nums[i - 1];
            }
            //arr[i]代表[0, i-1]
            return mergeSort(arr, 0, nums.length, nums.length >> 1, lower, upper);
        }

        static int mergeSort(long[] arr, int l, int r, int m, int lower, int upper) {
            if (l == r) {
                return lower <= arr[l] && upper >= arr[l] ? 1 : 0;
            }
            return mergeSort(arr, l, m, l + (m- l >> 1), lower, upper) +
                    mergeSort(arr, m + 1, r, m + 1 + (r - m - 1 >> 1), lower, upper) +
                    process(arr, l, r, m, lower, upper);
        }

        static int process(long[] arr, int l, int r, int m, int lower, int upper) {
            int len = r - l + 1;
            long[] help = new long[len];
            int count = 0,i = l, j = m + 1;
            int ans = 0;
            while (i <= m && j <= r) {
                long temp = arr[j] - arr[i];
                if (temp >= lower && temp <= upper) {
                    ans++;
                }
                if (arr[i] <= arr[j]) {
                    help[count++] = arr[i++];
                } else {
                    help[count++] = arr[j++];
                }
            }

            while (i <= m) {
                long temp = arr[r] - arr[i];
                if (temp >= lower && temp <= upper) {
                    ans++;
                }
                help[count++] = arr[i++];

            }

            while (j <= r) {
                long temp = arr[j] - arr[m];
                if (temp >= lower && temp <= upper) {
                    ans++;
                }
                help[count++] = arr[j++];
            }

            System.arraycopy(help, 0, arr, l, len);
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution.countRangeSum(new int[]{0},0,0);
    }





























    static class Printer {
        private boolean isHelloPrinted = false;

        public synchronized void printHello() {
            while (isHelloPrinted) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("hello");
            isHelloPrinted = true;
            notify();
        }

        public synchronized void printWorld() {
            while (!isHelloPrinted) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("world");
            isHelloPrinted = false;
            notify();
        }
    }

    static class HelloRunnable implements Runnable {
        private final Printer printer;

        public HelloRunnable(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                printer.printHello();
            }
        }
    }

    static class WorldRunnable implements Runnable {
        private final Printer printer;

        public WorldRunnable(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                printer.printWorld();
            }
        }
    }
}
