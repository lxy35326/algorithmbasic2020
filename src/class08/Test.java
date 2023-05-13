package class08;
class Test{
    public static void main(String[] args) {
        int[] dest = new int[10];
        for (int i = 0; i < dest.length; i++) {
            dest[i] = i;
        }
        System.arraycopy(new int[]{0},0,dest,0,1);
        for (int i : dest) {
            System.out.println(i);
        }
    }
}