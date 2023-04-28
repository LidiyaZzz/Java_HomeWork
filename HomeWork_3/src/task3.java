/*
 *Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(i, random.nextInt(99));
        }

        printArray (list);
        Collections.sort(list);
        printArray (list);

        System.out.printf("Минимальное значение: %d \n", list.get(0));
        System.out.printf("Максимальное значение: %d \n", list.get(list.size()-1));
        System.out.printf("Среднее арифметичское: %.2f \n", averageOfArray(list));

    }

    private static void printArray (List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) System.out.print("[ " + list.get(i) + ", ");
            else if (i == list.size() - 1) System.out.print(list.get(i) + "]\n");
            else System.out.print(list.get(i) + ", ");
        }
    }

    private static double averageOfArray (List<Integer> list) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += (double) list.get(i);
        }
        return result /= list.size();
    }
}
