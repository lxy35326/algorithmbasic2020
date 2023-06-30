package class17;

import java.util.Deque;
import java.util.LinkedList;

public class StackReverse {
    /**
     * 返回栈底元素，其他元素向下移一格
     *
     * @param stack 要操作的栈
     * @return 栈底的元素
     */
    static int f(Deque<Integer> stack) {
        int result = stack.pop();
        if (!stack.isEmpty()) {
            //如果取出栈顶来之后，栈不为空
            int last = f(stack);
            stack.push(result);
            result = last;
        }
        return result;
    }

    static void stackReverse(Deque<Integer> stack) {
        if (stack == null || stack.isEmpty()) return;
        //得到栈底元素
        int f = f(stack);
        //逆序其他元素
        stackReverse(stack);
        stack.push(f);
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 1; i < 4; i++) {
            stack.push(i);
        }
        stack.forEach(System.out::println);
        stackReverse(stack);
        stack.forEach(System.out::println);
    }
}
