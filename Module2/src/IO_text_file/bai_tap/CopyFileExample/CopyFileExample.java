package IO_text_file.bai_tap.CopyFileExample;

import java.io.*;

public class CopyFileExample {
    public static void main(String[] args) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File("src\\IO_text_file\\text1.txt"));
            out = new FileOutputStream(new File("src\\IO_text_file\\text2.txt"));
            int length;
            byte[] buffer = new byte[1024];

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);

            }

            System.out.println("File is copied successful!");
        } catch (FileNotFoundException e) {
            System.out.println("không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            in.close();
            out.close();
        }
    }
}
