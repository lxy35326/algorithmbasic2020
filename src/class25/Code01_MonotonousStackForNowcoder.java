package class25;

// 测试链接 : https://www.nowcoder.com/practice/2a2c00e7a88a498693568cef63a4b7bb
// 如果在牛客上做题，可以用如下的方式来做
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交如下的代码，并把主类名改成"Main"
// 可以直接通过
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code01_MonotonousStackForNowcoder {

	public static int[] arr = new int[1000000];
	public static int[][] ans = new int[1000000][2];
	// stack1 : 相等值的位置也放
	// stack2 : 只放不相等值的最后一个位置
	// 比如 : arr = { 3, 3, 3, 4, 4, 6, 6, 6}
	//          位置  0  1  2  3  4  5  6  7
	// 如果位置依次压栈，
	// stack1中的记录是（位置） : 0 1 2 3 4 5 6 7
	// stack2中的记录是（位置） : 2 4 7
	public static int[] stack1 = new int[1000000];
	public static int[] stack2 = new int[1000000];

	public static void main(String[] args) throws IOException {
		arr = new int[]{1,2,3,2};
		ans = new int[4][2];
		my(4);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StreamTokenizer in = new StreamTokenizer(br);
//		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//		while (in.nextToken() != StreamTokenizer.TT_EOF) {
//			int n = (int) in.nval;
//			for (int i = 0; i < n; i++) {
//				in.nextToken();
//				arr[i] = (int) in.nval;
//			}
//			getNearLess(n);
//			for (int i = 0; i < n; i++) {
//				out.println(ans[i][0] + " " + ans[i][1]);
//			}
//			out.flush();
//		}
	}

	public static void my(int n) {
		//思路：stack1中不管重复与否，都放
		//stack2中，只放重复值的最后一个下标。
		//这样可以达成什么效果?
		//判断左侧最小值的话：如果stack2中的个数小于2，说明没有左侧
		//判断右侧最小值的话：不用判断
		//相等的情况：如果遇见栈顶的元素与当前元素相等的话，需要更新stack2中的最后一个值，
		//先考虑这么多吧，后续的代码细节遇到再说

		int stackSize1, stackSize2;
		stackSize1 = stackSize2 = 0;
		for (int i = 0; i < n; i++) {
			//如果栈1不空且大于当前值
			while (stackSize1 != 0 && arr[stack1[stackSize1 - 1]] > arr[i]) {
				//取出上一个元素
				int cur = stack1[stackSize1 - 1];
				stackSize1--;
				ans[cur][1] = i;
				int left = stackSize2 < 2 ? -1 : stack2[stackSize2 - 2];
				ans[cur][0] = left;
				//如果当前栈顶没有相同元素的话
				if (stackSize1 == 0 || arr[stack1[stackSize1 - 1]] != arr[cur]) {
					stackSize2--;
				}
			}
			//到目前为止，比当前元素大的元素都已经弹了出去

			//如果等于当前值呢？
			if (stackSize1 != 0 && arr[stack1[stackSize1 - 1]] == arr[i]) {
				stack2[stackSize2 - 1] = i;
			} else {
				//此时，小于当前值
				stack2[stackSize2++] = i;
			}
			stack1[stackSize1] = i;
			stackSize1++;
		}
		while (stackSize1 != 0) {
			//如果栈1不空
			int cur = stack1[stackSize1 - 1];//取出栈顶元素
			stackSize1--;
			ans[cur][1] = -1;
			int left = stackSize2 < 2 ? -1 : stack2[stackSize2 - 2];
			ans[cur][0] = left;
			if (stackSize1 == 0 || arr[stack1[stackSize1 - 1]] != arr[cur]) {
				stackSize2--;
			}
		}
		for (int[] an : ans) {
			System.out.println(an[0] +" "+an[1]);
		}
	}




	public static void getNearLess(int n) {
		int stackSize1 = 0;
		int stackSize2 = 0;
		//如果本来是[3,4,2]的话
		for (int i = 0; i < n; i++) {
			while (stackSize1 > 0 && arr[stack1[stackSize1 - 1]] > arr[i]) {
				int curIndex = stack1[--stackSize1];
				int left = stackSize2 < 2 ? -1 : stack2[stackSize2 - 2];
				ans[curIndex][0] = left;
				ans[curIndex][1] = i;
				if (stackSize1 == 0 || arr[stack1[stackSize1 - 1]] != arr[curIndex]) {
					stackSize2--;
				}
			}

			//如果当前元素的值和栈顶的相等，则更新stack2的最后一个位置；否则直接加到stack2中
			if (stackSize1 != 0 && arr[stack1[stackSize1 - 1]] == arr[i]) {
				stack2[stackSize2 - 1] = i;
			} else {
				stack2[stackSize2++] = i;
			}
			stack1[stackSize1++] = i;
		}
		while (stackSize1 != 0) {
			int curIndex = stack1[--stackSize1];
			int left = stackSize2 < 2 ? -1 : stack2[stackSize2 - 2];
			ans[curIndex][0] = left;
			ans[curIndex][1] = -1;
			if (stackSize1 == 0 || arr[stack1[stackSize1 - 1]] != arr[curIndex]) {
				stackSize2--;
			}
		}
	}

}
