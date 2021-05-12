package string_regex.bai_tap.validate_sdt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhone {
    private final String numberPhone = "^[(]\\d{2}[)][-][(]\\d{10}[)]";

    public NumberPhone() {
    }

    public boolean validate(String str) {
        Pattern pattern = Pattern.compile(numberPhone);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
