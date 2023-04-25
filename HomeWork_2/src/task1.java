/*
*   В файле содержится строка с исходными данными в такой форме:
    {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
    SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
    Для разбора строки используйте String.split.
*   Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args){
        String data = stringFromFile();
        System.out.println( stringResult(data));
    }

    private static String stringFromFile() {

        StringBuilder sb = new StringBuilder("");
        File file = new File("text1.json");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }

            scanner.close();

            return sb.toString().replaceAll(" ", "").replaceAll("\\{", "").replaceAll("\\}", "");

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return "Файл не найден";
        }
    }

    private static String stringResult(String data) {
        String[] items = data.split(",");
        StringBuilder sb = new StringBuilder("SELECT * FROM students WHERE ");
        if (data != "Файл не найден") {

            for (int i = 0; i < items.length; i++) {
                String[] itemInfo = items[i].split(":");

                if (!itemInfo[1].contains("null")) {
                    sb.append(itemInfo[0].replaceAll("\"", "") + " = " + itemInfo[1] + " AND ");
                }
            }

            return sb.toString().substring(0, sb.toString().length() - 5);
        }
        return sb.toString();

    }

}
