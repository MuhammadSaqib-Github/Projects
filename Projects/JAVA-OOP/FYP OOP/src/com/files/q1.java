package com.files;

import java.util.Scanner;

public class q1 {
        public static void rev(char[]ch, int l)
        {
            if (l>0)
            {
                System.out.print(ch[l-1]);
                l--;
                rev(ch,l);
            }
        }
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string");
            String str = scanner.nextLine();

            char[] ch  = new char[str.length()];

            for (int i = 0; i < str.length(); i++) {
                ch[i] = str.charAt(i);
            }

            rev(ch, ch.length);
        }
}