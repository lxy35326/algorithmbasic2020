import class09.A;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class User {
    String id, username, password;

    public User() {

    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof User) {
            User u = (User) obj;
            if (u.id == null && id == null || u.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (id == null) return 0;
        return id.hashCode();
    }
}



class Base extends IOException{

}
class Derived extends FileNotFoundException{

}

interface BaseI{
    void read() throws Base;
}
interface DerivedI extends BaseI{
    void read() ;
}

class Box<T>{
    T t;
    Box(T t){
        this.t=t;
    }
    T getValue(){
        return t;
    }
}


class Main  {
    public static void main(String[] args) {
        int x = 100,z1,z2;
        int y[] = {1,2};
        try{
            z1 = y[2];
            x = x/z1;
            System.out.println("result = "+x);
        }
        catch (ArithmeticException E){
            x = 0;
            System.out.println("捕捉数学运算异常...");
        }
        catch (Exception E){
            x = 0;
            System.out.println("捕捉超出索引异常...");
        }
        finally {
            if(x == 0)
                System.out.println("程序执行发生异常！");
            else
                System.out.println("程序正常执行完毕");
        }
    }
}

class Outer{
    class Inner{

    }
}