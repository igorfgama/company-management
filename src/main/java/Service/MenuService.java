package Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class MenuService {

    static BigDecimal basisIncome = null;

    private static BigDecimal setBasisIncome(){
        if(Objects.isNull(basisIncome)){
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Defina o salário base: ");
                basisIncome = new BigDecimal(scanner.next());

                return basisIncome;
            } catch (InputMismatchException input){
                throw new InputMismatchException("Entrada inválida.");
            }
        } else
            return basisIncome;
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                System.out.print("CADASTRAR:\n    1. GERENTE\n    2. COORDENADOR\n    3. PROGRAMADOR\n" +
                        "4. LISTAR FUNCIONÁRIOS\n5. BUSCAR POR FUNCIONÁRIO\n6. SAIR\n -> ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1, 2, 3 -> RecordService.recordEmployee(choice, setBasisIncome());
                    case 4 -> ScreenService.showAllEmployees();
                    case 5 -> ScreenService.findEmployeeeById();
                    case 6 -> CRUDService.writeFile();
                    default -> System.out.println("Entráda inválida.");
                }
            } catch (InputMismatchException input){
                throw new InputMismatchException("Entrada inválida.");
            } catch (IOException e) {
                throw new RuntimeException("Erro na escrita do arquivo.");
            }
        }
    }
}