package caseStudy.FuramaResort.student;

public class GiaoVien extends People {
    private String classCn;

    public GiaoVien(String id, int age, String name) {
        super(id, age, name);
    }

    public GiaoVien(String id, int age, String name, String classCn) {
        super(id, age, name);
        this.classCn = classCn;
    }

    @Override
    public void showInfo() {
        System.out.println();
    }

    @Override
    public String toCSV() {
        return "GIAOVIEN~" + this.id + "~" + this.name + "~" + this.age + "~" + this.classCn;
    }
}
