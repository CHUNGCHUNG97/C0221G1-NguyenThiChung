package hoa_don_tien_dien.comons;

import hoa_don_tien_dien.models.Bills;
import hoa_don_tien_dien.models.Customer;
import hoa_don_tien_dien.models.CustomerVietNam;
import hoa_don_tien_dien.models.ForeignCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;
    private static String path;

    public static List<String> readTypeCustomer(String file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> typeCustomer = new ArrayList<>();
        String row;
        while ((row = bufferedReader.readLine()) != null) {
            typeCustomer.add(row);
        }
        bufferedReader.close();
        return typeCustomer;
    }

    public static void writeStringToFile(String string, String filePath, boolean appendMode) {

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, appendMode));
            bufferedWriter.write(string);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Customer> readCustomer(String file) {
        List<Customer> arrContent = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrContent.add(ParseCustomer(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return arrContent;
    }

//    public static List<String> readFile(String file) {
//        List<String> stringList = new ArrayList<>();
//        try {
//            bufferedReader = new BufferedReader(new FileReader(file));
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringList.add(line);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return stringList;
//    }

    public static List<Bills> readBill(String file) {
        List<Bills> arrContent = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrContent.add(ParseBill(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return arrContent;
    }

    public static Customer ParseCustomer(String csvStr) {
        try {
            String[] strings = csvStr.split(Constants.COMMA);
            if (strings[0].equals("CustomerVietNam")) {
                String idCustomer = strings[1];
                String fullName = strings[2];
                String typeCustomer = strings[3];
                double usedKW = Double.parseDouble(strings[4]);
                return new CustomerVietNam(idCustomer, fullName, typeCustomer, usedKW);
            } else {
                String idCustomer = strings[1];
                String fullName = strings[2];
                String country = strings[3];
                return new ForeignCustomer(idCustomer, fullName, country);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Bills ParseBill(String csvStr) {
        try {
            String[] strings = csvStr.split(Constants.COMMA);
            int idBill = Integer.parseInt(strings[1]);
            String idCustomer = strings[2];
            String billDate = strings[3];
            double KW = Double.parseDouble(strings[4]);
            double price = Double.parseDouble(strings[5]);
            double intoMoney = Double.parseDouble(strings[6]);
            return new Bills(idBill, idCustomer, billDate, KW, price, intoMoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void setFileName(String fileName) {
        StringBuffer path = new StringBuffer("F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\hoa_don_tien_dien\\datas");
        path.append(fileName);
        path.append(".csv");
        FileUtils.path = path.toString();

    }
}
