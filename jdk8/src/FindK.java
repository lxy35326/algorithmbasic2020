public class FindK {
    public static void main(String[] args) {
        int i;
        int sum = 0;
        for (i = 1 ; ;i++)
        {
            sum += i;
            if (sum > 2000)
                break;
        }
        System.out.println("k最小为"+i);
    }
}
