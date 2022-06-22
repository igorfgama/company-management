package Service;

import Model.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Service.RecordService.employeesRegister;

public class ScreenService {
    public static void showAllEmployees(){
        employeesRegister.stream().forEach(Employee::getName);
        System.out.println("--------");
        for(Employee employee : employeesRegister)
            System.out.println("[" + employee.getName() + ", "
                                   + employee.getId() + ", "
                                   + employee.selectPost(employee.getPost()) + ", R$ "
                                   + employee.getIncome() + "]");
    }

    public static void findEmployeeeById() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("CPF: ");
            String id = scanner.next();

//            if(employeesRegister.stream().findAny().get().getId().equals(id)){
                for(Employee employee : employeesRegister){
                    if(employee.getId().equals(id)){
                        System.out.println("O salário do "
                                + employee.selectPost(employee.getPost())
                                + " "
                                + employee.getName() + " é de R$ "
                                + employee.getIncome());
                        return;
                    }
                }
            System.out.println("CPF não cadastrado.");
//            } else
//                System.out.println("CPF não cadastrado.");
        } catch (InputMismatchException input){
            throw new InputMismatchException("Entrada inválida.");
        }
    }
}
