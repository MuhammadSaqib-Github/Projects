package com.files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    ArrayList<Customor> customors = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        while (true) {
            int choice = 3;

            System.out.println("Enter choice: " +
                    "\n1-> Admin" +
                    "\n2-Customer" +
                    "\n3-Exit");

            while (true) {
                try {
                    choice = (new Scanner(System.in)).nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("INVALID _ TRYAGAIN");
                }
            }

            switch (choice) {
                case 1:
                    Admin admin = new Admin();
                    admin.adminMainMenu();
                    break;
                case 2:

                    System.out.println("Enter name : ");
                    String name = (new Scanner(System.in)).nextLine();
                    System.out.println("Enter phone#: ");
                    String pN = (new Scanner(System.in)).nextLine();
                    System.out.println("Enter mail: ");
                    String m = (new Scanner(System.in)).nextLine();
                    Customor customor = new Customor(name, pN, m);
                    customor.customorMenu();

                    break;

                case 3:
                    System.exit(1);

            }
        }
    }
}