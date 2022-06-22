package Main;

import Service.CRUDService;
import Service.MenuService;

import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        CRUDService.readFile();
        MenuService.menu();
    }
}