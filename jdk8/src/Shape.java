interface InterfaceShape{

    double getArea();
    double getFerence();
}
class Rect implements InterfaceShape{
    double length, width;

    public Rect(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getFerence() {
        return 2 * (length + width);
    }

    public String toString() {
        String format = String.format("长：%.2f，宽：%.2f，面积：%.2f，周长：%.2f", length, width,
                getArea(), getFerence());
        return format;
    }
}
class Circle implements InterfaceShape{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getFerence() {
        return 2 * 3.14 * radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public String toString() {
        String format = String.format("半径：%.2f，面积：%.2f，周长：%.2f", radius,
                getArea(), getFerence());
        return format;
    }
}
class Cone{
    InterfaceShape bottom;
    double height;

    public Cone(InterfaceShape bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }

    double getArea(){
        return bottom.getArea() * height / 3;
    }
}
public class Shape {
    public static void main(String[] args) {
        Rect rect = new Rect(1, 2);
        Circle circle = new Circle(1);
        System.out.println(rect);
        System.out.println(circle);
        Cone cone = new Cone(rect, 1);
        Cone cone1 = new Cone(circle,1);
        System.out.println(cone.getArea());
        System.out.println(cone1.getArea());
    }
}
