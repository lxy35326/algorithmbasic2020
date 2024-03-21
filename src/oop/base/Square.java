package oop.base;

import oop.core.abstr.Information;
import oop.core.inter.Shapes;

public class Square extends Information implements Shapes {
    public Square(int width, int height){
        super(width,height);


    }


    public double getArea() {
        return width * height;
    }
}
