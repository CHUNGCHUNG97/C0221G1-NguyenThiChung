package transport.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validates {
    public static final String controllSignCar = "^\\d{2}(A||B)-\\d{3}.\\d{2}$";
    public static final String controllSignTruck = "^\\d{2}C-\\d{3}.\\d{2}$";
    public static final String controllSignMotorbike = "^\\d{2}-[A-Z]{1}[([A-Z]){1}||(\\d{1})]-\\d{3}.\\d{2}$";

    static Pattern pattern;
    static Matcher matcher;

    public static boolean isControllSign(String controllSignCar, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(controllSignCar);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("is not form " + regex);
        }
        return flag;
    }
}
