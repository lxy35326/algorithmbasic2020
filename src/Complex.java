class Complex {
    private double r, i;

    public Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }
    public double mod(){
        return Math.sqrt(r * r + i * i);
    }
    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.r + c2.r, c1.i + c2.i);
    }

    public Complex add(Complex other) {
        return new Complex(r + other.r, i + other.i);
    }
    public boolean equals(Complex c) {
        if (c == this) return true;
        //指向的不是同一个
        if (c == null) return false;
        return r == c.r && i == c.i;
    }
    public String toString(){
        //(a,bi)
       StringBuilder sb = new StringBuilder();
       sb.append(r);
       if(i >= 0)
           sb.append("+");
       sb.append(i+"i");
       return sb.toString();
    }
}
