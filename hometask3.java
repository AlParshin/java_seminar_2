// Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение). Без встр. функций

package java_projects.java_seminar_2;

import java.util.Scanner;

public class hometask3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String stroka = input.next();
        input.close();
        System.out.print(palindrom(stroka));
    }

    public static boolean palindrom(String s) {
        boolean isPalin = true;
        for (int i = 0; i < (s.length() / 2); i++)
            if (s.charAt(i) == s.charAt(s.length() - 1 - i))
                isPalin = true;
            else {
                isPalin = false;
                break;
            }
        return isPalin;
    }
}