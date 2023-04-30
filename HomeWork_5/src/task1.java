import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Реализуйте структуру телефонной книги с помощью HashMap,
    учитывая, что 1 человек может иметь несколько телефонов.
 */
public class task1 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneToLastName = new HashMap<>();
        phoneToLastName.put("Иванов", new ArrayList(Arrays.asList("123123123", "456456456")));
        phoneToLastName.put("Петров", new ArrayList(Arrays.asList("234234234", "567567567")));
        phoneToLastName.put("Сидоров", new ArrayList(Arrays.asList("345345345")));

        System.out.println(phoneToLastName);

        for (Map.Entry<String, ArrayList<String>> pair : phoneToLastName.entrySet()) {
            if (pair.getKey().equals("Иванов")) {
                System.out.println(pair);
            }
        }
    }
}
