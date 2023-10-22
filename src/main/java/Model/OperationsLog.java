package Model;

import java.util.ArrayList;
import java.util.List;

public class OperationsLog {
    protected List<Operation> logging;

    public OperationsLog() {
        this.logging = new ArrayList<>();
    }

    public List<Operation> getLogging() {
        return logging;
    }

    @Override
    public String toString() {
        return "Лог операций:\n" + logging + "\n";
    }

    public void addLog(Operation operation) {
        logging.add(operation);
    }

    public void printLog () {logging.toString();}
}
