interface Com{
    abstract int get(int a,int b);
}
class People{
    int[][] r = {{1,2},};
    int getResult(Com com, int a,int b){
        return com.get(a,b);
    }
}
public class E {
    public static void main(String[] args) {
        People p = new People();
        Com com = new Com() {
            @Override
            public int get(int a, int b) {
//                throw new Illegalar
                return a + b;
            }
        };
        int m = p.getResult(com,2,5);
        com = new Com(){
            @Override
            public int get(int a, int b) {
                return a * b;
            }
        };
        int n = p.getResult(com,2,5);
        System.out.printf("%d:%d",m,n);
    }
}
