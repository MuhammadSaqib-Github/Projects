package com.files;

public class Composition {
    public static void main(String[] args) {

        Date bd = new Date(5,21,1999);

        Date hd = new Date(9,11,2011);

        employe employe1 = new employe("maheer" , "ahmed" ,bd ,hd);

        employe1.Display();
        bd.display();
        hd.display();

    }


}



class Date
{
    private int day;
    private int month;
    private int year;

    public Date (int theMonth, int theDay, int theYear )
    {

        month=checkmonth(theMonth);
        day= checkday(theDay);
        year=theYear;
    }
    private int checkmonth (int testMonth)
    {
        if (testMonth>0 &&testMonth<=12)
            return testMonth;
else
        {
            System.out.println("Invalid month" + testMonth + "set to 1");
            return 1;
        }
    }
    private int checkday(int testDay)
{
    int daysofmonth[]={0,31,28,31,30,31,30,31,31,30,31,30,31};

    if (testDay>0 &&testDay<=daysofmonth[month])
        return testDay;
    else
    if (month==2 &&testDay==29 && (year%400==0 || (year%4==0 && year%100 !=0)))
        return testDay;
    else
        System.out.println("Invalid date"+ testDay + "set to 1");
    return 1;
}

    public int getDay()
{
    return day;
}
    public int getMonth()
{
    return month;
}
    public int getYear()
{
    return year;
}
    public void display()
    {
        System.out.println(day +" "+ month+" " + year);
    }
}

class employe{

    String name;
    String fname;

    Date birthdate;
    Date hiredate;

    employe(String x, String y, Date birthofDate, Date dateofHire)
    {
        name=x;
        fname=y;
        birthdate=birthofDate;
        hiredate=dateofHire;

    }

    public void setname(String x)
    {
        name=x;
    }
    public String getname()
    {
        return name;

    }
    public void setfname(String x)
    {
        fname=x;
    }
    public String getfname()
    {
        return fname;
    }


    public void setbirthdate(Date b)
    {
        birthdate= b;

    }
    public Date getbirthdate()
    {
        return birthdate;

    }
    public void sethiredate(Date h)
    {
        hiredate = h;
    }
    public Date gethiredate()
    {
        return hiredate;
    }

    public void Display(){
        System.out.println("Name:- " + name + " SurName:- " + fname);
    }
}
