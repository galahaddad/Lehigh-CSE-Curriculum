public class Date {
    int day, month, year;   //data members which are stored

    public Date() {     //default constructors
        day=0; month=0; year=0;
    }

    public Date(int dd, int mm, int yy) {
        this.day=dd;
        this.month=mm;
        this.year=yy;
    }

    //mutators
    public void setD(int dd) {
        day=dd;
    }
    public void setM(int mm) {
        month=mm;
    }
    public void setY(int yy) {
        year=yy;
    }

    //accesors
    public int getD() {
        return day;
    }
    public int getM() {
        return month;
    }
    public int getY() {
        return year;
    }

    @Override   //overrides toString to print the date
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.day).append("/").append(this.month).append("/").append(this.year).append("\n");
        return sb.toString();
    }

    //compares two Date objects for identical values
    public boolean equals(Date d) {
        if (this.day==d.getD() && this.month==d.getM() && this.year==d.getY()) {
            return true;
        } 
        return false;
    }

}