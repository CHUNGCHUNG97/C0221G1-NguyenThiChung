package binaryFile_Serialization.thuc_hanh.copyFile;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    private static void copyFileUsingStream(File source, File dest) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("successfull");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("file source: ");
        String sourcePath = sc.nextLine();
        System.out.println("file dest: ");
        String destPath = sc.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        copyFileUsingStream(sourceFile, destFile);
    }
}
