package transport.controllers;

import transport.comons.ContantsTransport;
import transport.comons.FileUtils;
import transport.models.Cars;
import transport.models.Motorbikes;
import transport.models.Trucks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    List<Cars> carsList = new ArrayList<>();
    List<Trucks> truckList = new ArrayList<>();
    List<Motorbikes> motorbikeList = new ArrayList<>();
    private static final String fileCar = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\transport\\data\\oto.csv";
    private static final String fileTruck = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\transport\\data\\xeTai.csv";
    private static final String fileMotorbike = "F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\transport\\data\\xeMay.csv";
    Scanner scanner;
    boolean isExit = false;

    public void loadFile() throws IOException {
        try {
            FileUtils.loadTruck(fileTruck).forEach(ob -> {
                truckList.add(ob);
            });
            FileUtils.loadCar(fileCar).forEach(ob -> {
                carsList.add(ob);
            });
            FileUtils.loadMotorBike(fileMotorbike).forEach(ob -> {
                motorbikeList.add(ob);
            });

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        DisplayMenu();
    }

    public void DisplayMenu() throws FileNotFoundException {
        int select;
        scanner = new Scanner(System.in);
        do {
            System.out.println("chọn chức năng: \n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1: {
                    addTransport();
                    break;
                }
                case 2: {
                    showTransport();
                    break;
                }
                case 3: {
                    removeTransport();
                    break;
                }
                case 4: {
                    isExit = true;
                    break;
                }
                default:
                    System.out.println("lựa chọn không phù hợp, hãy chọn lại:");
            }
        } while (!isExit);

    }

    private void addTransport() throws FileNotFoundException {
        int select;
        scanner = new Scanner(System.in);
        do {
            System.out.println("chọn phương tiện cần thêm:\n" +
                    "1. Add truck\n" +
                    "2. Add car \n" +
                    "3. Add motorbike\n" +
                    "4. Back to menu\n" +
                    "5.Exit");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1: {
                    addTransportByType();
                    break;
                }
                case 2: {
                    addTransportByType();
                    break;
                }
                case 3: {
                    addTransportByType();
                    break;
                }
                case 4: {
                    DisplayMenu();
                    break;
                }
                case 5: {
                    isExit = true;
                    break;
                }
                default:
                    System.out.println("lựa chọn không phù hợp, hãy chọn lại:");
            }
        } while (!isExit);
    }

    private void addTransportByType() {
        scanner = new Scanner(System.in);
        String controlSign = controllSign();

        String manufacturer = null;
        try {
            manufacturer = manufacturer();
            System.out.println("yearManufacturer: ");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        int yearManufacturer = Integer.parseInt(scanner.nextLine());
        System.out.println("owner: ");
        String owner = scanner.nextLine();
        if (String.valueOf(controlSign.charAt(2)).equals("C")) {
            System.out.println("payload: ");
            double payload = Double.parseDouble(scanner.nextLine());
            Trucks truck = new Trucks(controlSign, manufacturer, yearManufacturer, owner, payload);
            truckList.add(truck);
            FileUtils.writeFile(truck.toCSV(), fileTruck, true);
            System.out.println("add success!!");
        } else if (String.valueOf(controlSign.charAt(2)).equals("A") || String.valueOf(controlSign.charAt(2)).equals("B")) {
            System.out.println("numberSeat: ");
            int numberSeat = Integer.parseInt(scanner.nextLine());
            System.out.println("typeCar: ");
            String typeCar = scanner.nextLine();
            Cars car = new Cars(controlSign, manufacturer, yearManufacturer, owner, numberSeat, typeCar);
            carsList.add(car);
            FileUtils.writeFile(car.toCSV(), fileCar, true);
            System.out.println("add success!!");
        } else {
            System.out.println("wattage: ");
            int wattage = Integer.parseInt(scanner.nextLine());
            Motorbikes motorbike = new Motorbikes(controlSign, manufacturer, yearManufacturer, owner, wattage);
            motorbikeList.add(motorbike);
            FileUtils.writeFile(motorbike.toCSV(), fileMotorbike, true);
            System.out.println("add success!!");
        }

    }

    private void showTransport() throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int select;
        do {
            System.out.println("select transport need show: \n" +
                    "1. Show truck\n" +
                    "2. Show car \n" +
                    "3. Show motorbike");
            select = Integer.parseInt(scanner.nextLine());
            if (select < 1 || select > 3) {
                System.out.println("incorrect choice , input select: ");
            }
        } while (select < 1 || select > 3);
        switch (select) {
            case 1: {
                if (truckList.size() == 0) {
                    System.out.println("is not data");
                } else {
                    truckList.forEach(ob -> {
                        System.out.println(ob.toString());
                    });
                }
                break;
            }
            case 2: {
                if (carsList.size() == 0) {
                    System.out.println("is not data");
                } else {
                    carsList.forEach(ob -> {
                        System.out.println(ob.toString());
                    });
                }
                break;
            }
            case 3: {
                if (motorbikeList.size() == 0) {
                    System.out.println("is not data");
                } else {
                    motorbikeList.forEach(ob -> {
                        System.out.println(ob.toString());
                    });
                }
                break;
            }
            default:
                System.out.println("is not infor");
        }
    }

    private void removeTransport() throws FileNotFoundException {
        scanner = new Scanner(System.in);
        System.out.println("how do you want remove controllSign of transport?");
        String controllSign = scanner.nextLine();
        boolean isFounded = false;
        if (String.valueOf(controllSign.charAt(2)).contains("C")) {
            for (int i = 0; i < truckList.size(); i++) {
                if (truckList.get(i).getControlSign().equals(controllSign)) {
                    System.out.println("confirm remove: \n" +
                            "1. Yes\n" +
                            "2. No");
                    int select = Integer.parseInt(scanner.nextLine());
                    if (select == 1) {
                        truckList.remove(truckList.get(i));
                    } else {
                        return;
                    }
                    isFounded = true;
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("");
            truckList.forEach(ob -> stringBuilder.append(ob.toCSV()).append("\n"));
            FileUtils.writeFile(stringBuilder.toString(), fileTruck, false);
            System.out.println("delete success!!");
        } else if (String.valueOf(controllSign.charAt(2)).contains("A") || String.valueOf(controllSign.charAt(2)).contains("B")) {
            for (int i = 0; i < carsList.size(); i++) {
                if (carsList.get(i).getControlSign().equals(controllSign)) {
                    System.out.println("confirm remove: \n" +
                            "1. Yes\n" +
                            "2. No");
                    int select = Integer.parseInt(scanner.nextLine());
                    if (select == 1) {
                        carsList.remove(carsList.get(i));
                    } else {
                        return;
                    }
                    isFounded = true;
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("");
            carsList.forEach(ob -> stringBuilder.append(ob.toCSV()).append("\n"));
            FileUtils.writeFile(stringBuilder.toString(), fileCar, false);
            System.out.println("delete success!!");

        } else {
            for (int i = 0; i < motorbikeList.size(); i++) {
                if (motorbikeList.get(i).getControlSign().equals(controllSign)) {
                    System.out.println("confirm remove: \n" +
                            "1. Yes\n" +
                            "2. No");
                    int select = Integer.parseInt(scanner.nextLine());
                    if (select == 1) {
                        motorbikeList.remove(motorbikeList.get(i));
                    } else {
                        return;
                    }
                    isFounded = true;
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("");
            motorbikeList.forEach(ob -> stringBuilder.append(ob.toCSV()).append("\n"));
            FileUtils.writeFile(stringBuilder.toString(), fileMotorbike, false);
            System.out.println("delete success!!");
        }
        if (!isFounded) {
            System.out.println("is not found controllSign");
        }

    }

    public String manufacturer() throws FileNotFoundException {
        int select;
        try {
            List<String> manufacturerList = FileUtils.readFile("F:\\codegym\\C0221G1-NguyenThiChung\\Module2\\src\\transport\\data\\hangSanXuat.csv");
            do {
                for (int i = 0; i < manufacturerList.size(); i++) {
                    System.out.println((i + 1) + "." + manufacturerList.get(i));
                }
                select = Integer.parseInt(scanner.nextLine());
                if (select < 1 || select > manufacturerList.size()) {
                    System.out.println("số bạn nhập không phù hợp, hãy nhập lại: ");
                }
            } while (select < 1 || select > manufacturerList.size());
            String manufacturer = manufacturerList.get(select - 1).split(",")[1];
            return manufacturer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String controllSign() {
        scanner = new Scanner(System.in);
        String controllSign;
        int select;
        do {
            System.out.println("controllSign of transport:\n" +
                    "1.truck\n" +
                    "2.car\n" +
                    "3.motorbike");
            select = Integer.parseInt(scanner.nextLine());
            if (select < 1 || select > 3) {
                System.out.println("incorrect choice, input select: ");
            }
        } while (select < 1 || select > 3);
        switch (select) {
            case 1: {
                do {
                    System.out.println("input controllSing of truck: ");
                    controllSign = scanner.nextLine();
                } while (!Validates.isControllSign(controllSign, Validates.controllSignTruck));
                break;
            }
            case 2: {
                do {
                    System.out.println("input controllSing of car: ");
                    controllSign = scanner.nextLine();
                } while (!Validates.isControllSign(controllSign, Validates.controllSignCar));
                break;
            }
            case 3: {
                do {
                    System.out.println("input controllSing of motorbike: ");
                    controllSign = scanner.nextLine();
                } while (!Validates.isControllSign(controllSign, Validates.controllSignMotorbike));
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + select);
        }
        return controllSign;
    }
}
