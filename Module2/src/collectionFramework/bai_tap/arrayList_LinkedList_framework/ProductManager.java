package collectionFramework.bai_tap.arrayList_LinkedList_framework;

import java.util.*;

public class ProductManager implements Comparator<SanPham> {

    private ArrayList<SanPham> productList;

    public ArrayList<SanPham> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<SanPham> productList) {
        this.productList = productList;
    }

    public ProductManager(ArrayList<SanPham> productList) {
        this.productList = productList;
    }

    public void show() {
        System.out.println(productList);
    }

    public void listSP() {
        SanPham sanPham1 = new SanPham(1, "smartphone", 15000);
        SanPham sanPham2 = new SanPham(2, "laptop", 25000);
        productList.add(sanPham1);
        productList.add(sanPham2);
        System.out.println(productList);
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sản phẩm muốn thêm vào");
        int soLuong = scanner.nextInt();
        int i = 0;
        while (i < soLuong) {
            System.out.println("Nhập id sản phẩm");
            int id = scanner.nextInt();
            System.out.println("Nhập tên sản phẩm");
            String name = scanner.next();
            System.out.println("Nhập giá sản phẩm");
            double price = scanner.nextFloat();
            SanPham sanPham = new SanPham(id, name, price);
            productList.add(sanPham);
            System.out.println(productList);
            i++;
        }
    }

    public void edit(int id) {

        for (SanPham sanPham : productList
        ) {
            if ((sanPham.getId()) == id) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Nhập tên mới");
                String name = scanner.next();
                sanPham.setName(name);
                System.out.println("Nhập giá sản phẩm");
                double price = scanner.nextFloat();
                sanPham.setPrice(price);
                System.out.println("sửa thành công");
                break;
            }
        }

    }

    public void remove(int id) {
        SanPham sanPham = new SanPham();
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(productList.get(i));
                break;
            }

        }
        show();
    }

    @Override
    public int compare(SanPham o1, SanPham o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        ArrayList<SanPham> list = new ArrayList<>();
        ProductManager productManager = new ProductManager(list);
        productManager.listSP();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id cần sửa");
        int id = scanner.nextInt();
        productManager.edit(id);
        productManager.show();
        Collections.sort(list, productManager);
        productManager.show();
        System.out.println("nhập id của sp cần xóa");
        int id2 = scanner.nextInt();
        productManager.remove(id2);

    }

}
