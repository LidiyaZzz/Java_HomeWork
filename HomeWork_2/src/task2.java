/*
*   Реализуйте алгоритм сортировки пузырьком числового массива,
*   результат после каждой итерации запишите в лог-файл.
*/

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class task2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("log2.xml");

        logger.addHandler(fh);

        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        int [] mas = {11, 3, 14, 16, 7};

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                    logger.info("Произошла смена элементов массива: " + Arrays.toString(mas));
                } else {
                    logger.info("Cмены элементов массива не произошло: " + Arrays.toString(mas));
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}
