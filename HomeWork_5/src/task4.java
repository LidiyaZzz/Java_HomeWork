/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

import java.util.Arrays;

public class task4 {

    public static void main(String[] args)
    {

        int[][] mat = new int[8][8];

        for (int i = 0; i < 8; i++) {
            Arrays.fill(mat[i], 0);
        }
        nQueen(mat, 0);
    }
    private static boolean isSafe(int[][] mat, int r, int c)
    {
        // возвращаем false, если два ферзя делят один и тот же столбец
        for (int i = 0; i < r; i++)
        {
            if (mat[i][c] == 1) {
                return false;
            }
        }

        // вернуть false, если два ферзя делят одну и ту же диагональ
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
            if (mat[i][j] == 1) {
                return false;
            }
        }

        // вернуть false, если два ферзя делят одну и ту же диагональ
        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++)
        {
            if (mat[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printSolution(int[][] mat)
    {
        for (int[] value: mat) {
            System.out.println(Arrays.toString(value));
        }
        System.out.println();
    }

    private static void nQueen(int[][] mat, int r)
    {
        // если ферзи расставлены успешно, выводим решение
        if (r == mat.length)
        {
            printSolution(mat);
            return;
        }

        // помещаем ферзя на каждую клетку в текущем ряду `r`
        // и повторяться для каждого допустимого движения
        for (int i = 0; i < mat.length; i++)
        {
            // если никакие два ферзя не угрожают друг другу
            if (isSafe(mat, r, i))
            {
                // ставим ферзя на текущую клетку
                mat[r][i] = 1;

                // повторить для следующей строки
                nQueen(mat, r + 1);

                // возвращаемся назад и удаляем ферзя с текущей клетки
                mat[r][i] = 0;
            }
        }
    }
}
