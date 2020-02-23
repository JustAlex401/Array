package by.plashko.javatr.enter;

import by.plashko.javatr.Exception.UncorrectedDataException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterData {

    public static int[] enterIntArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static int[] enterIntArrayFromRandom() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 200 - 100);
        }
        return arr;
    }

    public static int[] enterIntArrayFromFile() throws UncorrectedDataException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("D:\\EPAM_TASKS\\Day6TaskArrayPlashko\\src\\main\\resources\\Array.txt"));
        } catch (FileNotFoundException e) {
            throw new UncorrectedDataException("File with name 'Array.txt' not found!!!");
        }
        String str = null;
        List<Integer> list = new ArrayList<Integer>();
        while (true) {
            try {
                if (((str = reader.readLine()) == null)) break;
            } catch (IOException e) {
                throw new UncorrectedDataException("Uncorrected data from file!!!");
            }
            if (!str.isEmpty()) {
                try {
                    list.add(Integer.valueOf(str));
                } catch (NumberFormatException ex) {
                    throw new UncorrectedDataException("Uncorrected data from file!!!");
                }
            }
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer a : list) {
            arr[i] = a;
            i++;
        }
        return arr;
    }
}

