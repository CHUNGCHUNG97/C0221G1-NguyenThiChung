package cleanCode.thuc_hanh.refactoring_tach_bien;

public class FIzzBuzz {
    public static String fizzbuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz) {
            return "FizzBuzz";
        } else if (isFizz) {
            return "Fizz";
        } else if (isBuzz) {
            return "Buzz";
        }
        return number + "";
    }
}
