package oop.core.abstr;

public abstract class Information {
    protected int width,height;

    public Information(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public abstract double getArea();
    public double getPerimeter(){
        return 2 * (width + height);
    }
}
