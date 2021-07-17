package com.files;

public class Objects {
    public static void main(String[] args) {

        C c1 = new C(5);
        C c2 = new C(10);
        C c3 = new C(15);


        C c4 = new C(5);
        C c5 = new C(10);
        C c6 = new C(15);

        C c24 = new C(10);
        C c36 = new C(15);


        c1 = C.Destruct(c1); // null


       System.out.println("No of objects are: " + c1.radius);

    }

}


class C{
    public static int count=0;
     int radius;

    public C() {
        count++;
    }

    public C(int r) {
        this.radius = r;
        count++;
    }

    public C(C obj){
        this.radius = obj.radius;
        count++;
    }
//    public C(C obj){
//        this.radius = obj.radius;
//        System.out.println("---" + this.radius + "------ "+ obj.radius);
//    }

    public static C Destruct( C c) {
        return null;
    }



    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double area(){
        return 3.14*this.radius ;

    }
}
