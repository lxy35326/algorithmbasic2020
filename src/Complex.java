public class Complex {
    double r, i;

    public Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public Complex add(Complex c) {
        return new Complex(r + c.r, i + c.i);
    }
    public boolean equals(Complex c) {
        if (c == this) return true;
        //指向的不是同一个
        if (c == null) return false;
        return r == c.r && i == c.i;
    }
    public String toString(){
        //(a,bi)
        return "("+r+","+i+"i)";
    }
}
