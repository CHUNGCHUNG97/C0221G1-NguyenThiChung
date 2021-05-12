package cleanCode.thuc_hanh.refactoring;

public class Coculator {
    public static int coculate(int firstOperand, int secondOperand, char operator) {
        final char addition = '+';
        final char subtraction = '-';
        final char multiplication = '*';
        final char division = '/';
        switch (operator) {
            case addition:
                return firstOperand + secondOperand;
            case subtraction:
                return firstOperand - secondOperand;
            case multiplication:
                return firstOperand * secondOperand;
            case division:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
