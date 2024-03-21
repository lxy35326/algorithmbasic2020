package oop.base;

import java.util.*;

class A<T, T2> {

}
abstract class Shape{
    String color = "red";
    abstract double getArea();
    abstract double getC();
    void showInfo(){
        System.out.println("color:"+color);
    }
}

class Rectangle extends Shape{
    double length,width;
    Rectangle(double l, double w){
        length = l;
        width = w;
    }
    double getArea(){
        return length *width;
    }
    double getC(){
        return 2 *(length + width);
    }

    void showInfo(){
        super.showInfo();
        System.out.println("Rectangle's area:"+getArea());
        System.out.println("Rectangle's perimeter:"+getC());
    }
}

class Circle extends Shape{
    double radius;
    Circle(double d){
        radius = d;
    }

    @Override
    double getArea() {
        return 3.14 * radius * radius;
    }

    double getC(){
        return 2 * 3.14 * radius;
    }
    void showInfo(){
        super.showInfo();
        System.out.println("Circle's area:"+getArea());
        System.out.println("Circle's perimeter:"+getC());
    }
}



public class Test {
    public static void main(String[] args) {
       outer:
       for (int i = 1; i < 2
               ; i++)
           for (int j = 1; j < 4; j++) {
               if (i == 1 && j == 2) continue outer;
               System.out.println("i = " + i + " j= "+j);
           }

    }
}
