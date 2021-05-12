package AbstractClass.Thuc_hanh.animal;

public class FruitTest {
    public static void main(String[] args) {
        InterfaceFruit[] fruit = new InterfaceFruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();
        for (InterfaceFruit fruits : fruit) {
            System.out.println(fruits.howToEat());
        }
    }
}
