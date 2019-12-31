/**
 * Student
 */
public class Student implements Comparable<Student> {
    public String name;
    public int id;
    public double gpa;

    public Student() {
        name="";
        id=0;
        gpa=0;
    }

    public Student(String name, int id, double gpa) {
        this.name=name;
        this.id=id;
        this.gpa=gpa;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param gpa the gpa to set
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return name + "\n" + id + "\n" + gpa;
    }

    public int compareTo(Student student) {
        if(getGpa()==student.getGpa()) return 0;
        else if (getGpa() > student.getGpa()) return 1;
        else return -1;
    }


    
}