import Controller.*;
import Model.OperationsLog;
import Viewer.Viewer;
public class Main {
    public static void main(String[] args) {
        Viewer viewer = new Viewer(new Controller(new ConsoleDataCreator(), new Calculator(), new OperationsLog()));
        viewer.appViewer();
    }
}
