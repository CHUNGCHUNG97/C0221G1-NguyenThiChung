package caseStudy.FuramaResort.student;

import OOP.thuchanh.HocSinh;
import caseStudy.FuramaResort.models.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUltils {

    public static void write(People people) throws IOException {
        FileWriter fileWriter = new FileWriter("vc.csv", true);
        fileWriter.append(people.toCSV());
        fileWriter.append("\n");
        fileWriter.flush();
        fileWriter.close();
        System.out.println("SAVE SUCCESS");
    }

    public static List<People> readDatabase() throws IOException {
        List<People> peopleList = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("vc.csv"));
        String row;

        while ((row = csvReader.readLine()) != null) {

            if (row.startsWith("STUDENT")) {
                peopleList.add(parseStudent(row));
            }
            if (row.startsWith("GIAOVIEN")) {
                peopleList.add(parseGiaoVien(row));
            }


        }
        csvReader.close();
        return peopleList;


    }


    public static Student parseStudent(String row) {
        String[] strs = row.split("~");
        String id = strs[1];
        String name = strs[2];
        int age = Integer.parseInt(strs[3]);
        String className = strs[4];
        return new Student(id, age, name, className);


    }

    public static GiaoVien parseGiaoVien(String row) {
        String[] strs = row.split("~");
        String id = strs[1];
        String name = strs[2];
        int age = Integer.parseInt(strs[3]);
        String classCN = strs[4];
        return new GiaoVien(id, age, name, classCN);
    }

    public static void removeGV(String name) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("vc.csv"));
        String row;
        StringBuilder result = new StringBuilder("");
        while ((row = csvReader.readLine()) != null) {
            String[] strings = row.split("~");
            if (!strings[2].toLowerCase().equals(name.toLowerCase()) && row.startsWith("GIAOVIEN")) {
                result.append(row);
                result.append("\n");
            }
        }
        FileWriter fileWriter = new FileWriter("vc.csv", false);
        fileWriter.append(result.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    public static void removeStudent(String name) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("vc.csv"));
        String row;
        StringBuilder result = new StringBuilder("");
        while ((row = csvReader.readLine()) != null) {
            String[] strings = row.split("~");
            if (!strings[2].toLowerCase().equals(name.toLowerCase()) && row.startsWith("STUDENT")) {
                result.append(row);
                result.append("\n");
            }
        }
        FileWriter fileWriter = new FileWriter("vc.csv", false);
        fileWriter.append(result.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
