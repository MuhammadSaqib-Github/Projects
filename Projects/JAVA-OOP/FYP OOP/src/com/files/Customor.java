package com.files;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Customor extends Person implements Serializable {

    ArrayList<Reservation> reservations = new ArrayList<>();
    public Customor(String n, String p, String em) {
        super(n, p, em);
        Read();
    }


    void customorMenu() throws IOException {

        while (true){

            System.out.println("press 1 for Reservation ");
            System.out.println("press 2 to cancel reservation ");

            System.out.println("press 3 to buy somehing ");
            System.out.println("press 4 to view reservation details ");


            int choice = (new Scanner(System.in)).nextInt();

            switch (choice) {

                case 1 -> Add();
                case 2 -> Del();
                case 3 -> SomeThing();
                case 4 -> Show();

            }
        }
    }

    private void SomeThing() throws IOException {
        Admin admin = new Admin();
        admin.readFile();
        admin.Display();

        int price=0;

        System.out.println("Enter product # you want to buy?");
        int i = (new Scanner(System.in)).nextInt();

        if (i>=0 && i<admin.price.size())
                price = price + admin.price.get(i-1);

        System.out.println(" price is : " + price);
    }

    private void Add() throws IOException {
        {
            System.out.println("Enter # of people:- ");
            int peopleCount = (new Scanner(System.in)).nextInt();
            //System.out.println("Are you want to confirm the reservation?:- ");
            boolean reservationStatus = true ;
            Date checkInTime = new Date();
            String input  = "Aftar 2 days.";
            int dayAfter;
            System.out.println("kitnay dino bad booking chahiye hai?");
            dayAfter = ( new Scanner(System.in)).nextInt();
            Calendar c = Calendar.getInstance();
            //c.setTime(new Date());

            c.add(Calendar.DATE, dayAfter);
            Reservation receptionist = new Reservation(peopleCount , reservationStatus , checkInTime ,input , c);
            reservations.add(receptionist);
            writeToFile();
        }
    }

    private void Del() {
        {

            Show();
            System.out.println("Enter # of people:- ");
            int index = (new Scanner(System.in)).nextInt();
            reservations.remove(index-1);

        }
    }

    private void Show() {
        {
            for (int i = 0; i < reservations.size(); i++) {
                System.out.println("Table id :" + (i+1));
                System.out.println(reservations.get(i).toString());
            }
        }
    }

    public void writeToFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (int i = 0; i < reservations.size(); i++) {
            oos.writeObject(reservations.get(i));
        }

        fos.close();
    }

    void Read()  {
        try {
            FileInputStream fileIn = new FileInputStream("file");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            while (true) {
                Reservation a = new Reservation();
                a = (Reservation) objectIn.readObject();
                reservations.add(a);

            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
        }
        System.out.println("??????????????????");

    }




}