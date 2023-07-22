package class23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC {
    int mask;
    public int totalNQueens(int n) {
        mask = (1 << n) - 1;
        return process(0, n, 0, 0, 0);
    }
    int process(int i, int n, int col, int left, int right){
        if (i == n) return 1;
        int no = col | left | right;
        int yes = ~no & mask;
        int ways = 0;
        while (yes != 0) {
            int position = yes & -yes;
            yes = yes & (yes - 1);
            ways += process(i + 1, n, col | position, (left | position) << 1, (right | position) >>> 1);
        }
        return ways;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        backtrack(solutions, queens, n, 0);
        return solutions;
    }
    void backtrack(List<List<String>> solutions, int[] queens, int n,int row) {
        if (row == n) {
            List<String> board = generated(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                //第row行怎么放？
                if (isValid(queens, row,i)) {
                    queens[row] = i;
                    backtrack(solutions, queens, n, row + 1);
                }
            }
        }
    }
    boolean isValid(int[] queens, int row, int i) {
        for (int k = 0; k < row; k++) {
            if (queens[k] == i || Math.abs(row - k) == Math.abs(queens[k] - i)) {
                return false;
            }
        }
        return true;
    }
    List<String> generated(int[] queens, int n) {
        List<String> board = new LinkedList<>();
        for (int i  = 0; i < n; i++) {
            char[] buffer = new char[n];
            Arrays.fill(buffer, '.');
            buffer[queens[i]] = 'Q';
            board.add(new String(buffer));
        }
        return board;
    }

    public static void main(String[] args) {
        LC lc = new LC();
        lc.totalNQueens(4);
        int i = 0;
        System.out.println(~i);
        System.out.println(~i & 15);
    }
}
