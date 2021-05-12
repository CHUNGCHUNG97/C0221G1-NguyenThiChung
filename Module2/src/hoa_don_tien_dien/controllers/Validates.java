package hoa_don_tien_dien.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validates {
    private static Pattern pattern;
    private static Matcher matcher;

    static final String idCustomer_Regex = "^KH(VN|NN)-[\\d]{5}$";

    public static boolean isIdCustomer(String idCustomer_Regex, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(idCustomer_Regex);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("is not form: " + regex);
        }
        return flag;
    }
}
