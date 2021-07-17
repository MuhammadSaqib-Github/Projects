package com.files;

public class object {
    public static void main(String[] args) {
        
    }
}

class Complex {

        private double real;
        private double imag;


        public Complex()
        {

        }

    public Complex (double real)
    {
        this.real = real;

    }
        public Complex (double real, double im)
        {
            this.real = real;
            this.imag = im;
        }

        public Complex Add (Complex b)
        {

             Complex c_new = new Complex(real + b.real , imag + b.imag);
             return c_new;

        }


        public void show ()
        {
        System.out.println( real + "=====" + imag);
        }

}

class ObjectPass
{
    public int value;

    public  void increment(ObjectPass a)
    {
        a.value++;
    }
}
