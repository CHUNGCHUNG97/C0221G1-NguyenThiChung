package binaryFile_Serialization.bai_tap.quan_ly_sp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanPham {
    List<Product> products = new ArrayList<>();
    private final String file = "src\\binaryFile_Serialization\\bai_tap\\quan_ly_sp\\chung.docx";

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã SP");
        String maSP = scanner.nextLine();
        System.out.println("Nhập tên SP");
        String tenSP = scanner.nextLine();
        System.out.println("Nhập hãng sx");
        String hangSX = scanner.nextLine();
        System.out.println("Nhập giá SP");
        double gia = scanner.nextDouble();
        Product product = new Product(maSP, tenSP, hangSX, gia);
        this.products.add(product);
        exportFile();

    }

    public void show() {
        if (products.isEmpty()){
            System.out.println("chưa có sản phẩm nào");
        }else {
            products.forEach(ob -> System.out.println(products.toString()));
        }

    }

    public void exportFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(products);
            objectOutput.close();
            System.out.println("đã thêm sản phẩm vào file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFile() throws IOException {
        FileInputStream fileInput = new FileInputStream(file);
        try {

            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            products = (List<Product>) objectInput.readObject();
            System.out.println("file đã có " + products.size() + " sản phẩm");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("load du lieu");
            exportFile();
        } catch (ClassNotFoundException e) {
            System.out.println("chưa có sp");
            exportFile();

        } finally {
            fileInput.close();
        }

    }

    public void remove() {
        products.clear();
        exportFile();
    }

    public void searchByNameSP() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cần tìm");
        String tenSP = scanner.nextLine();
        List<Product> filters = new ArrayList<>();
        for (Product product : products
        ) {
            if (product.getName().toLowerCase().contains(tenSP.toLowerCase())) {
                filters.add(product);
            }
        }
        if (filters.isEmpty()){
            System.out.println("không tìm thấy sản phẩm ");
        }else {
            System.out.println(filters);
        }
    }

    public void select() throws IOException {
        boolean isExist = false;
        Scanner scanner = new Scanner(System.in);
        while (!isExist) {
            System.out.println("\n");
            System.out.println("Chọn chức năng : \n" +
                    "1.Show danh sách sản phẩm\n" +
                    "2.Thêm sản phẩm\n" +
                    "3.load danh sách sản phẩm\n" +
                    "4.Xóa tất cả sản phẩm đã có trong file\n" +
                    "5.Tìm kiếm sản phẩm theo tên\n" +
                    "6.Exit");
            int select = scanner.nextInt();
            switch (select) {
                case 1: {
                    this.show();
                    break;
                }
                case 2: {
                    this.addProduct();
                    break;
                }
                case 3: {
                    this.loadFile();
                    break;
                }
                case 4: {
                    this.remove();
                    break;
                }
                case 5:{
                    this.searchByNameSP();
                    break;
                }
                case 6: {
                    isExist = true;
                    break;
                }
                default:{

                }
            }
        }

    }

}
