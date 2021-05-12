package AbstractClass.colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Square square1 = new Square(5, "red");
        Square square2 = new Square(1, "red");
        Rectangle rectangle = new Rectangle(2, 4);
        Shape[] arr = {square1, square2, rectangle};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Square) {
                ((Square) arr[i]).howToColor();
            } else {
                System.out.println(arr[i].getArea());
            }
        }
    }
}
