package Service;

import Model.Developer;
import Model.Employee;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Service.RecordService.employeesRegister;

public class ScreenService {
    public static void showAllEmployees(){
        employeesRegister.stream()
                .map(Employee::getIncome)
                .forEach(System.out::println);

        System.out.print(employeesRegister.stream()
                .mapToDouble(e -> Double.valueOf(String.valueOf(e.getIncome())))
                .sum());
    }

    public static void findEmployeeeById() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("CPF: ");
            String id = scanner.next();

            for(Employee employee : employeesRegister){
                if(employee.getId().equals(id)){
                    System.out.println("O salário do "
                            + employee.selectPost(employee.getPost())
                            + " "
                            + employee.getName() + " é de R$ "
                            + employee.getIncome());
                    if(employee.getPost()==3){
                        Developer devAux = (Developer) employee;
                        System.out.println("Último bônus: " + devAux.getLastBonusIncrease());
                    }
                    return;
                }
            }
            System.out.println("CPF não cadastrado.");
        } catch (InputMismatchException input){
            throw new InputMismatchException("Entrada inválida.");
        }
    }
}
