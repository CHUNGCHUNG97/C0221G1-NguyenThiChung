package string_regex.bai_tap.validate_sdt;

public class TestNumberPhone {
    public static void main(String[] args) {
        NumberPhone numberPhone = new NumberPhone();
        String[] str = new String[]{"04653130", "(84)-(4456424654)", "(a8)-(22222222)"};
        for (String number : str
        ) {
            boolean valid = numberPhone.validate(number);
            System.out.println(valid);
        }
    }
}
