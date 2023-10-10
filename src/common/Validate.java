package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class Validate {

    public String checkString(String s) {
        String str = "";
        while (str.isBlank() || str.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print(s + ": ");
            str = sc.nextLine();
            return str;
        }
        System.err.println("Please enter something.");
        return "";
    }

    public int checkAge(String s) {
        int age = 0;
        while (age < 18 || age > 50) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(s + ": ");
                age = sc.nextInt();
                if (age < 18 || age > 50){
                    System.out.println("Age between 18 and 50");
                }
            } catch (InputMismatchException e) {
                System.err.println("Input number");
            }
        }
        return age;
    }

    public double checkSalary(String s) {
        double salary = 0;
        while (salary <= 0) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(s + ": ");
                salary = sc.nextInt();
                if(salary <= 0){
                    System.out.println("Salary must greater than 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Input number");
            }
        }
        return salary;
    }

    public boolean checkCodeExist(List<Worker> wl, String code) {
        for (Worker worker : wl) {
            if (worker.getCode().equals(code)) {
                return false;
            }
        }
        return true;
    }

    public Date checkDate(String s) {
        Date date;
        while (true) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                date = sdf.parse(checkString(s));
                return date;
            } catch (ParseException e) {
                System.err.println("Wrong format(dd//MM//yyyy)");
            }
        }
    }
}
