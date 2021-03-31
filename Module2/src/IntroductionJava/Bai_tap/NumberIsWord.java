package IntroductionJava.Bai_tap;

import java.util.Scanner;

public class NumberIsWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int so;
        do {
            System.out.println("Nhap so can dich: ");
            so = scanner.nextInt();
            if (so < 0) {
                System.out.println("Khong duoc nhap so am");
            }
        } while (so < 0);
        int hangTram = Math.floorDiv(so, 100);
        int soDuHangChuc = (so - hangTram * 100);
        int hangChuc = Math.floorDiv(soDuHangChuc, 10);
        int hangDV = soDuHangChuc - hangChuc * 10;
        String readNum = "";
        if (hangTram != 0) {
            readNum += readNum(hangTram) + " hundered" + " and ";
            ;
        }

        if (soDuHangChuc == 0) {
            System.out.println(readNum);
            return;
        } else {

            if (hangChuc == 1) {
                switch (hangDV) {
                    case 1: {
                        readNum += " eleven";
                        break;
                    }
                    case 2: {
                        readNum += " twelve";
                        break;
                    }
                    case 3: {
                        readNum += " thirteen";
                        break;
                    }
                    case 5: {
                        readNum += " fifteen";
                        break;
                    }
                    case 0: {
                        readNum += " ten";
                        break;
                    }
                    default: {
                        String temp = readNum(hangDV);
                        readNum += (temp + "teen");
                    }
                }
                System.out.println(readNum);
                return;
            } else if (hangChuc == 2) {
                readNum += (" twenty" + readNum(hangDV));
                System.out.println(readNum);
                return;
            } else if (hangChuc == 3) {
                readNum += (" thirty " + readNum(hangDV));
                System.out.println(readNum);
                return;
            } else if (hangChuc == 5) {
                readNum += (" fifty " + readNum(hangDV));
                System.out.println(readNum);
                return;
            } else if (hangChuc == 0) {
                readNum += readNum(hangDV);
                System.out.println(readNum);
                return;
            } else {
                readNum += (readNum(hangChuc) + "ty " + readNum(hangDV));
                System.out.println(readNum);
                return;
            }
        }
    }

    public static String readNum(int so) {
        String res = "";
        switch (so) {
            case 1: {
                res += "one";
                break;
            }
            case 2: {
                res += "two";
                break;
            }
            case 3: {
                res += "three";
                break;
            }
            case 4: {
                res += "four";
                break;
            }
            case 5: {
                res += "five";
                break;
            }
            case 6: {
                res += "six";
                break;
            }
            case 7: {
                res += "seven";
                break;
            }
            case 8: {
                res += "eight";
                break;
            }
            case 9: {
                res += "nine";
                break;
            }
            default: {
                res += "";
            }
        }
        return res;
    }
}
