package caseStudy.FuramaResort.student;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private List<Student> studentList = new ArrayList();
    private List<GiaoVien> giaoVienList = new ArrayList<>();
    private Scanner scanner;

    public StudentController() throws IOException {

    }

    public void startApp() throws IOException {
        //LOAD LIST FROM DATABASE
        List<People> people = FileUltils.readDatabase();
        studentList.clear();
        giaoVienList.clear();

//        NẠP DỮ LIỆU CHO TỪNG LIST
        people.forEach(ob -> {
            if (ob instanceof Student) {
                studentList.add((Student) ob);
            }
            if (ob instanceof GiaoVien) {
                giaoVienList.add((GiaoVien) ob);
            }

        });
        this.showMenu();
    }

    public void showMenu() throws IOException {
        int selected = 0;
        do {
            System.out.println("MENU CHƯƠNG TRÌNH \n" +
                    "1. Thêm HS\n" +
                    "2. Thêm GV\n" +
                    "3. Xóa HS\n" +
                    "4. Xóa GV\n" +
                    "5. Show Info\n" +
                    "6. Thoát");

            scanner = new Scanner(System.in);
            selected = scanner.nextInt();
            switch (selected) {
                case 1: {
                    addNewStudent();
                    break;
                }
                case 2: {
                    addNewGiaoVien();
                    break;
                }
                case 3: {
                    removeStudentByName();
                    break;
                }
                case 4: {
                    removeGVByName();
                    break;
                }
                case 5: {
                    showInfo();
                    break;
                }
                case 6: {
                    return;
                }
            }

        } while (selected != 6);


    }

    public void addNewStudent() throws IOException {

        System.out.println("THÊM MỚI HỌC SINH");
        scanner = new Scanner(System.in);
        System.out.println("TÊN HỌC SINH : ");
        String name = scanner.nextLine();
        System.out.println("TUỔI HS: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("CLASS :");
        String className = scanner.nextLine();
        String id = "STUDENT" + (studentList.size() + 1);
        Student hocSinh = new Student(id, age, name, className);
        studentList.add(hocSinh);
        /// GHI LẠI FILE
        FileUltils.write(hocSinh);
    }

    public void addNewGiaoVien() throws IOException {
        System.out.println("THÊM MỚI GV");
        scanner = new Scanner(System.in);
        System.out.println("TÊN GIÁO VIÊN : ");
        String name = scanner.nextLine();
        System.out.println("TUỔI GV: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("CLASS CN :");
        String className = scanner.nextLine();
        String id = "GV" + (giaoVienList.size() + 1);
        GiaoVien giaoVien = new GiaoVien(id, age, name, className);
        giaoVienList.add(giaoVien);
        /// GHI LẠI FILE
        FileUltils.write(giaoVien);

    }

    public void removeStudentByName() throws IOException {
        scanner = new Scanner(System.in);
        System.out.println("nhập tên học sinh muốn xóa: ");
        String name = scanner.nextLine();
        FileUltils.removeStudent(name);
        this.startApp();
//        for (int i = 0; i < studentList.size(); i++) {
//            if (studentList.get(i).name.contains(name)) {
//                studentList.remove(studentList.get(i));
//            } else {
//                System.out.println("không tìm thấy");
//            }
//        }


    }

    public void removeGVByName() throws IOException {
        scanner = new Scanner(System.in);
        System.out.println("nhập tên giáo viên muốn xóa: ");
        String name = scanner.nextLine();
        FileUltils.removeGV(name);
        this.startApp();
//        for (int i = 0; i < giaoVienList.size(); i++) {
//            if (giaoVienList.get(i).name.contains(name)) {
//                giaoVienList.remove(giaoVienList.get(i));
//            } else {
//                System.out.println("không tìm thấy");
//            }
//        }

    }

    public void showInfo() {
        System.out.println("======================================");
        System.out.println("HIỆN TẠI DỮ LIỆU :");
        System.out.println("STUDENT LIST : " + studentList.size());
        System.out.println("TEACHER LIST : " + giaoVienList.size());
        System.out.println("======================================");

    }

    public static void main(String[] args) throws IOException {
        StudentController studentController = new StudentController();
        studentController.startApp();

    }

}
