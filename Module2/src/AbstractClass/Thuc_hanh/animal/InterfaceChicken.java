package AbstractClass.Thuc_hanh.animal;

public interface InterfaceChicken {
    class Chicken extends Animal implements InterfaceEdible {

        @Override
        public String makeSound() {
            return "Chicken: cluck-cluck!";
        }

        @Override
        public String howToEat() {
            return "could be fried";
        }
    }
}
