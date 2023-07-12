package class21;

public class Coins {
    static int func(int[] arr, int aim){
//        int len = arr.length;
        return process(arr, aim, 0);
    }
    static int process(int[] arr, int rest, int cur){
        if (rest < 0) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        if (cur == arr.length) {
            return 0;
        }
        //rest != 0, cur没走到最后
        return process(arr, rest, cur + 1) + process(arr, rest - arr[cur], cur + 1);
    }
    public static void main(String[] args) {

    }
}
