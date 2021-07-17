package com.files;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Employee extends Person implements Serializable {
    int employeId;
    Date dateJoined;

    ArrayList<Integer> arrayList = new ArrayList<>();

    public Employee(String name, String pN, String mail, int i, Date date) {
        super(name,pN,mail);
        employeId = alotTable();
        dateJoined = date;
    }

    @Override
    public String toString() {
        return  super.toString() + "Employee{" +
                "employeId=" + employeId +
                ", dateJoined=" + dateJoined +
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


