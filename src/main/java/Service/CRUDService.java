package Service;

import Model.Coordinator;
import Model.Developer;
import Model.Employee;
import Model.ProjectManager;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

import static Service.RecordService.employeesRegister;
import static java.lang.System.exit;

public class CRUDService {
    public static void readFile() throws FileNotFoundException {
        Scanner scannerFile = new Scanner(new File("dados.csv"));
        while (scannerFile.hasNextLine()) {
            String line = scannerFile.nextLine();
            Scanner readLine = new Scanner(line);
            readLine.useDelimiter(",");

            String name = readLine.next();
            String id = readLine.next();
            int post = Integer.parseInt(readLine.next());
            BigDecimal income = new BigDecimal(readLine.next());

            switch (post) {
                case 1 -> employeesRegister.add(new ProjectManager(name, id, post, income));
                case 2 -> employeesRegister.add(new Coordinator(name, id, post, income));
                case 3 -> employeesRegister.add(new Developer(name, id, post, income));
                default -> System.out.println("Entrada inválida.");
            }

            readLine.close();
        }
    }

    public static void writeFile() throws IOException {
        OutputStream fos = new FileOutputStream("dados.csv");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for(Employee employee : employeesRegister){
            bw.write(employee.getName() + "," + employee.getId() + "," + employee.getPost() + "," + employee.getIncome());
            bw.newLine();
        }

        bw.close();
        exit(0);
    }
}