package OOP.thuchanh;

import java.util.Scanner;

public class ClassQuadraticEquation {
    private double a;
    private double b;
    private double c;


    public ClassQuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return Math.sqrt(this.b) - 4 * this.a * this.c;

    }

    public double getRoot1() {
        double root1 = (-this.b + Math.sqrt(Math.pow(this.b, 2) - 4 * this.a * this.c)) / (2 * this.a);
        return root1;
    }

    public double getRoot2() {
        double root2 = (this.b + Math.sqrt(Math.pow(this.b, 2) - 4 * this.a * this.c)) / (2 * this.a);
        return root2;
    }

    public void calculate() {
        if (getDiscriminant() > 0) {
            System.out.println("Phương trình có 2 nghiệm là: " + getRoot1() + " và " + getRoot2());
        } else if (getDiscriminant() == 0) {
            System.out.println("Phương trình có nghiệm kép: " + getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }

}
