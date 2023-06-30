package class17;

import java.util.*;

class Record {
    int level;
    String from;
    String to, other;

    public Record(int level, String from, String to, String other) {
        this.level = level;
        this.from = from;
        this.to = to;
        this.other = other;
    }
}

public class Hanoi {
    static void hanoi(int n, String from, String to, String other) {
        if (n < 1) return;
        //这个栈用来替代递归
        Deque<Record> stack = new LinkedList<>(Arrays.asList(new Record(n, from, to, other)));
        Set<Record> finishLeft = new HashSet<>();
        //如果栈不空
        while (!stack.isEmpty()) {
            Record cur = stack.peek();
            //说明当前要对最上面的一个盘子进行操作
            if (cur.level == 1) {
                System.out.println("move 1 from " + cur.from + " to " + cur.to);
                stack.pop();
            } else {
                //说明不只剩一个盘子，且是第一次来到这个盘子
                if (!finishLeft.contains(cur)) {
                    stack.push(new Record(cur.level - 1, cur.from, cur.other, cur.to));
                    finishLeft.add(cur);
                } else {
                    //说明上面的盘子都已经完成了
                    System.out.println("move " + cur.level + " from " + cur.from + " to " + cur.to);
                    stack.pop();
                    stack.push(new Record(cur.level - 1, cur.other, cur.to, cur.from));
                }
            }
        }
    }

    public static void main(String[] args) {
        hanoi(3, "left", "right", "mid");
    }
}
