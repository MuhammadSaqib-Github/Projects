package com.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String data = scanner.nextLine();
        String[] modifiedArray = data.split("-");
        AddtoFile(modifiedArray);

    }


    public static void AddtoFile(String[] s) throws FileNotFoundException {

        File f = new File("text.txt");
       PrintWriter p = new PrintWriter(f);
        for (int i = 0; i < s.length; i++) {
            if (i==0)
            p.println(s[i] + " ");
            else
                p.print(s[i] + " ");
        }
        p.close();
    }
}



