package string_regex.thuc_hanh.validateAcount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAcount {
    private static String acount_regex = "^[a-z0-9_]{6,}$";

    public ValidateAcount() {

    }

    public boolean validate(String str) {
        Pattern pattern = Pattern.compile(acount_regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
