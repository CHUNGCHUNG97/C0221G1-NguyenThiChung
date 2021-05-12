package hoa_don_tien_dien.controllers;

import hoa_don_tien_dien.comons.FileUtils;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException {
        BillControllers billControllers = new BillControllers();
        billControllers.LoadData();
    }
}
