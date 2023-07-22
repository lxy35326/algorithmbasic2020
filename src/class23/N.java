package class23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N {
    //保证mask右边n位为1,其余位上为0
    int mask;// = (1 << n) - 1;
    public List<List<String>> solveNQueens(int n) {
        int col = 0;
        int left = 0, right = 0;
        int[] queens = new int[n];
        mask = (1 << n) - 1;
        List<List<String>> solutions = new LinkedList<>();
        process(solutions, queens, 0, n, col, left, right);
        return solutions;

    }
    void process(List<List<String>> solutions, int[] queens, int i, int n, int col, int left, int right) {
        if (i == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            //  no  表示不能放的位置
            int no = col | left | right;
            // yes表示可以放的位置
            int yes = ~no & mask;

            while (yes != 0) {
                int position = yes & -yes;
                yes = yes & (yes - 1);
                // 8 - 1 =7: 0111
                queens[i] = Integer.bitCount(position - 1);
                col = col | position;
                left = (left << 1) | (position << 1);
                right = (right >>> 1) | (position >>> 1);
                process(solutions, queens, i + 1, n, col, left, right);
            }
        }

    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        N n = new N();
        n.solveNQueens(4);
    }

}
