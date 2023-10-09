package class32;

public class IndexTree {
    int[] tree;
    int N;
    IndexTree(int size) {
        N = size;
        tree = new int[N + 1];
    }

    public int sum(int n){
        int ret = 0;
        while (n != 0) {
            ret += tree[n];
            n -= (n & -n);
        }
        return ret;
    }


    void add(int index, int n) {
        while (index <= N) {
            tree[index] += n;
            index += (index & -index);
        }
    }
}
