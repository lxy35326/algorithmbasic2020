import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Phaser;

//class AClass{
//    int x=2;
//    int y = 3;
//    public int m1(int x){
//        return x + this.x;
//    }
//    public static float m2(float x, float y){
//        return x * y;
//    }
//}
//class BClass extends AClass{
//    int x = 1;int y = 4;
//    public int m1(int x){
//        return this.x + super.y;
//    }
//    public float m1(float x, float y){
//        return x - y;
//    }
//    public double m1(double x,double y){return x * y;}
//    public static float m2(float x,float y){
//        return x/y;
//    }
//}

class A {
    public void m() {
        System.out.println("A类方法");
    }
}


abstract class SIM {
    protected String phoneNumber;

    protected SIM(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    abstract String getType();

    @Override
    public String toString() {
        return getType() + ":" + phoneNumber;
    }
}

class MobileSIM extends SIM {
    public MobileSIM(String phone) {
        super(phone);
    }

    @Override
    String getType() {
        return "移动卡";
    }
}

class UnionSIM extends SIM {
    public UnionSIM(String phone) {
        super(phone);
    }

    @Override
    String getType() {
        return "联通卡";
    }
}

abstract class AbsPhone {
    protected SIM sim;

    public abstract void showPhoneNumber();

    public AbsPhone(SIM sim) {
        this.sim = sim;
    }

    public void setSim(SIM sim) {
        this.sim = sim;
    }
}

class Phone extends AbsPhone {

    public Phone(SIM sim) {
        super(sim);
    }

    @Override
    public void showPhoneNumber() {
        System.out.println(sim.toString());
    }
}

public class Test {
    public static void main(String[] args) {
        File file = new File("a.txt");
        File outFile = new File("b.txt");
        try (FileReader fr = new FileReader(file);
             FileWriter fw = new FileWriter(outFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             BufferedReader br = new BufferedReader(fr);) {
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = br.read()) != -1) {
                bw.write(buffer, 0, len);
            }
        } catch (IOException e) {

        }

    }
}
