/*
Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
...

Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class task2 {
    public static void main(String[] args) {
        Map<String, String> listFullName = new HashMap<>();
        putValues(listFullName);
        System.out.println("Список сотрудников: ");
        System.out.println(listFullName + "\n");

        Map<String, Integer> nameToCount = getPopNames (listFullName);
        System.out.println("Повторяющиеся имена с количеством повторений: ");
        System.out.println(nameToCount + "\n");

        ArrayList<Integer> sortArrayIndexPop = getSortArrayIndexPop (nameToCount);
//        System.out.println(sortArrayIndexPop);
        ArrayList<String> sortArrayNamePop = getSortArrayNamePop (nameToCount, sortArrayIndexPop);
//        System.out.println(sortArrayNamePop);

        System.out.println("Отсортированный список по убыванию популярности имен: ");
        putSortValues (sortArrayNamePop, listFullName);

    }

    private static void putValues (Map<String, String> listFullName) {
        File file = new File("dictTask2.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] fullName = str.split(" ");
                listFullName.put(fullName[1], fullName[0]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
        System.out.println("Файл не найден");
        }
    }

    private static Map<String, Integer> getPopNames (Map<String, String> listFullName) {
        ArrayList<String> arrayNames = new ArrayList<>();

        for (Map.Entry<String, String> pair : listFullName.entrySet()) {
            arrayNames.add(pair.getValue());
        }

        Map<String, Integer> nameToCount = new HashMap<>();
        for (String name : arrayNames)
        {
            if (!nameToCount.containsKey(name)) nameToCount.put(name, 0);
            nameToCount.put(name, nameToCount.get(name) + 1);
        }

        return nameToCount;
    }

    //        Собираем все значения и формируем список уникальных значений поппулярности, сортируем
    private static ArrayList<Integer> getSortArrayIndexPop (Map<String, Integer> listNamesWidthIndexPop) {
        ArrayList<Integer> sortArrayIndexPop = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : listNamesWidthIndexPop.entrySet()) {
            if (!sortArrayIndexPop.contains(pair.getValue())) sortArrayIndexPop.add(pair.getValue());
        }

        Collections.sort(sortArrayIndexPop);
        Collections.reverse(sortArrayIndexPop);
        return sortArrayIndexPop;
    }


    //        Формируем список имен по частоте появления
    private static ArrayList<String> getSortArrayNamePop (Map<String, Integer> listNamesWidthIndexPop, ArrayList<Integer> sortArrayIndexPop) {
        ArrayList<String> sortArrayNamePop = new ArrayList<>();
        for (int i = 0; i < sortArrayIndexPop.size(); i++) {
            for (Map.Entry<String, Integer> pair : listNamesWidthIndexPop.entrySet()) {
                if (pair.getValue().equals(sortArrayIndexPop.get(i))) sortArrayNamePop.add(pair.getKey());
            }
        }
        return sortArrayNamePop;
    }

// Собираем сортированный список, беря из исходной коллекции пары, в которых значение совпадает
//    со списком имен по порядку частоты появления
    private static void putSortValues (ArrayList<String> sortArrayNamePop, Map<String, String> listFullName) {

        ArrayList<String>  sortListFullName = new ArrayList<>();
        for (int i = 0; i < sortArrayNamePop.size(); i++) {
            for (Map.Entry<String, String> pair : listFullName.entrySet()) {
                if (pair.getValue().equals(sortArrayNamePop.get(i))) sortListFullName.add(pair.getKey() + " " + pair.getValue());
            }
        }
        System.out.println(sortListFullName);
    }
}
