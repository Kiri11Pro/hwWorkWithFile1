package com.pronchenko.top.hwWorkWithFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * В файле на разных строках находятся элементы массивов целых.
 * Первая строка содержит элементы первого массива, вторая второго и так далее. Например:
 * 1 23 43 9
 * 6 33 77 88
 * Необходимо загрузить данные из файла в разные массивы, показать каждый массив на экран,
 * показать максимум и минимум в каждом массиве, сумму элементов каждого массива.
 * Также нужно отобразить максимум и минимум среди всех массивов,
 * а также общую сумму всех массивов.
 */
public class Task3 {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String pathName = scanner.nextLine();
        new Task3().arraysParam(pathName);
        scanner.close();
    }
    private void arraysParam(String pathName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathName))) {
            String string = "";
            int maxAll = Integer.MIN_VALUE;
            int minAll = Integer.MAX_VALUE;
            int sumAll = 0;
            int count = 0;
            while ((string = reader.readLine()) != null) {
                count++;
                int[] array = Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println("Массив " + count+" " + Arrays.toString(array));
                int max = Arrays.stream(array).max().orElseThrow(() -> new IllegalArgumentException("Массив пуст"));
                int min = Arrays.stream(array).min().orElseThrow(() -> new IllegalArgumentException("Массив пуст"));
                int sum = Arrays.stream(array).sum();
                System.out.println("Максимальное значения массива " + count + " = " + max);
                System.out.println("Минимальное значения массива " + count + " = " + min);
                System.out.println("Сумма значений массива " + count + " = " + sum);
                if (maxAll < max) {
                    maxAll = max;
                }
                if (minAll > min) {
                    minAll = min;
                }
                sumAll += sum;
            }
            System.out.println("Максимальное значения всех массивов = " + maxAll);
            System.out.println("Минимальное значения всех массивов = " + minAll);
            System.out.println("Сумма элементов всех массивов = " + sumAll);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
