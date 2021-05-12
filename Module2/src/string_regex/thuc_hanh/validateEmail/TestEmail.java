package string_regex.thuc_hanh.validateEmail;

public class TestEmail {
    public static void main(String[] args) {
        String str =new String("1kshd1254isaf@k.com");

        ValidateEmail validateEmail = new ValidateEmail();

       boolean isvalid= validateEmail.validate(str);
        System.out.println(isvalid);
    }
}
