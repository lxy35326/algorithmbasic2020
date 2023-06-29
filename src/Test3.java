import java.util.Scanner;

class MyArray{
    public static int sum(int[] array, int index1, int index2){
        return array[index1] + array[index2];
    }
}
public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            arr[i] = in.nextInt();
        }
        int index1 = in.nextInt();
        int index2 = in.nextInt();
        System.out.println(MyArray.sum(arr,index1, index2));
    }
}

