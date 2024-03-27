package aula05;


public class DateYMD {
    private int year;
    private int month;
    private int day;

    public DateYMD(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public boolean validMonth(int month){
        if ( 1 <= month && month <= 12){return true;}
        else { return false;}
        }

    public static boolean leapYear(int year){
        if (year % 4 != 0) {
            return false;

        } 
        else if (year % 400 == 0) {
            return true;
        }
        
        else if (year % 100 == 0) {
            return false;
        } 
        else {
            return true;
        }
    }

    public static int monthDays(int month, int year){
        int monthDays;
        if (month == 2){
            if (leapYear(year)){
                monthDays = 29;
            }
            else{
                monthDays = 28;
            }
        }
        else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8|| month == 10 || month ==12){
            monthDays = 31;
        }
        else{
            monthDays = 30;
        }

    return monthDays;
    }

    public boolean validDate(){
        if (day <= monthDays(month, year) && validMonth(month)){ //checkar ano?
            return true;
        }
        else { return false; }
    }

    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public void incrementDate(){
        if (day == monthDays(month, year)){
            if (month == 12){
                day = 0;
                month = 1;
                year++;
            }
            else{
                day = 1;
                month++;
            }
        }
        else{
            day++;
        }
    }

    public void decrementDate(){
        if (day == 1){
            if (month == 1){
                month = 12;
                year--;
                day = monthDays(month, year);
            }
            else{
                month--;
                day = monthDays(month, year);
            }
        }
        else{
            day--;
        }
    }

    public boolean equals(DateYMD d0){
        return year == d0.getYear() && month == d0.getMonth() && day == d0.getDay();
    }

    @Override
    public String toString() {
        return String.format("Current date: %04d %02d %02d ",year, month, day);
    }
}