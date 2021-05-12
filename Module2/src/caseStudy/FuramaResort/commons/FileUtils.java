package caseStudy.FuramaResort.commons;

import caseStudy.FuramaResort.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static String path;
    static String fileResort = "resort.csv";
    static String fileCustomer = "Customer.CSV";
    static String fileBooking = "Booking.CSV ";

    public static void write(Services service) throws IOException {
        FileWriter fileWriter = new FileWriter(fileResort, true);
        fileWriter.append(service.toCSV());
        fileWriter.append("\n");
        fileWriter.flush();
        fileWriter.close();
        System.out.println("SAVE SUCCESS");
    }

    public static void writeCustomer(Customer customer,String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(customer.toCSV());
        fileWriter.append("\n");
        fileWriter.flush();
        fileWriter.close();
        System.out.println("SAVE SUCCESS");
    }

    public static void writeBooking(Customer customer) throws IOException {
        FileWriter fileWriter = new FileWriter(fileBooking, true);
        fileWriter.append(customer.toCSV());
        fileWriter.append("\n");
        fileWriter.flush();
        fileWriter.close();
        System.out.println("SAVE SUCCESS");
    }


    public static List<Services> read() throws IOException {
        List<Services> servicesList = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader(fileResort));
        String row;

        while ((row = csvReader.readLine()) != null) {

            Services temp = parseService(row);
            if (temp != null) {
                servicesList.add(temp);
            }

        }
        csvReader.close();
        return servicesList;

    }

    public static List<Customer> readCustomer(String file) throws IOException {
        List<Customer> customerList = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        String row;

        while ((row = csvReader.readLine()) != null) {
            customerList.add(parseCustomer(row));
        }
        csvReader.close();
        return customerList;

    }

    public static Customer parseCustomer(String CSVString) throws IOException {
        List<Services> services = read();
        String[] strs = CSVString.split(Constants.COMMACustomer);
        String hoTen = strs[1];
        String ngaySinh = strs[2];
        String gioiTinh = strs[3];
        String cmnd = strs[4];
        int sdt = Integer.parseInt(strs[5]);
        String email = strs[6];
        String loaiKhach = strs[7];
        String diaChi = strs[8];
        String id = strs[9];
        Services service = null;
        for (Services service1 : services) {
            if (service1.getId().equals(id)) {
                service = service1;
            }
        }
        return new Customer(hoTen, ngaySinh, gioiTinh, cmnd, sdt, email, loaiKhach, diaChi, service);
    }

    public static Services parseService(String csvString) {
        try {
            String[] strs = csvString.split(Constants.COMMA);
            if (strs[0].equals("VILLA")) {
                String id = strs[1];
                String name = strs[2];
                String tieuChuanPhong = strs[3];
                String kieuThue = strs[4];
                double dienTichSuDung = Double.parseDouble(strs[5]);
                double dienTichHoBoi = Double.parseDouble(strs[6]);
                double chiPhiThue = Double.parseDouble(strs[7]);
                int soTang = Integer.parseInt(strs[8]);
                String moTaTienNghiKhac = strs[9];
                int soNguoiToiDa = Integer.parseInt(strs[10]);
                return new Villa(id, name, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang);

            } else if (strs[0].equals("HOUSE")) {
                String id = strs[1];
                String name = strs[2];
                String tieuChuanPhong = strs[3];
                String kieuThue = strs[4];
                double dienTichSuDung = Double.parseDouble(strs[5]);
                double chiPhiThue = Double.parseDouble(strs[6]);
                int soTang = Integer.parseInt(strs[7]);
                String moTaTienNghiKhac = strs[8];
                int soNguoiToiDa = Integer.parseInt(strs[9]);
                return new House(id, name, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue, tieuChuanPhong, moTaTienNghiKhac, soTang);

            } else if (strs[0].equals("ROOM")) {
                String id = strs[1];
                String name = strs[2];
                String kieuThue = strs[3];
                double dienTichSuDung = Double.parseDouble(strs[4]);
                double chiPhiThue = Double.parseDouble(strs[5]);
                int soNguoiToiDa = Integer.parseInt(strs[6]);
                String[] dichVuMienPhiDiKem = strs[7].split(Constants.COMMAdichVu);
                String tenDichVuDiKem = dichVuMienPhiDiKem[1];
                int donVi = Integer.parseInt(dichVuMienPhiDiKem[2]);
                double giaTien = Float.parseFloat(dichVuMienPhiDiKem[3]);
                DichVuMienPhiDiKem DVMienPhi = new DichVuMienPhiDiKem(tenDichVuDiKem, donVi, giaTien);
                return new Room(id, name, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue, DVMienPhi);
            }
            return null;
        } catch (Exception e) {
            return null;
        }


    }


}
