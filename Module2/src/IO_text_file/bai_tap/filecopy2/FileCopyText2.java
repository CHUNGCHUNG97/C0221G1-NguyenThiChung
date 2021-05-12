package IO_text_file.bai_tap.filecopy2;

import java.io.*;

public class FileCopyText2 {
    public static void main(String[] args) throws IOException {
        try {
            String in = "src\\IO_text_file\\text1.txt";
            String out = "src\\IO_text_file\\text2.txt";
            BufferedReader reader1 = new BufferedReader(new FileReader(in));
            BufferedWriter reader2 = new BufferedWriter(new FileWriter(out));
            String line;
            while ((line = reader1.readLine()) != null) {
                reader2.append(line);//thêm chuỗi vào file chứa
                reader2.newLine();// xuống dòng
            }
            reader1.close();
            reader2.flush();//xả dữ liệu của một stream và gửi nó vào một stream khác.yêu cầu sử dụng nếu đã kết nối một stream với một stream khác.
            reader2.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("succesfull!!");

    }
}
