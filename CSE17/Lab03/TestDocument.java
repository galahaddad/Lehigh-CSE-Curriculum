/**
 * TestDocument for in class lab in class learning activity assignment 3
 * Ralph Haddad - CSE17 - Houria
 */
public class TestDocument {
    public static void main(String[] args) {
        String toFile = ("\n\tpublic class Lab1{\n\t\t// This line defines the main method\n\t\t// where the program starts\n\t\t// The method starts with { and ends with }\n\t\tpublic static void main(String[] args){\n\t\t\t//The main method contains one Java statement to print\n\t\t\t// the message “Hello World!” on the screen\n\t\t\t\tSystem.out.println(“Hello World!”);\n\t\t} // end of the main method\n\t} // end of the class Lab1");
        Email theEmail = new Email("boo111@lehigh.edu", "hoo111@lehigh.edu", "Late Working Hours", "\nHello,\nThis is a reminder for your approval of late working hours on 01/24/2018.\nBest regards,\nBen");
        File theFile = new File("/home/boo111/CSE17/Practice.java",toFile);
        //tests for hello
        if(containsKeyword(theEmail, "Hello")) {
            System.out.println(theEmail.toString());
        }
        if(containsKeyword(theFile, "Hello")) {
            System.out.println(theFile.toString());
        }
        //tests for morning
        if(containsKeyword(theEmail, "Morning")) {
            System.out.println(theEmail.toString());
        }
        if(containsKeyword(theFile, "Morning")) {
            System.out.println(theFile.toString());
        }
    }
    //provided containskeyword method
    public static boolean containsKeyword(Document docObject, String keyword) {
        if (docObject.toString().indexOf(keyword,0) >= 0) {
            return true;
        }
        return false;
    }
}