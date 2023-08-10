package class25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.sql.Array;
import java.util.*;

public class Code01_MonotonousStack {

    public static int[][] getNearLessNoRepeat1(int[] arr) {
        int[][] res = new int[arr.length][2];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int now = stack.pop();
                Integer left = stack.peek();
                int l = left == null ? -1 : left;
                res[now][1] = i;
                res[now][0] = l;
            }
            stack.push(i);
        }
        //上面是遍历过程
        //[0,1]
        //下面是如果遍历完成之后，栈中还有元素的情况
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            res[cur][1] = -1;
            Integer left = stack.peek();
            int l = left == null ? -1 : left;
            res[cur][0] = l;

        }
        return res;
    }

    // arr = [ 3, 1, 2, 3]
    //         0  1  2  3
    //  [
    //     0 : [-1,  1]
    //     1 : [-1, -1]
    //     2 : [ 1, -1]
    //     3 : [ 2, -1]
    //  ]
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        // 只存位置！
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) { // 当遍历到i位置的数，arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[j][0] = leftLessIndex;
                res[j][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[j][0] = leftLessIndex;
            res[j][1] = -1;
        }
        return res;
    }


    public static int[][] getNearLess1(int[] arr) {
        int[][] res = new int[arr.length][2];
        Deque<List<Integer>> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> now = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer integer : now) {
                    res[integer][1] = i;
                    res[integer][0] = left;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                //小于
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer i : cur) {
                res[i][1] = -1;
                res[i][0] = left;
            }
        }
        return res;
    }


    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) { // i -> arr[i] 进栈
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }

    // for test
    public static int[] getRandomArrayNoRepeat(int size) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int swapIndex = (int) (Math.random() * arr.length);
            int tmp = arr[swapIndex];
            arr[swapIndex] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    // for test
    public static int[] getRandomArray(int size, int max) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
        }
        return arr;
    }

    // for test
    public static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[][] res1, int[][] res2) {
        if (res1.length != res2.length) {
            return false;
        }
        for (int i = 0; i < res1.length; i++) {
            if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
                return false;
            }
        }

        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[][] he(int[] nums) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int length = Integer.parseInt(br.readLine());
//		String[] strs = br.readLine().split(" ");
//		int[] nums = new int[strs.length];
//		for(int i=0;i<strs.length;i++){
//			nums[i] = Integer.parseInt(strs[i]);
//		}
        boolean L_flag = true, R_flag = true;
        int[][] res = new int[nums.length][2];
//		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int L = i - 1, R = i + 1; ; ) {
                if (L < 0 && L_flag) {
                    L_flag = false;
                    L = -1;
                }
                if (R >= nums.length && R_flag) {
                    R_flag = false;
                    R = -1;
                }
                if (L_flag && nums[L] < nums[i]) {
                    L_flag = false;
                }
                if (R_flag && nums[R] < nums[i]) {
                    R_flag = false;
                }
                if (L_flag) {
                    L--;
                }
                if (R_flag) {
                    R++;
                }
                if (!L_flag && !R_flag) {
                    res[i][0] = L;
                    res[i][1] = R;
                    L_flag = true;
                    R_flag = true;
                    break;
                }
            }
        }
//		System.out.print(sb.toString());
        return res;
    }

    public static int[][] my(int[] arr) throws IOException {
//		StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
////		StringBuilder sb = new StringBuilder();
//		st.nextToken();
//		int n = (int) st.nval;
////		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			st.nextToken();
//			arr[i] = (int) st.nval;
//		}
        int n = arr.length;
        int[][] res = new int[n][2];
        Deque<List<Integer>> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer item : cur) {
                    res[item][1] = i;
                    res[item][0] = left;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                //加入一个链表
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer item : cur) {
                res[item][1] = -1;
                res[item][0] = left;
            }
        }

        return res;

    }

    public static void main(String[] args) throws IOException {
        int size = 1000000;
        int max = 2000000;
        int testTimes = 500;
        System.out.println("测试开始");

//		int[][] res = getNearLessNoRepeat1(new int[]{0,1});
//		for (int[] re : res) {
//			System.out.println(Arrays.toString(re));
//		}
        long my = 0;
        long he = 0;
        for (int i = 0; i < testTimes; i++) {
//			System.out.println(i);
//            int[] arr1 = getRandomArrayNoRepeat(size);
            int[] arr2 = getRandomArray(size, max);
            long l = System.currentTimeMillis();
            my(arr2);
            long l1 = System.currentTimeMillis();
            my += l1 - l;

            long r = System.currentTimeMillis();
            he(arr2);
            long r1 = System.currentTimeMillis();
            he += r1 - r;
//            if (!isEqual(getNearLessNoRepeat(arr1), rightWay(arr1))) {
//                System.out.println("Oops!");
//                printArray(arr1);
//                break;
//            }
//			if (!isEqual(my(arr1), he(arr1))) {
//				System.out.println("Oops!");
//				printArray(arr1);
//				break;
//			}
//			if (!isEqual(getNearLessNoRepeat1(arr1), rightWay(arr1))) {
//				System.out.println("Oops111!");
//				printArray(arr1);
//				break;
//			}
//            if (!isEqual(getNearLess(arr2), rightWay(arr2))) {
//                System.out.println("Oops!");
//                printArray(arr2);
//                break;
//            }
//			if (!isEqual(getNearLess1(arr2), rightWay(arr2))) {
//				System.out.println("Oops222!");
//				printArray(arr2);
//				break;
//			}
        }
        System.out.println("my:" + my);
        System.out.println("he:" + he);
        System.out.println("测试结束");
    }
}
