/*
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
*/
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int n = in.nextInt();
          
        System.out.printf("Вы ввели: %d \n", n);
        in.close();

        int resultSum = 0;
        for (int i = 1; i <= n; i++) {
            resultSum += i;
        }

        int resultMult = 1;
        for (int i = 1; i <= n; i++) {
            resultMult *= i;
        }

        System.out.printf("Треугольное число: %d; N!: %d \n", resultSum, resultMult);
    }
}
