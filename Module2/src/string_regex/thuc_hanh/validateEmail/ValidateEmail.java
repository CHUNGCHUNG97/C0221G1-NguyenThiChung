package string_regex.thuc_hanh.validateEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    private static Pattern pattern;
    private static Matcher matcher;
    private final String email = "^[a-zA-Z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public ValidateEmail() {
        pattern = Pattern.compile(email);
    }

    public boolean validate(String str) {
        matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
