package org.example.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            List<Integer> circle = new ArrayList<>();
            while (scanner.hasNext()) {
                circle.add(scanner.nextInt());
            }

            Scanner scanner1 = new Scanner(new File(args[1]));
            List<Integer> points = new ArrayList<>();
            while (scanner1.hasNext()) {
                points.add(scanner1.nextInt());
            }

            List<Integer> result = calculatePosition(circle.get(0), circle.get(1), circle.get(2), points);
            for (int i : result) {
                System.out.println(i);
            }

            scanner.close();
            scanner1.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Integer> calculatePosition(int centerX, int centerY, int radius, List<Integer> points) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < points.size(); i += 2) {
            int distance = (int) Math.sqrt(Math.pow(points.get(i) - centerX, 2) + (Math.pow(points.get(i + 1) - centerY, 2)));
            if (distance == radius) {
                result.add(0);
            } else if (distance < radius) {
                result.add(1);
            } else {
                result.add(2);
            }
        }

        return result;
    }
}

