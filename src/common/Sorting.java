package common;

import java.util.Comparator;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class Sorting implements Comparator<Worker> {

    @Override
    public int compare(Worker w1, Worker w2) {
        int codeCompare = w1.getCode().compareTo(w2.getCode());
        if (codeCompare != 0) {
            return codeCompare;
        } else {
            return w1.getDate().compareTo(w2.getDate());
            
        }
    }

}
