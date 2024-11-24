package com.pronchenko.top.hwWorkWithFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Пользователь с клавиатуры вводит путь к файлу и массив целых.
 * Необходимо сохранить исходный массив в первой строке файла,
 * четные значения из массива во второй строке файла, нечетные
 * в третьей, перевернутый массив в четвертой.
 */
public class Task4 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String pathName = scanner.nextLine();
        System.out.println("Введите числа через пробел");
        String[] strings = scanner.nextLine().split(" ");
        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        new Task4().arrayWriter(pathName, array);
        scanner.close();
    }

    private void arrayWriter(String pathName, int[] array) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathName))) {
            bufferedWriter.write(Arrays.toString(array) + "\n");
            bufferedWriter.write(Task4.getEvenArray(array) + "\n");
            bufferedWriter.write(Task4.getOddArray(array) + "\n");
            bufferedWriter.write(String.valueOf(Task4.getReverseArray(array)));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static List<Integer> getEvenArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                list.add(array[i]);
            }
        }
        return list;
    }

    private static List<Integer> getOddArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                list.add(array[i]);
            }
        }
        return list;
    }

    private static List<Integer> getReverseArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            list.add(array[i]);
        }
        return list;
    }
}
