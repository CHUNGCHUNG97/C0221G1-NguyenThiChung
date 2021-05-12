package baiThiModule2.controllers;

import java.io.FileNotFoundException;

public class testMain {
    public static void main(String[] args) throws FileNotFoundException {
        MainController mainController=new MainController();
        mainController.loadDanhBa();
    }
}
