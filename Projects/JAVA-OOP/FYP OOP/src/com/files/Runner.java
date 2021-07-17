package com.files;


public class Runner {
    public static void main(String[] args) {

        CinemaHall h_array1 = new CinemaHall();
        CinemaHall h_array2 = new CinemaHall();
        CinemaHall h_array3 = new CinemaHall("Movie1");
        CinemaHall h_array4 = new CinemaHall(h_array1);          
        CinemaHall h_array5 = new CinemaHall(h_array2);

        h_array1.bookAseat();
        h_array2.bookAseat();
        h_array2.bookAseat();
        h_array3.bookAseat();
        h_array3.bookAseat();
        h_array3.bookAseat();

        CinemaHall temp = h_array1.ComparetotalSeatsBooked(h_array3);


        if (temp!=null)
            temp.display();     // display  "Movie name = Movie1, Earning = Rs. 200.0"
        else                           // null means number of seats is equal
            System.out.println("Equal seats in both halls");

         boolean found = h_array2.checkMovie("SomeMovieName");


            System.out.println("Earning of hall is " + h_array1.getEarning());

    }
}

class CinemaHall {

    private boolean[] seats = new boolean[50];
    private double earning;
    private String movieName;

    CinemaHall() {

    }

    public CinemaHall(String str) {
        this.movieName = str;
    }

    public CinemaHall(CinemaHall cinemaHall) {
        this.movieName = cinemaHall.movieName;
        this.earning = cinemaHall.earning;
        this.seats = cinemaHall.seats;
    }

    public void bookAseat() {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == false) {
                seats[i] = true;
                earning = earning + 100;
                break;
            } else
                continue;
        }


    }

    public CinemaHall ComparetotalSeatsBooked(CinemaHall h_array3) {
        int s1 = 0, s2 = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == true) {
                s1++;
            }
        }

        for (int i = 0; i < h_array3.seats.length; i++) {
            if (h_array3.seats[i] == true) {
                s2++;
            }
        }

        if (s2 > s1) {
            return h_array3;
        } else if (s1 > s2) {
            return this;
        } else
            return null;
    }

    public void display() {
        System.out.println("movie name " + movieName);
        System.out.println("Booked seats: " + seats.length);
    }

    public boolean checkMovie(String someMovieName) {
        if (someMovieName.equals(this.movieName))
        {
            return true;
        }
        else
            return false;
    }

    public double getEarning() {
        return earning;
    }
}