/*
 * Реализовать простой калькулятор
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class task3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task3.class.getName());
        FileHandler fh = new FileHandler("log2.xml");

        logger.addHandler(fh);

        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        int num1 = getInt();
        char operation = getOperation();
        int num2 = getInt();
        double result = calc(num1, num2, operation);

        if (operation == '/' && num2 == 0) {
            System.out.printf("На ноль делить нельзя! \n");
            logger.info("Попытка поделить на ноль: " + num1 + operation + num2);
        } else if (result % 1 == 0) {
            System.out.printf("Результат операции: %d \n", (int)result);
            logger.info("Операция осуществлена успешно: " + num1 + operation + num2 + " = " + (int)result);
        } else {
            System.out.printf("Результат операции: %f \n", result);
            logger.info("Операция осуществлена успешно: " + num1 + operation + num2 + " = " + result);
        }
    }


    public static int getInt(){
        System.out.println("Введите целое число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(int num1, int num2, char operation){
        double result;
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = (double) num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}