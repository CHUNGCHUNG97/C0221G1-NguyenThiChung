package string_regex.thuc_hanh.validateAcount;

public class TestAcount {
    public static void main(String[] args) {
        String[] str = {"sjh_ad", "2jhsaj", "#dkja","Gkkhs_"};
        ValidateAcount validateAcount = new ValidateAcount();
        for (String valid : str
        ) {
            boolean valided = validateAcount.validate(valid);
            System.out.println(valided);
        }
    }
}
