// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

package java_projects.java_seminar_2;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class hometask1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива чисел: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        System.out.print("Созданный нами массив чисел :");
        System.out.print(" " + array[0]);
        for (int i = 1; i < size; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println();
        input.close();
        puzirek(array);
    }

    public static void puzirek(int[] m) {
        String file_name = "D:/TEST/java_projects/java_seminar_2/hometask1.txt";
        File file = new File(file_name);
        boolean isSorted = false;
        int buf;
        int count = 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < m.length - 1; i++) {
                if (m[i] > m[i + 1]) {
                    isSorted = false;
                    buf = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = buf;
                    try {
                        FileWriter writer = new FileWriter(file, true);
                        writer.write("Промежуточная итерация № " + count);
                        count++;
                        writer.write("\n");
                        writer.write(Arrays.toString(m));
                        writer.write("\n");
                        writer.write("\n");
                        writer.close();
                        System.out.println("Запись итерации в файл произведена успешно!");
                    } catch (Exception e) {
                        System.out.println("При записи в файл что-то пошло не так!");
                    }
                }
            }
        }
        System.out.print("Отсортированный массив : ");
        System.out.println(Arrays.toString(m));
    }
}
