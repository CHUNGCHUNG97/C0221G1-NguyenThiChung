import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        double weight;
        double height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cân nặng: ");
        weight = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập chiều cao cơ thể: ");
        height = Float.parseFloat(scanner.nextLine());
        double BMI = weight / (Math.pow(height, 2));
        System.out.printf("%-20s%s%s","BMI", BMI,"\n");
        if (BMI < 18.5) {
            System.out.println("Underweight");
        } else if (BMI >= 18.5 && BMI < 25) {
            System.out.println("Normal");
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }

}
