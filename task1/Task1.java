package org.example.task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        int result = 0;
        int index = 0;

        do {
            result = result * 10 + array[index];
            index = (index + m - 1) % n;
        } while (index != 0);

        System.out.println(result);
    }
}
