/*
    Вывести все простые числа от 1 до 1000
*/
import java.util.Scanner;

public class task2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int n = getInt();        
        System.out.printf("все простые числа от 1 до %d: ", n);
        printPrimeNumbers(n);
    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }
    

    public static void printPrimeNumbers(int num) {
        
        for (int i = 1; i <= num; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++){                
                if ((i % j) == 0) { 
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(i + " ");
            }
        }
    }
}
