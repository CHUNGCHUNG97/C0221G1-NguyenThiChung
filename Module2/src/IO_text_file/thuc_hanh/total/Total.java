package IO_text_file.thuc_hanh.total;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Total {
    public static void main(String[] args) {
        String fileNumber = "src\\IO_text_file\\sum.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileNumber));
            String line;
            int sum = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    sum += Integer.parseInt(line);
                }
            }
            System.out.println(sum);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("file không tồn tại");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException m) {
            System.out.println("nội dung trong file lỗi");
        }

    }
}
