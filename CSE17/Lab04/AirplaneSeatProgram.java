import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.io.File;
/**
 * AirplaneSeatProgram
 */
public class AirplaneSeatProgram {
    public static void main(String[] args) throws InvalidSeatException {
        InvalidSeatException ISE = new InvalidSeatException();
        Scanner inputScanner=null;
        PrintWriter outputWriter=null;
        File file = null;
        String [][] seats = new String[9][8]; //when the file is not found, it creates the array of strings
        try {
            file = new File("seatsmap.txt");
            inputScanner = new Scanner(file);
            for (int i=0; i<9;i++){
                for (int j=0; j<8; j++){
                    seats[i][j]=Character.toString(inputScanner.next().charAt(0));
                }
             }
        } catch (Exception e) {
            System.out.println("No seatmap file found. Created one.");
            for (int i=0; i<9;i++){
               for (int j=0; j<8; j++){
                   seats[i][j]=".";
               }
            }
        }
        boolean quit = false;   //sentinel variable to leave loop
        while (!quit) {
            System.out.println("Please select an operation: ");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Free a seat");
            System.out.println("3. Quit");

            Scanner userIn = new Scanner(System.in);
            int menuAction = userIn.nextInt();

            if (menuAction==1) {  //~~~~~~~~~~~~~~~~~RESERVE A SEAT~~~~~~~~~~~~~~~~~~~~~~~~~
                int ec = 0; //exit case
                String SN;
                char xchar, ychar;
                Integer x, y;
                do {
                    printSeats(seats);
                    System.out.println("Enter a seat number (ex. 4C): ");
                    SN = userIn.next();
                    xchar = SN.charAt(0);
                    ychar = SN.charAt(1);
                    x = xchar-49;
                    y = ychar-17-48;
                    try {
                        if (x>8 || x < 0 || y<0 || y>9){
                            throw new Exception("Invalid seat number. Please try again.\n");
                        } else if (seats[x][y].contains("x")) {
                            throw new Exception("Seat already taken.");
                        }
                        seats[x][y] = "x";
                        System.out.println("Seat " + SN + " successfully reserved.\n\n");
                        ec=1;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        if (e.getMessage() != "Invalid seat number. Please try again\n") {
                            ec=1;
                        } else {
                            ec=0;
                        }
                    }
                } while(ec==0);
            } else if (menuAction==2) {  //~~~~~~~~~~~FREE A SEAT~~~~~~~~~~~~~~~~~~~~~~~~~~~
                int ec = 0; //exit case
                String SN;
                char xchar, ychar;
                Integer x, y;
                do {
                    printSeats(seats);
                    System.out.println("Enter a seat number (ex. 4C): ");
                    SN = userIn.next();
                    xchar = SN.charAt(0);
                    ychar = SN.charAt(1);
                    x = xchar-49;
                    y = ychar-17-48;
                    try {
                        if (x>8 || x < 0 || y<0 || y>9){
                            throw new Exception("Invalid seat number. Please try again.\n");
                        } else if (seats[x][y].contains(".")) {
                            throw new Exception("Seat already free.\n");
                        }
                        seats[x][y] = ".";
                        System.out.println("Seat " + SN + " successfully freed.\n\n");
                        ec=1;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        if (e.getMessage() != "Invalid seat number. Please try again\n") {
                            ec=1;
                        } else {
                            ec=0;
                        }
                    }
                } while(ec==0);
            } else if (menuAction==3) { //~~~~~~~~~~EXIT~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                quit = true;    // enables the program to quit the menu loop
                try {
                    outputWriter = new PrintWriter(new FileOutputStream("seatsmap.txt"));
                    for (int i=0; i<9;i++){ //stores the values of the array into the seatsmap file
                        for (int j=0; j<8; j++){
                            outputWriter.print(seats[i][j]);
                        }
                        outputWriter.println();
                     }
                    outputWriter.close();                
                    System.out.println("\n Thank you for using the seat reserving service.\n Your information has been saved.");
                } catch (FileNotFoundException e) {
                    //File file = new File("seatsmap.txt");
                    for (int i=0; i<9;i++){ //stores the values of the array into the seatsmap file
                        for (int j=0; j<8; j++){
                            outputWriter.print(seats[i][j]);
                        }
                        outputWriter.println();
                     }
                }
                //inputScanner.close();
            } else {
                System.out.println("Sorry that is not a menu option.\n");
            }   
        }
    }

    public static void printSeats(String [][] arr){
        System.out.println("  A B     C D E F     G H");
        for (int i=0;i<arr.length;i++) {
            System.out.print(i+1);
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(" " + arr[i][j]);
                if (j==1 || j==5) {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
}