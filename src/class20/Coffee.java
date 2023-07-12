package class20;

import java.util.PriorityQueue;

public class Coffee {
    public static void main(String[] args) {
        int[] arr = getArr(new int[]{100, 20}, 6);
        System.out.println(process(6, arr, 1, 10, 0, 0));
    }

    static class Obj implements Comparable<Obj> {
        int time;
        int period;

        Obj(int time, int period) {
            this.time = time;
            this.period = period;
        }

        @Override
        public int compareTo(Obj o) {
            return time + period - (o.time + o.period);
        }
    }

    static int[] getArr(int[] arr, int N) {
        int[] result = new int[N];

        PriorityQueue<Obj> heap = new PriorityQueue<>();
        for (int item : arr) {
            heap.offer(new Obj(0, item));
        }
        for (int i = 0; i < N; i++) {
            Obj peek = heap.poll();
            peek.time += peek.period;
            result[i] = peek.time;
            heap.offer(peek);
        }
        return result;
    }

    //从index位置开始，到所有杯子洗干净至少还要花的时间数
    //timeLine:机器能够使用的时间点
    static int process(int N, int[] arr, int wash, int air, int timeLine, int curIndex) {
        if (curIndex == N) {
            return 0;
        }
        //有两种选择：用机器洗和挥发。
        //1、用机器洗
        int temp = Math.max(arr[curIndex], timeLine) + wash;
        int p1 = Math.max(temp, process(N, arr, wash, air, temp, curIndex + 1));

        //2、挥发
        int p2 = Math.max(process(N, arr, wash, air, timeLine, curIndex + 1), arr[curIndex] + air);
        return Math.min(p1, p2);
    }
}
