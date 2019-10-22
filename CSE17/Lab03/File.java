public class File extends Document{
    private String pathname, text;
    //constructor
    public File() {
        super();    //used for empty cases
        pathname = "";
    }

    public File(String pathnameString, String text) {
        super(text);
        pathname = pathnameString;
    }

    //mutator
    public void setPathname(String setPath) {
        pathname = setPath;
    }
    //accesor
    public String getPathname() {
        return pathname;
    }
    
    public String toString() {
        return "\nPathname: " + pathname + "\nText: " + super.toString();
    }
}