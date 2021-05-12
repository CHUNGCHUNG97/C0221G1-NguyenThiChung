package caseStudy.FuramaResort.controllers;

import caseStudy.FuramaResort.Exceptions.*;
import caseStudy.FuramaResort.commons.FileUtils;
import caseStudy.FuramaResort.models.*;

import java.io.*;
import java.util.*;

public class MainController {

    Scanner scanner;
    List<Services> villaList = new ArrayList<>();
    List<Services> houseList = new ArrayList<>();
    List<Services> roomList = new ArrayList<>();
    List<Customer> customerList = new ArrayList<>();
    static String fileCustomer = "Customer.CSV";
    static String fileBooking = "Booking.CSV ";
    static String fileEmployee = "Employee.CSV ";

    public void LoadDataBase() throws IOException {
        List<Services> services = FileUtils.read();
        List<Customer> customers = FileUtils.readCustomer(fileCustomer);
        villaList.clear();
        houseList.clear();
        roomList.clear();
        customerList.clear();
        services.forEach(ob -> {
            if (ob instanceof Villa) {
                villaList.add((Villa) ob);
            }
            if (ob instanceof House) {
                houseList.add((House) ob);
            }
            if (ob instanceof Room) {
                roomList.add((Room) ob);
            }
        });
        customers.forEach(ob -> {
            customerList.add((Customer) ob);
        });
        this.displayMainMenu();
    }

    public void displayMainMenu() throws IOException {
        scanner = new Scanner(System.in);
        boolean isExist = false;
        while (!isExist) {

            System.out.println("Lựa chọn chức năng: ");
            System.out.println("1. Add New Services \n" +
                    "2.Show Services\n" +
                    "3.Add New Customer\n" +
                    "4.Show Information of Customer\n" +
                    "5.Add New Booking\n" +
                    "6.Show Information of Employee\n" +
                    "7.Exit\n");
            int select = scanner.nextInt();
            if (select < 1 || select > 7) {
                System.out.println("lựa chọn không phù hợp, hãy nhập lại:");
            }

            switch (select) {
                case 1: {
                    addNewServies();
                    break;
                }
                case 2: {
                    showServices();
                    break;
                }
                case 3: {
                    addNewCustomer();
                    break;
                }
                case 4: {
                    showInformationCustomers();
                    break;
                }
                case 5: {
                    addNewBooking();
                    break;
                }
                case 6: {
                    showEmployee();
                    break;
                }
                case 7: {
                    isExist = true;
                    break;
                }
                default: {

                }
            }
        }
    }

    public void addNewServies() throws IOException {
        scanner = new Scanner(System.in);
        boolean isExist = false;
        while (!isExist) {
            System.out.println("Chọn dịch vụ cần thêm\n" +
                    "1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu\n" +
                    "5.Exit\n");
            int select = scanner.nextInt();
            if (select < 1 || select > 5) {
                System.out.println("lựa chọn không phù hợp, hãy nhập lại");
            }
            String id;
            switch (select) {
                case 1: {
                    addService("VILLA");
                    break;
                }
                case 2: {
                    addService("HOUSE");
                    break;
                }
                case 3: {
                    addService("ROOM");
                    break;
                }
                case 4: {
                    isExist = false;
                    break;
                }
                case 5: {
                    isExist = true;
                    break;
                }
                default: {

                }
            }
        }
    }

    public void showServices() {
        int select = 0;
        do {
            System.out.println("Menu show chương trình: \n" +
                    "1.Show all Villa\n" +
                    "2.Show all House\n" +
                    "3.Show all Room\n" +
                    "4.Show All Name Villa Not Duplicate\n" +
                    "5.Show All Name House Not Duplicate\n" +
                    "6.Show All Name Name Not Duplicate\n" +
                    "7.Back to menu\n" +
                    "8.Exit");
            System.out.println("nhập lựa chọn: ");
            select = scanner.nextInt();
            switch (select) {
                case 1: {
                    System.out.println("all villa: ");
                    villaList.forEach(ob -> ob.showInfor());
                    break;
                }
                case 2: {
                    System.out.println("all house: ");
                    houseList.forEach(ob -> ob.showInfor());
                    break;
                }
                case 3: {
                    System.out.println("all room: ");
                    roomList.forEach(ob -> ob.showInfor());
                    break;
                }
                case 4: {
                    List<String> name = new ArrayList<>();
                    for (int i = 0; i < villaList.size(); i++) {
                        boolean isContain = checkContain(villaList.get(i).getTenDichVu(), name);
                        if (!isContain) {
                            name.add(villaList.get(i).getTenDichVu());
                            villaList.get(i).showInfor();
                        }
                    }
                    break;
                }
                case 5: {
                    List<String> name = new ArrayList<>();

                    for (int i = 0; i < houseList.size(); i++) {
                        boolean isContain = checkContain(houseList.get(i).getTenDichVu(), name);
                        if (!isContain) {
                            houseList.get(i).showInfor();
                            name.add(houseList.get(i).getTenDichVu());
                        }
                    }
                    break;
                }
                case 6: {
                    List<String> name = new ArrayList<>();

                    for (int i = 0; i < roomList.size(); i++) {
                        boolean isContain = checkContain(roomList.get(i).getTenDichVu(), name);
                        if (!isContain) {
                            roomList.get(i).showInfor();
                            name.add(roomList.get(i).getTenDichVu());
                        }
                    }
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    return;
                }
                default:
            }
        } while (select != 8);
    }

    public boolean checkContain(String name, List<String> names) {
        for (int j = 0; j < names.size(); j++) {
            if (name.equals(names.get(j))) {
                return true;
            }
        }
        return false;
    }

    public void addService(String type) throws IOException {
        scanner = new Scanner(System.in);
        String id;
        String tenDV;
        double dienTichSD;
        double chiPhiThue;
        int soLuongNguoi;
        String kieuThue;
        do {
            System.out.println("nhập id: ");
            id = scanner.nextLine();
        } while (!Validators.isValidService(id, Validators.id));
        do {
            System.out.println("tên dịch vụ:");
            tenDV = scanner.nextLine();
        } while (!Validators.isValidService(tenDV, Validators.tenDV));
        do {
            System.out.println("diện tích sử dụng: ");
            dienTichSD = Float.parseFloat(scanner.nextLine());
        } while (!Validators.isMoreThan(dienTichSD, 30));
        do {
            System.out.println("chi phí thuê:");
            chiPhiThue = Float.parseFloat(scanner.nextLine());
        } while (!Validators.isMoreThan(chiPhiThue, 0));
        do {
            System.out.println("số lượng người tối đa:");
            soLuongNguoi = Integer.parseInt(scanner.nextLine());
        } while (!Validators.isbig_smallThan(soLuongNguoi, 0, 20));
        do {
            System.out.println("kiểu thuê: ");
            kieuThue = scanner.nextLine();
        } while (!Validators.isValidService(kieuThue, Validators.tenDV));
        switch (type) {
            case "VILLA": {
                String tieuChuanPhong;
                double dienTichHoBoi;
                int soTang;
                String moTaTienNghiKhac;
                do {
                    System.out.println("tiêu chuẩn phòng: ");
                    tieuChuanPhong = scanner.nextLine();
                } while (!Validators.isValidService(tieuChuanPhong, Validators.tenDV));
                do {
                    System.out.println("diện tích hồ bơi: ");
                    dienTichHoBoi = Float.parseFloat(scanner.nextLine());
                } while (!Validators.isMoreThan(dienTichHoBoi, 30));
                do {
                    System.out.println("số tầng: ");
                    soTang = Integer.parseInt(scanner.nextLine());
                } while (!Validators.isMoreThan(soTang, 0));
                do {
                    System.out.println("mô tả tiện nghi khác: ");
                    moTaTienNghiKhac = scanner.nextLine();
                } while (!Validators.isValidService(moTaTienNghiKhac, Validators.tenDV));

                Villa villa = new Villa(id, tenDV, dienTichSD, chiPhiThue, soLuongNguoi, kieuThue, tieuChuanPhong,
                        moTaTienNghiKhac, dienTichHoBoi, soTang);
                villaList.add(villa);
                FileUtils.write(villa);
                break;
            }
            case "HOUSE": {
                String tieuChuanPhong;
                int soTang;
                String moTaTienNghiKhac;
                do {
                    System.out.println("tiêu chuẩn phòng: ");
                    tieuChuanPhong = scanner.nextLine();
                } while (!Validators.isValidService(tieuChuanPhong, Validators.tenDV));
                do {
                    System.out.println("số tầng: ");
                    soTang = Integer.parseInt(scanner.nextLine());
                } while (!Validators.isMoreThan(soTang, 0));
                do {
                    System.out.println("mô tả tiện nghi khác: ");
                    moTaTienNghiKhac = scanner.nextLine();
                } while (!Validators.isValidService(moTaTienNghiKhac, Validators.tenDV));
                House house = new House(id, tenDV, dienTichSD, chiPhiThue, soLuongNguoi, kieuThue, tieuChuanPhong,
                        moTaTienNghiKhac, soTang);
                houseList.add(house);
                FileUtils.write(house);
                break;
            }
            default: {
                String tenDichVuMienPhiDiKem;
                int donVi;
                double giaTien;
                do {
                    System.out.println("nhập các dịch vụ miễn phí đi kèm:");
                    System.out.println("tên dịch vụ");
                    tenDichVuMienPhiDiKem = scanner.nextLine();
                } while (!Validators.isValidExtraService(tenDichVuMienPhiDiKem));
                do {
                    System.out.println("đơn vị: ");
                    donVi = Integer.parseInt(scanner.nextLine());
                } while (!Validators.isMoreThan(donVi, 0));
                do {
                    System.out.println("giá tiền");
                    giaTien = Float.parseFloat(scanner.nextLine());
                } while (!Validators.isMoreThan(giaTien, 0));
                DichVuMienPhiDiKem dichVuMienPhiDiKem = new DichVuMienPhiDiKem(tenDichVuMienPhiDiKem, donVi, giaTien);
                Room room = new Room(id, tenDV, dienTichSD, chiPhiThue, soLuongNguoi, kieuThue, dichVuMienPhiDiKem);
                roomList.add(room);
                FileUtils.write(room);
                break;
            }

        }

    }

    public void addNewCustomer() throws IOException {
        scanner = new Scanner(System.in);
        String hoTen;
        String ngaySinh;
        String gioiTinh;
        String cmnd;
        int sdt;
        String email;
        String loaiKhach;
        String diaChi;
        boolean flag;
        do {
            flag = true;
            System.out.println("Nhập họ và tên: ");
            hoTen = scanner.nextLine();
            try {
                Validators.IsFullName(hoTen);
            } catch (NameException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        } while (!flag);
        do {
            flag = true;
            System.out.println("Ngày sinh: ");
            ngaySinh = scanner.nextLine();
            try {
                Validators.isBirthday(ngaySinh);
            } catch (BirthdayException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        } while (!flag);

        do {
            flag = true;
            System.out.println("Giới tính: ");
            gioiTinh = scanner.nextLine();
            try {
                Validators.isGender(gioiTinh);
            } catch (GenderException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        } while (!flag);
        do {
            flag = true;
            System.out.println("cmnd: ");
            cmnd = scanner.nextLine();
            try {
                Validators.isIdCard(cmnd);
            } catch (IdCardException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        } while (!flag);

        System.out.println("số điện thoại : ");
        sdt = Integer.parseInt(scanner.nextLine());
        do {
            flag = true;
            System.out.println("email : ");
            email = scanner.nextLine();
            try {
                Validators.isEmail(email);
            } catch (EmailException e) {
                flag = false;
                System.out.println(e.getMessage());
            }

        } while (!flag);

        System.out.println("loại khách : ");
        loaiKhach = scanner.nextLine();
        System.out.println("địa chỉ: ");
        diaChi = scanner.nextLine();
        Services services = null;
        Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, cmnd, sdt, email, loaiKhach, diaChi, services);
        customerList.add(customer);
        FileUtils.writeCustomer(customer, fileCustomer);

    }

    public void addNewBooking() throws IOException {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i + 1) + "." + customerList.get(i));
        }
        scanner = new Scanner(System.in);
        System.out.println("nhập số customer cần chọn: ");
        int select = Integer.parseInt(scanner.nextLine());
        if (!customerList.contains(customerList.get(select - 1))) {
            System.out.println("nhập sai , xin nhập lại");
        } else {
            boolean isExist = false;
            int selectBooking;

            do {
                System.out.println("lựa chọn booking: \n" +
                        "1.Booking Villa\n" +
                        "2.Booking House\n" +
                        "3.Booking Room\n");
                selectBooking = Integer.parseInt(scanner.nextLine());
                switch (selectBooking) {
                    case 1: {
                        Boolean checkBooking = false;
                        String selectVilla;
                        villaList.forEach(ob -> ob.showInfor());
                        do {
                            System.out.println("nhập mã villa");
                            selectVilla = scanner.nextLine();
                            for (int i = 0; i < villaList.size(); i++) {
                                if (villaList.get(i).getId().contains(selectVilla)) {
                                    customerList.get(select - 1).setServices(villaList.get(i));
                                    FileUtils.writeCustomer(customerList.get(select - 1), fileBooking);
                                    checkBooking = true;
                                    break;
                                }
                            }
                            if (!checkBooking) {
                                System.out.println("mã villa không phù hợp");
                            }
                        } while (!checkBooking);

                        break;
                    }
                    case 2: {
                        Boolean checkBooking = false;
                        String selectHouse;
                        houseList.forEach(ob -> ob.showInfor());
                        do {
                            System.out.println("nhập mã house");
                            selectHouse = scanner.nextLine();
                            for (int i = 0; i < houseList.size(); i++) {
                                if (houseList.get(i).getId().contains(selectHouse)) {
                                    customerList.get(select - 1).setServices(houseList.get(i));
                                    FileUtils.writeCustomer(customerList.get(select - 1), fileBooking);
                                    checkBooking = true;
                                    break;
                                }
                            }
                            if (!checkBooking) {
                                System.out.println("mã house không phù hợp");
                            }
                        } while (!checkBooking);

                        break;
                    }
                    case 3: {
                        Boolean checkBooking = false;
                        String selectRoom;
                        roomList.forEach(ob -> ob.showInfor());
                        do {
                            System.out.println("nhập mã house");
                            selectRoom = scanner.nextLine();
                            for (int i = 0; i < roomList.size(); i++) {
                                if (roomList.get(i).getId().contains(selectRoom)) {
                                    customerList.get(select - 1).setServices(roomList.get(i));
                                    FileUtils.writeCustomer(customerList.get(select - 1), fileBooking);
                                    checkBooking = true;
                                    break;
                                }
                            }
                            if (!checkBooking) {
                                System.out.println("mã house không phù hợp");
                            }
                        } while (!checkBooking);
                        break;
                    }
                    case 4: {
                        isExist = true;
                        break;
                    }
                    default:
                }
            } while (!isExist);

        }
        ;
    }

    public void showInformationCustomers() {
        customerList.sort(Customer::compareTo);
        customerList.forEach(ob -> System.out.println(ob.toString()));
    }

    public void showEmployee() throws IOException {
        Map<String, Employee> map = new HashMap<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(fileEmployee));
        String row;
        String[] employeeArr;
        int count = 1;
        String key = "00";
        while ((row = csvReader.readLine()) != null) {
            String temp = key + count;
            count++;
            employeeArr = row.split(",");
            String name = employeeArr[0];
            String age = employeeArr[1];
            String adress = employeeArr[2];
            Employee employee = new Employee(name, age, adress);
            map.put(temp, employee);
        }
        csvReader.close();
        map.keySet().forEach(ob -> {
            System.out.println(ob + " " + map.get(ob));
        });


    }
}
