package OOP.thuchanh;

import java.util.Scanner;

public class TestQ {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double a = sc.nextFloat();
        double b = sc.nextFloat();
        double c = sc.nextFloat();
        ClassQuadraticEquation quadraticEquation = new ClassQuadraticEquation(a, b, c);
        quadraticEquation.calculate();
    }
}
