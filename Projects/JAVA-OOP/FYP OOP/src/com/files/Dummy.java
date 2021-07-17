package com.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dummy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your First Name and registration number: ");
        String userInput = scanner.next();

        String[] raggedArray = userInput.split("-");
        String s="";
        String S[] = new String[10];
        int index = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '-')
            {
                S[index] = s;
                index++;
                s="";
            }
        }

        System.out.println("Writing data into the output.txt file.");
        try {
            writeToFile(raggedArray, "text.txt");
        } catch (IOException e) {
            System.err.println("Some exceptions occured while creating/opening/writing the file:");
            e.printStackTrace();
        }
        System.out.println("Sucessfully written data into the output.txt file.");
        scanner.close();

    }
    public static void writeToFile(String[] data, String FileName) throws IOException {

        File file = new File(FileName);
        FileWriter fr = new FileWriter(file);
        for (String datum : data) {
            fr.write(datum+"\n");
        }
        fr.close();
    }


}
