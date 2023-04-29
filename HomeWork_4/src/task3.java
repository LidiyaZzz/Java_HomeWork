/*
 * Напишите постфиксный калькулятор.
 * Пользователь вводит данные и операции в обратной польской записи.
 * Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;

public class task3 {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Введите выражение в обратной польской записи: ");
        String str = scanner.nextLine();

        try {
          culculater (str);

        } catch (EmptyStackException ex) {
            System.out.println("Что-то пошло не так");
        }
    }

    private static void culculater (String str) {
        String[] strings = str.split(" ");
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < strings.length; i++) {
            if (isNumber(strings[i])) {
                stack.push(Double.parseDouble(strings[i]));
            } else {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();

                switch (strings[i]) {
                    case "+":
                        stack.push(tmp1 + tmp2);
                        break;
                    case "-":
                        stack.push(tmp2 - tmp1);
                        break;
                    case "*":
                        stack.push(tmp1 * tmp2);
                        break;
                    case "/":
                        if (tmp1 == 0) break;
                        stack.push(tmp2 / tmp1);
                        break;
                }
            }
        }

        if (!stack.empty()) {
            System.out.println(stack.pop());
        } else  {
            System.out.println("Ошибка");
        }
    }

    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
