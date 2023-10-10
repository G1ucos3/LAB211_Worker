package repository;

import java.util.List;
import model.Worker;

/**
 *
 * @author ASUS
 */
public interface IWorker {

    void addWorker(List<Worker> wl, Worker worker);

    void changeSalary(List<Worker> wl, Worker worker, int type);

    void view(List<Worker> wl);
    
}
