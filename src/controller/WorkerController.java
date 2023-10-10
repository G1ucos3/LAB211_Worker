package controller;

import model.Worker;
import repository.WorkerRepository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class WorkerController extends Menu<Worker> {

    static String[] mc = {"Add Worker", "Up salary", "Down salary",
        "Display Information Salary", "Exit"};
    Worker w;
    WorkerRepository wr;

    public WorkerController() {
        super("Worker Management", mc);
        w = new Worker();
        wr = new WorkerRepository();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.println("--------- Add Worker ----------");
                wr.addWorker(w.getWl(), new Worker());
                break;
            case 2:
                System.out.println("------- Up Salary --------");
                wr.changeSalary(w.getWl(), new Worker(), 1);
                break;
            case 3:
                System.out.println("------- Down Salary --------");
                wr.changeSalary(w.getWl(), new Worker(), 2);
                break;
            case 4:
                System.out.println("--------------------Display Information Salary-----------------------");
                wr.view(w.getWl());
                break;
            case 5:
                System.out.println("Closed..");
                System.exit(0);
            default:
                System.out.println("Choose again.");
        }
    }

}
