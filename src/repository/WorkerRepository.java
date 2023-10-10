package repository;

import DataAccess.WorkerDao;
import java.util.List;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class WorkerRepository implements IWorker {
    
    @Override
    public void addWorker(List<Worker> wl, Worker worker) {
        if (!WorkerDao.Instance().addWorker(wl, worker)) {
            System.out.println("Code exist.");
        } else {
            System.out.println("Add success.");
        }
    }
    
    @Override
    public void changeSalary(List<Worker> wl, Worker worker, int type) {
        if (wl.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        if (!WorkerDao.Instance().changeSalary(wl, worker, type)) {
            System.out.println("Code not exist or Reduce more than current salary");
        } else {
            System.out.println("Change salary succes.");
        }
    }
    
    @Override
    public void view(List<Worker> wl) {
        if (wl.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        WorkerDao.Instance().view(wl);
    }
}
