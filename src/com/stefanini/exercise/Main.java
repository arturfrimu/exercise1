package com.stefanini.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int birthdayCakeCandles(int[] arr) {
        int maxValue = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxValue) {
                count++;
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
                count = 1;
            }
        }
        return count;
    }

    public static int[] getArray(String filename) throws FileNotFoundException {
        int[] arr;
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        String arrLength = myReader.nextLine();
        arr = new int[Integer.parseInt(arrLength)];
        String arrValues = myReader.nextLine();
        String[] arrOfStr = arrValues.split(" ");
        for (int i = 0; i < arrOfStr.length; i++) {
            arr[i] = Integer.parseInt(arrOfStr[i]);
        }
        myReader.close();
        return arr;
    }

    public static void writeResult(int tallestCount, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(String.valueOf(tallestCount).getBytes());
        fos.close();
    }

    public static void main(String[] args) {
        try {
            int result1 = birthdayCakeCandles(getArray("test1.txt"));
            int result2 = birthdayCakeCandles(getArray("test2.txt"));
            int result3 = birthdayCakeCandles(getArray("test3.txt"));

            writeResult(result1, "test1result.txt");
            writeResult(result2, "test2result.txt");
            writeResult(result3, "test3result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
