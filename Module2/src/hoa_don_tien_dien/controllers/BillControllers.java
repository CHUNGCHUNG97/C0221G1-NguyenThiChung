package hoa_don_tien_dien.controllers;

import hoa_don_tien_dien.comons.FileUtils;
import hoa_don_tien_dien.models.Bills;
import hoa_don_tien_dien.models.Customer;
import hoa_don_tien_dien.models.CustomerVietNam;
import hoa_don_tien_dien.models.ForeignCustomer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class BillControllers {
    List<Customer> customerList = new ArrayList<>();
    List<Bills> billsList = new ArrayList<>();
    private static final String fileTypeCustomer = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\hoa_don_tien_dien\\datas\\loaiKhach.csv";
    private static final String fileCustomer = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\hoa_don_tien_dien\\datas\\khanhHang.csv";
    private static final String fileBill = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\hoa_don_tien_dien\\datas\\hoadon.csv";
    private static Scanner scanner;
    boolean isExit = false;

    public void LoadData() throws IOException {
        FileUtils.readCustomer(fileCustomer).forEach(ob -> {
            customerList.add(ob);
        });
        FileUtils.readBill(fileBill).forEach(ob -> {
            billsList.add(ob);
        });
        DisplayMenu();
    }

    public void DisplayMenu() throws IOException {

        scanner = new Scanner(System.in);
        int select;
        do {
            System.out.println("Chọn chức năng\n" +
                    "1. Thêm mới khách hàng.\n" +
                    "2. Hiện thị thông tin khách hàng\n" +
                    "3. Tìm kiếm khách hàng\n" +
                    "4. Thêm mới hóa đơn\n" +
                    "5. Chỉnh sửa hóa đơn\n" +
                    "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                    "7. Thoát\n");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1: {
                    addCustomer();
                    break;
                }
                case 2: {
                    showInforCustomer();
                    break;
                }
                case 3: {
                    searchCustomer();
                    break;
                }
                case 4: {
                    addBills();
                    break;
                }
                case 5: {
                    editBills();
                    break;
                }
                case 6: {
                    showBills();
                    break;
                }
                case 7: {
                    isExit = true;
                    break;
                }
                default:
            }
        } while (!isExit);
    }

    private void showBills() {
        int select;
        do {
            System.out.println("chọn hóa đơn cần xem chi tiết: ");
            for (int i = 0; i < billsList.size(); i++) {
                System.out.println((i + 1) + "." + billsList.get(i));
            }
            select = Integer.parseInt(scanner.nextLine());
            if (select < 1 || select > billsList.size()) {
                System.out.println("số hóa đơn bạn chọn không đúng, hãy nhập lại: ");
            }
        } while (select < 1 || select > billsList.size());
        boolean isFounded = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdCustomer().equals(billsList.get(select - 1).getIdCustomer())) {
                System.out.println(billsList.get(select - 1).toString() + " of " + customerList.get(i).toString());
                isFounded = true;
                break;
            }
        }
        if (!isFounded) {
            System.out.println("không tìm thấy khách hàng phù hợp với khách hàng trong hóa đơn");
        }
    }

    private void editBills() throws IOException {
        int select;
        do {
            for (int i = 0; i < billsList.size(); i++) {
                System.out.println((i + 1) + "." + billsList.get(i));
            }
            select = Integer.parseInt(scanner.nextLine());
        } while (select < 1 || select > billsList.size());
        String idCustomer;
        do {
            System.out.println("id customer change: ");
            idCustomer = scanner.nextLine();
        } while (!Validates.isIdCustomer(idCustomer, Validates.idCustomer_Regex));
        Bills billAccess = billsList.get(select - 1);
        billAccess.setIdCustomer(idCustomer);
        StringBuilder stringBuilder = new StringBuilder("");
        billsList.forEach(ob -> {
            stringBuilder.append(ob.toCSV()).append("\n");
        });
        FileUtils.writeStringToFile(stringBuilder.toString(), fileBill, false);

        System.out.println("change success!!");

    }

    private void addBills() throws IOException {
        boolean isExsit = false;
        int select;
        String idCustomer;
        do {
            showInforCustomer();
            select = Integer.parseInt(scanner.nextLine());
            if (select < 1 || select > customerList.size()) {
                System.out.println("số bạn nhập không có trong danh sách, nhập lại:");
            }
        } while (select < 1 || select > customerList.size());
        idCustomer = customerList.get(select - 1).getIdCustomer();
        int idBill = billsList.size() + 1;
        System.out.println("ngày ra hóa đơn: ");
        String billDate = scanner.nextLine();
        System.out.println("số KW tiêu thụ:");
        double KW = Double.parseDouble(scanner.nextLine());
        System.out.println("đơn giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        Customer customerAccess = customerList.get(select - 1);
        double intoMoney = 0;
        if (customerAccess instanceof CustomerVietNam) {
            if ((KW <= ((CustomerVietNam) customerAccess).usedKW)) {
                intoMoney = KW * price;
            } else {
                intoMoney = KW * price * ((CustomerVietNam) customerAccess).usedKW +
                        (KW - ((CustomerVietNam) customerAccess).usedKW) * price * 2.5;
            }
        } else {
            intoMoney = KW * price;
        }
        Bills bill = new Bills(idBill, idCustomer, billDate, KW, price, intoMoney);
        FileUtils.writeStringToFile(bill.toCSV(), fileBill, true);
        billsList.add(bill);
        System.out.println("add success!!");
    }

    private void searchCustomer() {
        List<Customer> list = new ArrayList<>();
        System.out.println("input name of customer: ");
        String name = scanner.nextLine();
        for (Customer customer : customerList) {
            if (customer.getFullName().toLowerCase().contains(name)) {
                list.add(customer);
            }
        }
        if (list.size() == 0) {
            System.out.println("is not found");
        } else {
            list.forEach(ob -> {
                System.out.println(ob.toString());
            });
        }
    }

    private void showInforCustomer() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i + 1) + "." + customerList.get(i).toString());
        }
    }

    private void addCustomer() throws IOException {
        int select;
        do {
            System.out.println("Chọn loại khách hàng cần thêm: \n" +
                    "1. Thêm khách hàng VN,\n" +
                    "2. Thêm khách hàng nước ngoài\n" +
                    "3. Back to Menu\n" +
                    "4. Exit");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1: {
                    addTypeCustomer();
                    break;
                }
                case 2: {
                    addTypeCustomer();
                    break;
                }
                case 3: {
                    DisplayMenu();
                    break;
                }
                case 4: {
                    isExit = true;
                    break;
                }
            }
        } while (!isExit);
    }

    private void addTypeCustomer() throws IOException {
        String idCustomer;
        do {
            System.out.println("id customer: ");
            idCustomer = scanner.nextLine();
        } while (!Validates.isIdCustomer(idCustomer, Validates.idCustomer_Regex));

        System.out.println("full name: ");
        String fullName = scanner.nextLine();
        if (idCustomer.contains("KHVN")) {
            String typeCustomer = typeCustomerOfVN(FileUtils.readTypeCustomer(fileTypeCustomer));
            System.out.println("KW used: ");
            double usedKW = Float.parseFloat(scanner.nextLine());
            CustomerVietNam customerVietNam = new CustomerVietNam(idCustomer, fullName, typeCustomer, usedKW);
            FileUtils.writeStringToFile(customerVietNam.toCSV(), fileCustomer, true);
            customerList.add(customerVietNam);
        } else {
            System.out.println("Country: ");
            String country = scanner.nextLine();
            ForeignCustomer foreignCustomer = new ForeignCustomer(idCustomer, fullName, country);
            FileUtils.writeStringToFile(foreignCustomer.toCSV(), fileCustomer, true);
            customerList.add(foreignCustomer);
        }
        System.out.println("add success!!");
    }

    public static String typeCustomerOfVN(List<String> str) throws IOException {
        String typeCustomer = null;
        int select;
        boolean isExit = false;
        do {
            System.out.println("chọn loại khách hàng VN: ");
            for (int i = 0; i < str.size(); i++) {
                System.out.println((i + 1) + "." + str.get(i));
            }
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1: {
                    typeCustomer = str.get(0).split(",")[1];
                    isExit = true;
                    break;
                }
                case 2: {
                    typeCustomer = str.get(1).split(",")[1];
                    isExit = true;
                    break;
                }
                case 3: {
                    typeCustomer = str.get(2).split(",")[1];
                    isExit = true;
                    break;
                }
                default:
                    System.out.println("lựa chọn không phù hợp, chọn lại:");
            }
        } while (!isExit);
        return typeCustomer;
    }

}


