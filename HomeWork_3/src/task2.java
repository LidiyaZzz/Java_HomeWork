/*
 *Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
 */

import java.util.*;

public class task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(i, random.nextInt(99));
        }

        printArray (list);
        removeNums (list);
        printArray (list);
    }

    private static void printArray (List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) System.out.print("[ " + list.get(i) + ", ");
            else if (i == list.size() - 1) System.out.print(list.get(i) + "]\n");
            else System.out.print(list.get(i) + ", ");
        }
    }

    private static void removeNums (List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            };
        }
    }
}
