
/*
    Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
    Разность:
    A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
    B - A = все числа из второй коллекции, которые не содержатся в первой
    Симметрическая разность:
    A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        createValue (list1);
        createValue (list2);

        List<Integer> listANotB = new ArrayList<Integer>();
        subtrList (list1, list2,  listANotB);

        List<Integer> listBNotA = new ArrayList<Integer>();
        subtrList (list2, list1,  listBNotA);

        List<Integer> listABNotRepeat = new ArrayList<Integer>();
        symmetricDifference (listANotB, listBNotA, listABNotRepeat);

        System.out.println("Множество A: " + list1);
        System.out.println("Множество B: " + list2);
        System.out.println("Все числа из коллекции A, которые не содержатся в коллекции B: " + listANotB);
        System.out.println("Все числа из коллекции B, которые не содержатся в коллекции A: " + listBNotA);
        System.out.println("Симметрическая разность множеств A и B: " + listABNotRepeat);

    }

    private static void createValue (List<Integer> list) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(i, random.nextInt(15));
        }
    }

    private static List<Integer> subtrList (List<Integer> list1, List<Integer> list2, List<Integer> listRes) {

        for (int i = 0; i < list1.size(); i++) {
            listRes.add(list1.get(i));
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) == list2.get(j)) {
                    listRes.remove(list1.get(i));
                }
            }
        }
        return listRes;
    }

    private static List<Integer> symmetricDifference (List<Integer> listDiff1, List<Integer> listDiff2, List<Integer> listRes) {

        for (int item : listDiff1) {
            listRes.add(item);
        }
        for (int item : listDiff2) {
            listRes.add(item);
        }

        return listRes;
    }
}
