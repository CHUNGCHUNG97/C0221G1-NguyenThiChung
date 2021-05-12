package binaryFile_Serialization.vidu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    private final String srcFile = "src\\binaryFile_Serialization\\vidu\\chung.doc";

    public ProductManager() throws IOException {

    }


    public void managerDisplay() {
        boolean isExist = false;
        Scanner scanner;
        while (!isExist) {
            scanner = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Nhập để lựa chọn chức năng\n" +
                    "1. Thêm sản phẩm\n" +
                    "2. Show\n" +
                    "3. Xóa tất cả\n" +
                    "4. Tìm kiếm bằng tên SP\n" +
                    "5. Thoát");
            int selectedMenu = scanner.nextInt();
            switch (selectedMenu) {
                case 1: {
                    addProduct();
                    break;
                }
                case 2: {
                    this.show();
                    break;
                }
                case 3: {
                    this.removeAll();
                    break;
                }
                case 4: {
                    this.searchByProductName();
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

    public void show() {
        products.forEach(ob -> System.out.println(ob.toString()));
    }

    public void removeAll() {
        //danh sach trống;
        products.clear();
        exportFile();
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã SP");
        String maSP = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String tenSP = scanner.nextLine();
        System.out.println("Nhập tên hãng");
        String hang = scanner.nextLine();
        System.out.println("Giá sản phẩm");
        double gia = scanner.nextDouble();
        Product product = new Product(maSP, tenSP, hang, gia);
        this.products.add(product);
        exportFile();
    }


    public void addMore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số sản phẩm bạn muốn thêm vào");
        int count = scanner.nextInt();
        int i = 1;
        while (i <= count) {
            addProduct();
            i++;
        }


    }

    public void removeByIndex(int index) {
        ///
    }

    public void exportFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(srcFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(products);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getSize() {
        System.out.println(products.size());
    }

    public void loadFile() throws IOException {

        FileInputStream fstream = new FileInputStream(srcFile);
        try {
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            products = (List<Product>) ostream.readObject();
            System.out.println(products);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("TẠO MỚI DANH SACH");
            exportFile();
        } finally {
            fstream.close();
        }

    }

    public void searchByProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm bạn muốn tìm");
        String searchName = scanner.nextLine();
        List<Product> filters = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(searchName)) {
                filters.add(product);
            }
        }

//        List<Product> filters = products.stream().filter(product->product.getName().toLowerCase().contains(searchName.toLowerCase())).collect(Collectors.toList());
        if (filters.isEmpty()) {
            System.out.println("không tìm thấy");
        } else {
            filters.forEach(ob -> System.out.println(ob.toString()));
        }


    }
}
