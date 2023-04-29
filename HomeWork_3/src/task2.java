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

        System.out.println(list);
        removeNums (list);
        System.out.println(list);
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
