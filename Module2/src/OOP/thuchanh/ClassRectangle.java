package OOP.thuchanh;

import IntroductionJava.Thuc_hanh.RectangleArea;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ClassRectangle {


    public ClassRectangle() {
    }

    double height;
    double width;

    public ClassRectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public double area(){
        double area=this.height*this.width;
        return area;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("height: ");
        double height=scanner.nextFloat();
        System.out.println("width: ");
        double width=scanner.nextFloat();
        ClassRectangle rectangle=new ClassRectangle(height,width);
        System.out.println(rectangle.area());
    }
}
