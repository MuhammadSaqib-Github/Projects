package com.files;

public class Static {
    public static void main(String[] args) {
        dummy d1 = new dummy();
        dummy d2 = new dummy();

        dummy d3 = new dummy();
        dummy d4 = new dummy();

        System.out.println(d1.a + " < a while d2 a > " + d2.a);

        d1.b = 50;
        d1.a = 90;

        System.out.println( "a>>" + d2.a + " b>> " + d2.b); //

        d2.b = 5000;

        System.out.println(d4.b);

        d4.b = 248885;

    }
}

class dummy{
    int a;//0
    static int b;
}
