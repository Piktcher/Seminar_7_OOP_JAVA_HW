package Viewer;
import Controller.Controller;
import Model.Operation;
import Model.OperationsLog;

import static java.lang.System.exit;

public class Viewer {
    Controller controller;
    public Viewer(Controller controller) {
        this.controller = controller;
    }
    public void appViewer() {
        System.out.println("Привет, введите необходимые параметры для расчета: ");
        double firstNumber = Double.NaN;
        while (true) {
            if (Double.isNaN(firstNumber)) {
                System.out.println("Введите первое число: ");
                firstNumber = controller.inputNumber();
            }
            System.out.println("Введите операцию с помощью символов '+, -, *, /': ");
            String operation = controller.inputOperation();
            System.out.println("Введите второе число: ");
            double secondNumber = controller.inputNumber();

            double result;
            switch (operation) {
                case "+" -> {
                    result = controller.sum(firstNumber, secondNumber);
                }
                case "-" -> {
                    result = controller.subtraction(firstNumber, secondNumber);
                }
                case "*" -> {
                    result = controller.multiply(firstNumber, secondNumber);
                }
                case "/" -> {
                    result = controller.divide(firstNumber, secondNumber);
                }
                default -> {
                    System.out.println("Такой операции нет в калькуляторе, попробуйте еще раз!");
                    continue;
                }
            }
            System.out.println("Результат операции: " + result + "\n");
            Operation command = new Operation(firstNumber, operation, secondNumber);
            command.setResult(result);
            controller.addLog(command);

            System.out.println("Продолжаем работать с полученным результатом? " +
                    "Введите Y, если да, " +
                    "N, если нет, " +
                    "log, если хотите посмотреть последовательность вычислений, " +
                    "0, если хотите выйти из приложения");
            boolean flag = false;
            while (!flag) {
                String continuation = controller.inputOperation().toLowerCase();

                switch (continuation) {
                    case "y" -> {
                        firstNumber = controller.getCurrentLog().get(controller.getCurrentLog().size() - 1).getResult();
                        flag = true;
                    }
                    case "n" -> {
                        firstNumber = Double.NaN;
                        flag = true;
                    }
                    case "log" -> {
                        controller.printLog();
                    }
                    case "0" -> {
                        exit(0);
                    }
                    default -> {
                        System.out.println("Введите корректное значение!");
                    }
                }
            }

        }
    }
}
