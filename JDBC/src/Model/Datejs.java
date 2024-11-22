package Model;

public class Datejs {
    private int day;
    private int month;
    private int year;
    private boolean valid;

    public Datejs(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.valid = false;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isValid() {
        testDay();
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", valid=" + valid +
                '}';
    }

    private void testDay() {
        int[] monthdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year > 1700) {
            if (month > 0 && month <= 12) {
                // Verifica si el día es válido para el mes
                if (day > 0 && day <= monthdays[month - 1]) {
                    setValid(true);
                }
            }
        } else {
            System.out.println("Introduce un año superior al 1700");
        }
    }

    public String getDate() {
        String sol;
        if (month < 10) {
            sol = String.format("%s-0%s-%s", String.valueOf(getYear()), String.valueOf(getMonth()), String.valueOf(getDay()));
        } else {
            sol = String.format("%s-%s-%s", String.valueOf(getYear()), String.valueOf(getMonth()), String.valueOf(getDay()));
        }
        return sol;
    }
}