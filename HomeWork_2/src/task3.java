/*
* В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
* {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
* {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
*
Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        String data = stringFromFile();
        
        if (data != "Файл не найден") {
            System.out.println(Arrays.toString(stringResult(data)));
        }
    }

    private static String stringFromFile() {

        StringBuilder sb = new StringBuilder("");
        File file = new File("text3.txt");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine().replaceAll(" ", ""));
            }

            scanner.close();

            return sb.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\},", "\\}|");

        } catch (FileNotFoundException e) {
            return "Файл не найден";
        }
    }

    private static String[] stringResult(String data) {
        String[] arrayData = data.split("\\|");
        String[] resultArray = new String[arrayData.length];

        for (int i = 0; i < arrayData.length; i++) {
            String str = arrayData[i].substring(1, arrayData[i].length() - 1);
            String[] itemsData = str.split(",");
            StringBuilder sb = new StringBuilder("Студент ");

            for (int j = 0; j < itemsData.length; j++) {

                String[] itemData = itemsData[j].split(":");
                if (j == 0) sb.append(itemData[1].substring(1, itemData[1].length() - 1));
                if (j == 1) sb.append(" получил " + itemData[1].substring(1, itemData[1].length() - 1));
                if (j == 2) sb.append(" по предмету " + itemData[1].substring(1, itemData[1].length() - 1));


            }
            resultArray[i] = sb.toString();
        }
        return resultArray;
    }
}
