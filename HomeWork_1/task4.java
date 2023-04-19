/*
 * Задано уравнение вида q + w = e, q, w, e >= 0. 
 * Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет. * 
 * 
 * Решено из расчета, что слагаемые - двузначные целые положительные числа
 * Супернеоптимизированное решение, но как смогла))
 */
import java.util.Scanner;

public class task4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sum = getSum("Введите конечную сумму:");
        String value1 = getArray("Введите первое двузначное число, некоторые цифры можно заменить знаком вопроса: ");
        String value2 = getArray("Введите второе двузначное число, некоторые цифры можно заменить знаком вопроса: ");

        // System.out.println(value1);
        res (value1, value2, sum);
    }

    // Получаем сумму 
    public static int getSum(String message){
        System.out.println(message);
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getSum(message);
        }
        return num;
    }

    // Получаем строку из 2х символов: цифры или ?    
    public static String getArray(String message){
        System.out.println(message);
        String num = scanner.next();

        if (num.length() > 2 || num.length() < 2) {
            num = getArray("Вы ввели некорректное значение, введите двузначное число, цифры можно заменить знаком вопроса");
        } 
        else if (num.length() == 2) {
            for(int i = 0; i < num.length(); i++) {
                if(Character.isDigit(num.charAt(i)) || num.charAt(i) == '?') {
                    return num;
                } else {
                    num = getArray("Вы ввели некорректное значение, введите двузначное число, цифры можно заменить знаком вопроса");
                }
                
            }
        }        
        return num;
    }

    public static void res (String value1, String value2, int sum) {
        int num1;
        int num2;
        int ten1;
        int ten2;
        int unit1;
        int unit2;
        Boolean isQuesTen1 = false;
        Boolean isQuesTen2 = false;
        Boolean isQuesUnit1 = false;
        Boolean isQuesUnit2 = false;
        Boolean result = true;

        // Проверяем десятки и устанавливаем флаги для вопросиков в десятках        
        if (value1.charAt(0) == '?') {
            ten1 = 0;
            isQuesTen1 = true;
        } else {
            ten1 = Character.digit(value1.charAt(0), 10);
        }
        if (value2.charAt(0) == '?') {
            ten2 = 0;
            isQuesTen2 = true;
        } else {
            ten2 = Character.digit(value2.charAt(0), 10);
        }

        if (ten1 + ten2 > sum / 10) {
            result = false;

        } else {

            // Проверяем единицы и устанавливаем флаги для вопросиков в единицах   
            if (value1.charAt(1) == '?') {
                unit1 = 0;
                isQuesUnit1 = true;
            } else {
                unit1 = Character.digit(value1.charAt(1), 10);
            }
            if (value2.charAt(1) == '?') {
                unit2 = 0;
                isQuesUnit2 = true;
            } else {
                unit2 = Character.digit(value2.charAt(1), 10);
            }


            // Ищем решения при неизвестных десятках
            // ?- ?-
            if (isQuesTen1 && isQuesTen2) { 
                // ?- ?-               
                if (isQuesUnit1 && isQuesUnit2) {
                    // ?? ??
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 10; k++) {
                                for (int n = 0; n < 10; n++) {                                     
                                    if ((i * 10 + j) + (k * 10 + n) == sum) {
                                        System.out.printf("%d + %d = %d; ", (i * 10 + j), (k * 10 + n), sum);
                                        result = true;
                                    }
                                }
                            }
                        }
                    }
                    //                     
                } else if (isQuesUnit1 && !isQuesUnit2) {
                    // ?? ?1
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 10; k++) {                                
                                if ((i * 10 + j) + (k * 10 + unit2) == sum) {
                                    System.out.printf("%d + %d = %d; ", (i * 10 + j), (k * 10 + unit2), sum);
                                    result = false;
                                }                                
                            }
                        }
                    }
                    // 
                } else if (!isQuesUnit1 && isQuesUnit2) {
                    // ?1 ??
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 10; k++) {                                
                                if ((i * 10 + unit1) + (j * 10 + k) == sum) {
                                    System.out.printf("%d + %d = %d; ", (i * 10 + unit1), (j * 10 + k), sum);
                                    result = false;
                                }                                
                            }
                        }
                    }
                    // 
                } else if (!isQuesUnit1 && !isQuesUnit2) {
                    // ?1 ?1
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {                            
                            if ((i * 10 + unit1) + (j * 10 + unit2) == sum) {
                                System.out.printf("%d + %d = %d; ", (i * 10 + unit1), (j * 10 + unit2), sum);
                                result = false;
                            }  
                        }
                    }
                    // 
                }
            } 
            // при неизвестном десятке 1 числа
            // ?- --
            else if (isQuesTen1 && !isQuesTen2) {
                
                if (!isQuesUnit1 && !isQuesUnit2) {
                    // ?1 11
                    for (int i = 0; i < 10; i++) {                                  
                        if ((i * 10 + unit1) + (ten2 * 10 + unit2) == sum) {
                            System.out.printf("%d + %d = %d; ", (i * 10 + unit1), (ten2 * 10 + unit2), sum);
                            result = false;                                
                        }
                    }
                    // 
                } else if (isQuesUnit1 && !isQuesUnit2) {
                    // ?? 11
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {                            
                            if ((i * 10 + j) + (ten2 * 10 + unit2) == sum) {
                                System.out.printf("%d + %d = %d; ", (i * 10 + j), (ten2 * 10 + unit2), sum);
                                result = false;
                            }  
                        }
                    }
                    //  
                }
            }
            // при неизвестном десятке 2 числа
            // -- ?- 
            else if (!isQuesTen1 && isQuesTen2) {
                if (!isQuesUnit1 && isQuesUnit2) {
                    // 11 ??
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {                            
                            if ((ten1 * 10 + unit1) + (i * 10 + j) == sum) {
                                System.out.printf("%d + %d = %d; ", (ten1 * 10 + unit1), (i * 10 + j), sum);
                                result = false;
                            }  
                        }
                    }
                    // 
                } else if (isQuesUnit1 && isQuesUnit2) {
                    // 1? ??
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 10; k++) {                                
                                if ((ten1 * 10 + i) + (j * 10 + k) == sum) {
                                    System.out.printf("%d + %d = %d; ", (ten1 * 10 + i), (j * 10 + k), sum);
                                    result = false;
                                }                                
                            }
                        }
                    }
                    // 
                }
            }
            // при известных десятках
            // -- -- 
            else if (!isQuesTen1 && !isQuesTen2) {
                if (!isQuesUnit1 && isQuesUnit2) {
                    // 11 1?
                    for (int i = 0; i < 10; i++) {                                  
                        if ((ten1 * 10 + unit1) + (ten2 * 10 + i) == sum) {
                            System.out.printf("%d + %d = %d; ", (ten1 * 10 + unit1), (ten2 * 10 + i), sum);
                            result = false;                                
                        }
                    }
                    // 
                } else if (isQuesUnit1 && isQuesUnit2) {
                    // 1? 1?
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {                            
                            if ((ten1 * 10 + i) + (ten2 * 10 + j) == sum) {
                                System.out.printf("%d + %d = %d; ", (ten1 * 10 + i), (ten2 * 10 + j), sum);
                                result = false;
                            }  
                        }
                    }
                    // 
                }
            }
            
        }

        if (result) {
            System.out.println("Решения нет");
        }
    }
    
    /*java task4.java*/   
    
}
