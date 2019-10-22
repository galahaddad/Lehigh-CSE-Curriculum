public class Time {
    int hour, min;

    public Time() {
        hour=0; min=0;
    }
    public Time(int h, int m) {
        hour=h;
        min=m;
    }

    //accesors
    public int getHour() {
        return hour;
    }
    public int getMin() {
        return min;
    }

    //mutators
    public void setHour(int hours) {
        hour=hours;
    }
    public void setMinutes(int minutes) {
        min=minutes;
    }

    @Override   //overrides toString to print the Time
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hour).append(":").append(this.min).append("\n");
        return sb.toString();
    }

    //compares two Time objects for identical values
    public boolean equals(Time t) {
        if (this.hour==t.getHour() && this.min==t.getMin()) {
            return true;
        } 
        return false;
    }

}