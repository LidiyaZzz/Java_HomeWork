/*
* Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
* PS: рассмотренн вариант, когда исходный LinkedList - строковый
*/

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class task1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        fillLinkedList (linkedList);

        System.out.print("Исходный список: ");
        System.out.println(linkedList);
        System.out.print("“перевернутый” список: ");
        reversLinkedList (linkedList);
    }

/* // Можно так заполнить linkedList:
    private static void fillLinkedList (LinkedList<String> linkedList) {
        String str1 = new String("Hello World!");
        String str2 = new String("My name is Earl");
        String str3 = new String("I love Java");
        String str4 = new String("I live in Moscow");

        linkedList.add(str1);
        linkedList.add(str2);
        linkedList.add(str3);
        linkedList.add(str4);
    }
 */

    private static void fillLinkedList (LinkedList<String> linkedList) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Введите значение: ");
            linkedList.add(scanner.nextLine());
        }
    }

    private static void reversLinkedList (LinkedList<String> linkedList) {
        Stack st = new Stack();

        for (int i = 0; i < linkedList.size(); i++) {
            st.push(linkedList.get(i));
        }

        LinkedList<String> reversList = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++) {
            String a = (String) st.pop();
            reversList.add(a);
        }

        System.out.println(reversList);
    }
}
