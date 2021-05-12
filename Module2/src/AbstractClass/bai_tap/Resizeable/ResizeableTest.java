package AbstractClass.bai_tap.Resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(5, 3);
        Square square = new Square(4);
        Shape[] arr = {circle, rectangle, square};
//        for (int i = 0; i < arr.length; i++) {
//
//            System.out.println("Area " + arr[i].getClass().getSimpleName() + ": " + arr[i].getArea() + " Perimeter: " + arr[i].Perimeter());
//            if (arr[i] instanceof Circle) {
//                ((Circle) arr[i]).resize(20);
//
//            } else if (arr[i] instanceof Rectangle) {
//                ((Rectangle) arr[i]).resize(20);
//            } else {
//                ((Square) arr[i]).resize(20);
//            }
//            System.out.println("Area " + arr[i].getClass().getSimpleName() + ": " + arr[i].getArea() + " Perimeter: " + arr[i].Perimeter());
//
//        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.println("Area " + arr[i].getClass().getSimpleName() + ": " + arr[i].getArea() + " Perimeter: " + arr[i].Perimeter());
            arr[i].resize(20);
            System.out.println("Area " + arr[i].getClass().getSimpleName() + ": " + arr[i].getArea() + " Perimeter: " + arr[i].Perimeter());
        }
    }

}
