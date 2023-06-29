class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}}));


    }
    static class UnionFind{
        int[] parent;
        int[] help;
        int[] size;
        int sets;
        int cn;
        UnionFind(int rn, int cn) {
            int len = rn * cn;
            parent = new int[len];
            size = new int[len];
            help = new int[len];
            this.cn = cn;
        }
        int index(int row, int col) {
            return row * cn + col;
        }
        void init(int row, int col) {
            sets++;
            int t = index(row, col);
            parent[t] = t;
            size[t] = 1;
        }
        int find(int x) {
            int count = 0;
            while (x != parent[x]) {
                help[count++] = x;
                x = parent[x];
            }
            for (count--; count > -1; count--) {
                parent[help[count]] = x;
            }
            return x;
        }

        void union(int row, int col, int row1, int col1) {
            int x = index(row, col);
            int y = index(row1, col1);
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) return;
            sets--;
            if (size[fx] >= size[fy]) {
                parent[fy] = fx;
                size[fx] += size[fy];
            } else {
                parent[fx] = fy;
                size[fy] += size[fx];
            }
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        int rn = grid.length;
        int cn = grid[0].length;
        UnionFind uf = new UnionFind(rn, cn);
        for (int row = 0; row < rn; row++)
            for (int col = 0; col < cn; col++)
                if (grid[row][col] == '1') {
                    uf.init(row, col);
                }

        for (int col = 1; col < cn; col++) {
            if (grid[0][col - 1] == '1' && grid[0][col] == '1') {
                uf.union(0, col - 1, 0, col);
            }
        }

        for (int row = 1; row < rn; row++) {
            if (grid[row][0] == '1' && grid[row - 1][0] == '1')
                uf.union(row, 0, row - 1, 0);
        }

        for (int row = 1; row < rn; row++) {
            for (int col = 1; col < cn; col++) {
                if (grid[row][col] == '1') {
                    if (grid[row - 1][col] == '1')
                        uf.union(row, col, row - 1, col);
                    if (grid[row][col - 1] == '1')
                        uf.union(row, col, row, col - 1);
                }
            }
        }
        return uf.sets;


    }
}
