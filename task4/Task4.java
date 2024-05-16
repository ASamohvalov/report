package org.example.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            List<Integer> array = new ArrayList<>();
            while (scanner.hasNext()) {
                array.add(scanner.nextInt());
            }

            int mid = getMidValue(array);
            int result = 0;
            for (int i : array) {
                result += Math.abs(i - mid);
            }

            System.out.println(result);

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getMidValue(List<Integer> array) {
        List<Integer> arr = sort(array);
        return arr.get(arr.size() / 2);
    }

    private static List<Integer> sort(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            boolean swapped = false;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i) > array.get(j)) {
                    int swap = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, swap);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

        return array;
    }
}
