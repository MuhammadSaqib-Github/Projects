package com.files;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Reservation implements Serializable {

    int peopleCount;
    boolean reservationStatus ;
    Date checkInTime;
    String input ;
    Calendar bookingDate;
    int talbeId;

    ArrayList<Integer> arrayList = new ArrayList<>();


        public Reservation(int peopleCount, boolean reservationStatus, Date checkInTime, String input , Calendar c ) {
        this.peopleCount = peopleCount;
        this.reservationStatus=reservationStatus;
        this.checkInTime = checkInTime;
        this.input = input;
        this.bookingDate = c;
        talbeId = alotTable();

    }

    public Reservation() {
    }



    @Override
    public String toString() {
        return "Reservation{" +
                ", talbeId=" + talbeId +
                "peopleCount=" + peopleCount +
                ", reservationStatus=" + reservationStatus +
                ", checkInTime=" + checkInTime +
                ", input='" + input + '\'' +
                ", bookingDate=" + bookingDate.getTime() +
                '}';
    }

    int alotTable(){
        Random random = new Random();
        int i = 0;
        boolean status=true;
        while (status){
             i = random.nextInt(100);
            System.out.println("Size is : " + arrayList.size());
            for (int j = 0; j < arrayList.size(); j++) {

                if (arrayList.get(j)==i){
                    status = true;
                    break;
                }
                else
                    status = false;

                System.out.println(status);

            }

            if (arrayList.size()==0){
                arrayList.add(i);
            }
            if (status==false)
                arrayList.add(i);
        }


        System.out.println(i+" random");
        return i;
    }


}