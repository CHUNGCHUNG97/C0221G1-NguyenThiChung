package string_regex.bai_tap.validate_tenLopHoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private final String className = "^[ACP]{1}\\d{4}[GHIKLM]$";

    public ClassName() {
    }

    public boolean validate(String str) {
        Pattern pattern = Pattern.compile(className);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
