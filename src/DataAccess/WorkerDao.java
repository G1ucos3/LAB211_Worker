package DataAccess;

import common.Sorting;
import common.Validate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class WorkerDao {

    private static WorkerDao instance = null;
    Validate validate = new Validate();

    public static WorkerDao Instance() {
        if (instance == null) {
            synchronized (WorkerDao.class) {
                if (instance == null) {
                    instance = new WorkerDao();
                }
            }
        }
        return instance;
    }

    public boolean addWorker(List<Worker> wl, Worker worker) {
        String code = validate.checkString("Enter code");
        if (!validate.checkCodeExist(wl, code)) {
            return false;
        }
        String name = validate.checkString("Enter name");
        int age = validate.checkAge("Enter Age");
        double salary = validate.checkSalary("Enter Salary");
        String workLocation = validate.checkString("Enter work location");
        String status = "-----";
        Date date = validate.checkDate("Enter Date");
        worker = new Worker(code, name, age, salary, workLocation, status, date);
        wl.add(worker);
        return true;
    }

    public boolean changeSalary(List<Worker> wl, Worker worker, int type) {
        String code = validate.checkString("Enter code");
        if (validate.checkCodeExist(wl, code)) {
            return false;
        }
        worker = findByCode(wl, code);
        double currentSalary = worker.getSalary();
        switch (type) {
            case 1:
                double up = validate.checkSalary("Enter raise amount");
                Date date1 = validate.checkDate("Enter date raise salary");
                currentSalary += up;
                wl.add(new Worker(worker.getCode(), worker.getName(),
                        worker.getAge(), currentSalary, worker.getWorkLocation(),
                        "UP", date1));
                break;
            case 2:
                double down = validate.checkSalary("Enter reduce amount");
                if (down > currentSalary) {
                    return false;
                }
                Date date2 = validate.checkDate("Enter date reduce salary");
                currentSalary -= down;
                wl.add(new Worker(worker.getCode(), worker.getName(),
                        worker.getAge(), currentSalary, worker.getWorkLocation(),
                        "DOWN", date2));
                break;
        }
        return true;
    }

    public void view(List<Worker> wl) {
        Collections.sort(wl, new Sorting());
        System.out.printf("%-7s%-15s%-7s%-15s%-15s%-10s%s\n", "Code", "Name",
                "Age", "Salary", "Work Location", "Status", "Date");
        for (Worker worker : wl) {
            System.out.println(worker);
        }
    }

    public Worker findByCode(List<Worker> wl, String code) {
        for (Worker worker : wl) {
            if (code.equals(worker.getCode())) {
                return worker;
            }
        }
        return null;
    }
}
