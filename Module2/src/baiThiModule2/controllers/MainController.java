package baiThiModule2.controllers;

import baiThiModule2.comons.FileUtils;
import baiThiModule2.models.DanhBa;
import hoa_don_tien_dien.models.Bills;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    List<DanhBa> danhBaList = new ArrayList<>();
    static final String fileNhomDanhBa = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\baiThiModule2\\data\\nhomDanhBa.csv";
    static final String fileDanhBa = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\baiThiModule2\\data\\danhBa.csv";
    Scanner scanner;
    boolean isExit = false;

    public void loadDanhBa() throws FileNotFoundException {
        FileUtils.readDanhBa(fileDanhBa).forEach(ob -> {
            danhBaList.add(ob);
        });
        DisplayMenu();
    }

    public void DisplayMenu() throws FileNotFoundException {
        int select;
        scanner = new Scanner(System.in);
        do {
            System.out.println("chọn chức năng: \n" +
                    "1. Xem danh sách\n" +
                    "2. Thêm mới\n" +
                    "3. Cập nhật\n" +
                    "4. Xóa\n" +
                    "5. Tìm kiếm\n" +
                    "6. Đọc từ file\n" +
                    "7. Ghi vào file\n" +
                    "8. Thoát");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1: {
                    xemDanhSach();
                    break;
                }
                case 2: {
                    themMoi();
                    break;
                }
                case 3: {
                    capNhat();
                    break;
                }
                case 4: {
                    xoa();
                    break;
                }
                case 5: {
                    timkiem();
                    break;
                }
                case 6: {
                    docTuFile();
                    break;
                }
                case 7: {
                    ghiVaoFile();
                }
                case 8: {
                    isExit = true;
                    break;
                }
                default:
                    System.out.println("lựa chọn không phù hợp, hãy chọn lại:");
            }
        } while (!isExit);

    }

    private void docTuFile() {
        FileUtils.readDanhBa(fileDanhBa).forEach(ob -> {
            System.out.println(ob.toString());
        });
    }

    private void xoa() {
        scanner = new Scanner(System.in);
        boolean isFounded = false;
        String sdt;
        do {
            System.out.println("nhập số điện thoại của danh bạ cần xóa:");
            sdt = scanner.nextLine();
        } while (!Validates.isValid(sdt, Validates.sdt));
        for (int i = 0; i < danhBaList.size(); i++) {
            if (danhBaList.get(i).getSđt().contains(sdt)) {
                System.out.println("bạn chắc chắn muốn xóa danh bạ này: ");
                String input = scanner.nextLine();
                if (input.equals("Y")) {
                    danhBaList.remove(danhBaList.get(i));
                    StringBuilder stringBuilder = new StringBuilder("");
                    danhBaList.forEach(ob -> stringBuilder.append(ob.toCSV()).append("\n"));
                    FileUtils.writeFile(stringBuilder.toString(), fileDanhBa, false);
                    System.out.println("thành công");
                    isFounded = true;
                    break;
                }
            }
        }

        if (!isFounded) {
            System.out.println("không tìm thấy");
        }
    }

    private void capNhat() {
        scanner = new Scanner(System.in);
        String sdt;
        boolean isFounded = false;
        do {
            System.out.println("nhập số điện thoại của danh bạ cần sửa:");
            sdt = scanner.nextLine();
        } while (!Validates.isValid(sdt, Validates.sdt));
        for (int i = 0; i < danhBaList.size(); i++) {
            if (danhBaList.get(i).getSđt().contains(sdt)) {
                System.out.println("nhập thông tin chỉnh sửa: ");
                String nhomDanhBa = chonNhomDanhBa();
                danhBaList.get(i).setNhomDanhBa(nhomDanhBa);
                System.out.println("họ tên");
                String hoTen = scanner.nextLine();
                danhBaList.get(i).setHoTen(hoTen);
                System.out.println("giới tính");
                String gioiTinh = scanner.nextLine();
                danhBaList.get(i).setGioiTinh(gioiTinh);
                System.out.println("địa chỉ");
                String diaChi = scanner.nextLine();
                danhBaList.get(i).setDiaChi(diaChi);
                System.out.println("ngày sinh");
                String ngaySinh = scanner.nextLine();
                danhBaList.get(i).setNgaySinh(ngaySinh);
                String email;
                do {
                    System.out.println("email");
                    email = scanner.nextLine();
                } while (!Validates.isValid(email, Validates.email));
                danhBaList.get(i).setEmail(email);
                StringBuilder stringBuilder = new StringBuilder("");
                danhBaList.forEach(ob -> stringBuilder.append(ob.toCSV()).append("\n"));
                FileUtils.writeFile(stringBuilder.toString(), fileDanhBa, false);
                System.out.println("sửa thành công");
                isFounded = true;
                break;
            }
        }
        if (!isFounded) {
            System.out.println("không tìm thấy danh bạ phù hợp");
        }
    }

    private void timkiem() {
        List<DanhBa> danhBaList1 = new ArrayList<>();
        scanner = new Scanner(System.in);
        int select;
        boolean isExsit = false;
        do {
            System.out.println("bạn muốn tìm theo:\n" +
                    "1.Tên\n" +
                    "2.Số điện thoại");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1: {
                    String sdt;
                    boolean isFounded = false;
                    do {
                        System.out.println("nhập số điện thoại của danh bạ cần sửa:");
                        sdt = scanner.nextLine();
                    } while (sdt.isEmpty());

                    for (int i = 0; i < danhBaList.size(); i++) {
                        if (danhBaList.get(i).getSđt().contains(sdt)) {
                           danhBaList1.add(danhBaList1.get(i));
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("nhập tên cần tìm");
                    String name = scanner.nextLine();
                    for (int i = 0; i < danhBaList.size(); i++) {
                        if (danhBaList.get(i).getSđt().contains(name)) {
                            danhBaList1.add(danhBaList.get(i));
                        }
                    }
                    if (danhBaList1.size() == 0) {
                        System.out.println("không tìm thấy ");
                    } else {
                        danhBaList1.forEach(ob -> {
                            System.out.println(ob.toString());
                        });
                    }
                    break;
                }
                default:
                    System.out.println("nhập sai nhập lại:");
            }


        } while (!isExsit);


    }

    private static List<String> docTuFileNhomDanhBa(String file) {
        try {
            List<String> nhomDanhBa = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                nhomDanhBa.add(line);
            }
            bufferedReader.close();
            return nhomDanhBa;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void ghiVaoFile() {
        danhBaList.forEach(ob->{

        });
    }

    private void themMoi() {
        scanner = new Scanner(System.in);
        String sdt;
        do {
            System.out.println("số điện thoại: ");
            sdt = scanner.nextLine();
        } while (!Validates.isValid(sdt, Validates.sdt));

        String nhomDanhBa = chonNhomDanhBa();
        System.out.println("họ tên");
        String hoTen = scanner.nextLine();
        System.out.println("giới tính");
        String gioiTinh = scanner.nextLine();
        System.out.println("địa chỉ");
        String diaChi = scanner.nextLine();
        System.out.println("ngày sinh");
        String ngaySinh = scanner.nextLine();
        String email;
        do {
            System.out.println("email");
            email = scanner.nextLine();
        } while (!Validates.isValid(email, Validates.email));
        DanhBa danhBa = new DanhBa(sdt, nhomDanhBa, hoTen, gioiTinh, diaChi, ngaySinh, email);
        danhBaList.add(danhBa);
        FileUtils.writeFile(danhBa.toCSV(), fileDanhBa, true);
    }

    private void xemDanhSach() {
        for (int i = 0; i < danhBaList.size(); i++) {
            System.out.println((i + 1) + "." + danhBaList.get(i));
        }
    }

    public static String chonNhomDanhBa() {
        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        String str;
        int select;
        do {
            System.out.println("chọn nhóm danh bạ");
            for (int i = 0; i < docTuFileNhomDanhBa(fileNhomDanhBa).size(); i++) {
                System.out.println((i + 1) + "." + docTuFileNhomDanhBa(fileNhomDanhBa).get(i));
            }
            select = Integer.parseInt(scanner.nextLine());
            str = docTuFileNhomDanhBa(fileNhomDanhBa).get(select - 1);
        } while (select < 1 || select > docTuFileNhomDanhBa(fileNhomDanhBa).size());
        return str;
    }
}
