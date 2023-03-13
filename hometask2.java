/*
 * Дана строка (получение через обычный текстовый файл!!!)
 * 
 * "фамилия":"Иванов","оценка":"5","предмет":"Математика"
 * "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
 * 
 * Написать метод(ы), который распарсит строку и, используя StringBuilder,
 * создаст строки вида:
 * Студент [фамилия] получил [оценка] по предмету [предмет].
 * 
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */

package java_projects.java_seminar_2;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;

public class hometask2 {
    public static void main(String[] args) throws Exception {
        String file_name = "D:/TEST/java_projects/java_seminar_2/hometask2.txt";
        File file = new File(file_name);
        FileReader reader = new FileReader(file);
        LineNumberReader lnr = new LineNumberReader(reader);
        int linesCount = 0;
        while (null != lnr.readLine())
            linesCount++;
        System.out.println("Koличecтвo cтpoк в нашем фaйлe: " + linesCount);
        System.out.println();
        System.out.println("Исходный текст из файла: ");
        System.out.println();
        String line;
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] array = lines.toArray(new String[lines.size()]);
        System.out.println();
        System.out.println("Финальный текст: ");
        System.out.println();

        String[][] finalArray = new String[linesCount][6];
        for (int i = 0; i < linesCount; i++) {
            finalArray[i] = array[i].split(",|:");
        }
        StringBuilder sb = new StringBuilder(500);
        for (int i = 0; i < linesCount; i++) {
            sb.append("Студент ").append(finalArray[i][1]).append(" получил ").append(finalArray[i][3])
                    .append(" по предмету ").append(finalArray[i][5]).append("\n").toString();
        }
        System.out.println(sb);
        System.out.println();
    }
}