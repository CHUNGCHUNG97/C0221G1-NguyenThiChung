package OOP.thuchanh;


public class HocSinh {
    private String name;
    private int age;
    private String className;
    private String phoneNumber;

    public HocSinh(String name, int age, String className, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Hoc sinh này tên là" + this.name + " và tuổi là : " + this.age;
    }

}

