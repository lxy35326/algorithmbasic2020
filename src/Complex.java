class Complex {



    void showDemo(demo de){
        String s1="A";
        String s2="A";
        de.show(s1,s2);
        System.out.println(s1+s1.equals(s2));
    }
    public static void main(String[] args) {
     Complex test = new Complex();
     test.showDemo(new demo(){
         public void show(String s1,String s2){
             System.out.println(s1==s2);
             s1=new String("B");
         }
     });
    }
}
class demo{
    demo(){
        String s1 = new String("A");
        String s2 = new String("A");
        System.out.println("A"+(s1==s2));
    }
    public void show(String s1, String s2){
        System.out.println(s1.equals(s2));
    }
}