package caseStudy.FuramaResort.controllers;

import caseStudy.FuramaResort.Exceptions.*;

import java.lang.reflect.Array;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String id = "^SV(VL|HO|RO)-[\\d]{4}$";
    public static final String tenDV = "^[A-Z][a-z0-9]*$";
    public static final String idCardRegex = "^(\\d{3}\\s){2}\\d{3}$";
    public static final String birthdayRegex = "^\\d{2}/\\d{2}/\\d{4}$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValidService(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("nhập không khớp " + regex);
        }
        return flag;
    }

    public static boolean isMoreThan(double number, double destNumber) {
        boolean flag = number > destNumber;
        if (!flag) {
            System.out.println("số nhập vào không lớn hơn " + destNumber);
        }
        return flag;
    }

    public static boolean isbig_smallThan(double number, double startNumber, double destNumber) {
        boolean flag = startNumber < number && number < destNumber;
        if (!flag) {
            System.out.println("số nhập vào không nằm trong khoảng " + startNumber + " và " + destNumber);
        }
        return flag;
    }

    public static boolean isValidExtraService(String extraService) {
        String[] list = {"massage", "karaoke", "food", "drink", "car"};
        boolean flag = Arrays.asList(list).contains(extraService);
        if (!flag) {
            System.out.println("dịch vụ đi kèm không có trong list");
        }
        return flag;
    }

    public static void IsFullName(String fullName) throws NameException {
        String[] fullNameElement = fullName.split(" ");
        for (int i = 0; i < fullNameElement.length; i++) {
            if (Character.isLowerCase(fullNameElement[i].charAt(0)) || fullNameElement[i] == " ") {
                throw new NameException();
            }
        }
    }

    public static void isEmail(String email) throws EmailException {
        int count = 0;
        int countPoint = 0;
        if (email.indexOf('@') < 0 || email.indexOf('.') < 0) {
            throw new EmailException();
        }
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
        }
        if (count > 1) {
            throw new EmailException();
        }
    }

    public static void isGender(String gender) throws GenderException {
        String[] genderList = {"Male", "Female", "Unknow"};

        boolean check = false;
        for (int i = 0; i < genderList.length; i++) {
            if (gender.toLowerCase().equals(genderList[i].toLowerCase())) {
                gender = genderList[i];
                check = true;
                break;
            }
        }
        if (!check){
            throw new GenderException();
        }

    }


    public static void isIdCard(String idCard) throws IdCardException {
        Pattern pattern = Pattern.compile(idCardRegex);
        Matcher matcher = pattern.matcher(idCard);
        if (!matcher.matches()) {
            throw new IdCardException();
        }
    }

    public static void isBirthday(String birthday) throws BirthdayException {
        if (isValidService(birthday, birthdayRegex)) {
            int birthYear = Integer.parseInt(birthday.split("/")[2]);
            int curYear = Year.now().getValue();
            if (birthYear <= 1900 || (curYear - birthYear) < 18) {
                throw new BirthdayException();
            }
        } else {
            throw new BirthdayException();
        }
    }
}
