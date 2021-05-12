package transport.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        mainController.loadFile();
    }
}
