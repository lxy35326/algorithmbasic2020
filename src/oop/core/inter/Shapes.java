package oop.core.inter;

public interface Shapes {
    double getArea();
    default double GetPerimeter(){
        return Double.NaN;
    }
}
