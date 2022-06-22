package Service;

import Model.Coordinator;
import Model.Developer;
import Model.Employee;
import Model.ProjectManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RecordService {
    static List<Employee> employeesRegister = new ArrayList<>();

    public static void setBasisIncome(BigDecimal income) {

    }
    public static void recordEmployee(int choice, BigDecimal income) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Nome: ");
            String name = scanner.next();
            System.out.println("CPF: ");
            String id = scanner.next();
            switch (choice) {
                case 1 -> employeesRegister.add(new ProjectManager(name, id, choice, income.multiply(new BigDecimal("1.8"))));
                case 2 -> employeesRegister.add(new Coordinator(name, id, choice, income.multiply(new BigDecimal("1.6"))));
                case 3 -> employeesRegister.add(new Developer(name, id, choice, income.multiply(new BigDecimal("1.2"))));
                default -> System.out.println("Entrada inválida.");
            }
        } catch (InputMismatchException input){
            throw new InputMismatchException("Entrada inválida.");
        }
    }
}
