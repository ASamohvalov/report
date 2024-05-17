package org.example.task1;

public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

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
