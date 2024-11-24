package com.pronchenko.top.hwWorkWithFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Пользователь вводит с клавиатуры пути к двум текстовым файлам.
 * Программа должна проверить совпадают ли их строки.
 * Если нет, то вывести несовпадающую строку из каждого файла.
 */
public class Task1 {
    public static void main(String[] args) {
       run();
    }
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        String pathName1, pathName2;
        System.out.println("Enter file pathname: ");
        pathName1 = scanner.nextLine();
        System.out.println("Enter file pathname: ");
        pathName2 = scanner.nextLine();
        new Task1().matchString(pathName1, pathName2);
        scanner.close();
    }
    private void matchString(String pathName1, String pathName2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(pathName1));
             BufferedReader reader2 = new BufferedReader(new FileReader(pathName2));
        ) {
            String string1 = "";
            String string2 = "";
            while ((string1 = reader1.readLine()) != null && (string2 = reader2.readLine()) != null) {
                if (string1.equals(string2)) {
                } else {
                    System.out.println(string1+"\n"+string2);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

