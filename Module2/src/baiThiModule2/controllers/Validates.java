package baiThiModule2.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validates {
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String email = "^[a-zA-Z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static String sdt = "^(\\d{3}\\s)(\\d{4}\\s)\\d{3}$";

    public static boolean isValid(String idCustomer_Regex, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(idCustomer_Regex);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("is not form: " + regex);
        }
        return flag;
    }

}
