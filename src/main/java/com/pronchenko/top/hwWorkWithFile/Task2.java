package com.pronchenko.top.hwWorkWithFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Пользователь с клавиатуры вводит путь к файлу.
 * Программа должна найти длину самой длинной строки.
 * После работы программы на экран отображается
 * полученное число и сама строка.
 */
public class Task2 {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String pathName = scanner.nextLine();
        new Task2().longestString(pathName);
        scanner.close();
    }
    private void longestString(String pathName){
    try (BufferedReader reader = new BufferedReader(new FileReader(pathName))){
        String string = "";
        String longString = "";
        int length = 0;
        while ((string = reader.readLine())!=null){
            if (string.length()>length){
                length = string.length();
                longString = string;
            }
        }
        System.out.println(length +"\n" +longString);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}
