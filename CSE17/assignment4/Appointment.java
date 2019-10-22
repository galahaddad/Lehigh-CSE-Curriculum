public class Appointment {
    String event, location;
    Date date = new Date();
    Time time = new Time();

    public Appointment() {  //default constructor
        event="";
        location="";
        date.setD(0); date.setM(0); date.setY(0);
        time.setHour(0); time.setMinutes(0);   
    }
 
    public Appointment(String event, String location, int dd, int mm, int yy, int hh, int min) {
        this.event=event;
        this.location=location;
        date.setD(dd); date.setM(mm); date.setY(yy);
        time.setHour(hh); time.setMinutes(min);
    }

    //mutaotors
    public void setD(int dd) {
        date.setD(dd);
    }
    public void setM(int mm) {
        date.setM(mm);
    }
    public void setY(int yy) {
        date.setY(yy);
    }
    public void setHour(int hour) {
        time.setHour(hour);
    }
    public void setMinutes(int minutes) {
        time.setMinutes(minutes);
    }
    public void setEvent(String event) {
        this.event=event;
    }
    public void setLocation(String location) {
        this.location=location;
    }

    //accesors
    public int getD() {
        return date.getD();
    }
    public int getM() {
        return date.getM();
    }
    public int getY() {
        return date.getY();
    }
    public int getHour() {
        return time.getHour();
    }
    public int getMinutes() {
        return time.getMin();
    }
    public String getEvent() {
        return event;
    }
    public String getLocation() {
        return location;
    }

    @Override   //overrides toString to print the appointment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(this.event).append("\n").append(this.location).append("\n").append(this.date.toString()).append(this.time.toString()).append("\n");
        return sb.toString();
    }

    //compares two Appointment objects for identical event strings
    public boolean equals(String a) {
        return this.event.matches(a);
    }

}
