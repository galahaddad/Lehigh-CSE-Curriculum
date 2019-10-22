import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

/**
 * CalendarManager program - Assignment 4 - CSE 17
 * Ralph Haddad
 */
public class CalendarManager {
    public static void main(String[] args) {
        File file = null;   //creates a file of null to be used later
        PrintWriter outputWriter=null;  //sets outputwriter to null
        Scanner inputStream;    //creates an inputstream
        Scanner yum = new Scanner(System.in);   //scanner for taking user input 
        Appointment[] appointments = new Appointment[20];   //20 Appointment objects pointing to null
        boolean quit = false;   //exit case
        int i = 0;  //appointment counter
        
        try {   //FILE CREATION TRY/CATCH
            file = new File("appointments.txt");    //sets the file object to appointments.txt if found
            inputStream = new Scanner(file);    //creates an inputstream from file
            while(inputStream.hasNextLine()) {  //takes in inputs for appointment array objects
                inputStream.nextLine();
                String eventIn = inputStream.nextLine();
                String locationIn = inputStream.nextLine();
                String [] dateStrings = inputStream.nextLine().split("/");
                int month = Integer.parseInt(dateStrings[0]);
                int day = Integer.parseInt(dateStrings[1]);;
                int year = Integer.parseInt(dateStrings[2]);;
                String [] timeStrings = inputStream.nextLine().split(":");
                int hh = Integer.parseInt(timeStrings[0]);;
                int mm = Integer.parseInt(timeStrings[1]);;
                appointments[i] = new Appointment(eventIn, locationIn, day, month, year, hh, mm);
                inputStream.nextLine();
                i++;    //counts up the amount of appointment objects
            } 
        } catch (Exception e) {
            System.out.println("File not found. Will create one at next exit of program."); //returns when using the program for the first time.
        }

        while (!quit) {
            System.out.println("Please select an operation: \n1. Add a new appoint\n2. Remove an existing appointment\n3. Update an existing appointment\n4. View all appointments\n5. Exit program");
            int menuAction = yum.nextInt();
            if (menuAction==1) {
                System.out.println("What is the event?: ");
                String event = yum.next();
                System.out.println("Where is the location?: ");
                String location = yum.next();
                try {
                    //~~~~~~~~~~~~~~~~~~~~~~~~ DATE INPUT BELOW ~~~~~~~~~~~~~~~~~~~~~~~~
                    System.out.println("When will this occur? (mm/dd/yyyy): ");
                    String date = yum.next();
                    String [] dateStrings = date.split("/");    //cases below check for valid inputs on the date
                    if (dateStrings.length < 3 || dateStrings.length > 3 || dateStrings[0].length() > 2 || dateStrings[1].length() > 2 || dateStrings[2].length() > 4) {
                        throw new InvalidDateException("Invalid Date Format.");
                    }else if (Integer.parseInt(dateStrings[0]) < 1 || Integer.parseInt(dateStrings[0]) > 12) {
                        throw new InvalidDateException("Invalid day number - must be from 1 to 31.");
                    } else if (Integer.parseInt(dateStrings[1]) < 1 || Integer.parseInt(dateStrings[1]) > 31) {
                        throw new InvalidDateException("Invalid month number - must be from 1 to 12.");
                    } else if (Integer.parseInt(dateStrings[2]) > 2030) {
                        throw new InvalidDateException("Invalid year - must be less than 2030.");
                    }
                    //~~~~~~~~~~~~~~~~~~~~~~~~ TIME INPUT BELOW ~~~~~~~~~~~~~~~~~~~~~~~~
                    System.out.println("When will this occur? (hh:mm): ");
                    String time = yum.next();
                    String [] timeStrings = time.split(":");    //cases below check for valid inputs on the time
                    if (timeStrings.length < 2 || timeStrings.length > 2 || timeStrings[0].length() > 2 || timeStrings[1].length() > 2) {
                        throw new InvalidTimeException("Invalid time format - must be hh:mm.");
                    } else if (Integer.parseInt(timeStrings[0]) < 0 || Integer.parseInt(timeStrings[0]) > 23) {
                        throw new InvalidTimeException("Invalid hours- must be from 0 to 23.");
                    } else if (Integer.parseInt(timeStrings[1]) < 0 || Integer.parseInt(timeStrings[1]) > 59) {
                        throw new InvalidTimeException("Invalid minutes - must be from 0 to 59.");
                    }
                    appointments[i] = new Appointment(event, location, Integer.parseInt(dateStrings[1]), Integer.parseInt(dateStrings[0]), Integer.parseInt(dateStrings[2]), Integer.parseInt(timeStrings[0]), Integer.parseInt(timeStrings[1]));
                    System.out.println("\nYou appointment " + i + " has been sucessfully saved as:");                    
                    System.out.println(appointments[i].toString());
                    ++i;
                } catch (InvalidDateException e) {  //prints the exception for every case, if none, goes to default
                    System.out.println(e.getMessage());
                } catch (InvalidTimeException e) {
                    System.out.println(e.getMessage());
                } 
            } else if (menuAction==2) {
                boolean proc = false;   //boolean if the process found no event of such name
                System.out.println("What is the event name?: ");
                String find = yum.next();
                for (int j=0;j<i;j++) {
                    if ((appointments[j].equals(find))) {
                        System.out.println("Appointment found. Removing it.");
                        appointments[j] = new Appointment();
                        proc = true;
                        for (int p=j;p<i;p++) {
                            appointments[p]=appointments[p+1];
                        }
                        i--;
                    }   
                }
                if (proc==false) {
                    System.out.println("No event with such name found.");
                }
            } else if (menuAction==3) {
                System.out.println("What is the event name?: ");
                String find = yum.next();
                for (int j=0;j<=i;j++) {
                    if ((appointments[j].equals(find))) {
                        System.out.println("Appointment found. Updating it:");
                        System.out.println("What is the event?: ");
                        String event = yum.next();
                        System.out.println("Where is the location?: ");
                        String location = yum.next();
                        try {
                            //~~~~~~~~~~~~~~~~~~~~~~~~ DATE INPUT BELOW ~~~~~~~~~~~~~~~~~~~~~~~~
                            System.out.println("When will this occur? (mm/dd/yyyy): ");
                            String date = yum.next();
                            String [] dateStrings = date.split("/");
                            if (dateStrings.length < 3 || dateStrings.length > 3 || dateStrings[0].length() > 2 || dateStrings[1].length() > 2 || dateStrings[2].length() > 4) {
                                throw new InvalidDateException("Invalid Date Format.");
                            }else if (Integer.parseInt(dateStrings[0]) < 1 || Integer.parseInt(dateStrings[0]) > 12) {
                                throw new InvalidDateException("Invalid day number - must be from 1 to 31.");
                            } else if (Integer.parseInt(dateStrings[1]) < 1 || Integer.parseInt(dateStrings[1]) > 31) {
                                throw new InvalidDateException("Invalid month number - must be from 1 to 12.");
                            } else if (Integer.parseInt(dateStrings[2]) > 2030) {
                                throw new InvalidDateException("Invalid year - must be less than 2030.");
                            }
                            //~~~~~~~~~~~~~~~~~~~~~~~~ TIME INPUT BELOW ~~~~~~~~~~~~~~~~~~~~~~~~
                            System.out.println("When will this occur? (hh:mm): ");
                            String time = yum.next();
                            String [] timeStrings = time.split(":");
                            if (timeStrings.length < 2 || timeStrings.length > 2 || timeStrings[0].length() > 2 || timeStrings[1].length() > 2) {
                                throw new InvalidTimeException("Invalid time format - must be hh:mm.");
                            } else if (Integer.parseInt(timeStrings[0]) < 0 || Integer.parseInt(timeStrings[0]) > 23) {
                                throw new InvalidTimeException("Invalid hours- must be from 0 to 23.");
                            } else if (Integer.parseInt(timeStrings[1]) < 0 || Integer.parseInt(timeStrings[1]) > 59) {
                                throw new InvalidTimeException("Invalid minutes - must be from 0 to 59.");
                            }
                            appointments[j] = new Appointment(event, location, Integer.parseInt(dateStrings[1]), Integer.parseInt(dateStrings[0]), Integer.parseInt(dateStrings[2]), Integer.parseInt(timeStrings[0]), Integer.parseInt(timeStrings[1]));
                            i--;
                            System.out.println("\nYou appointment has been sucessfully saved as:");
                            System.out.println(appointments[j].toString());
                        } catch (InvalidDateException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidTimeException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("No appointment found, returning to menu."); //if no such appointment was found
                        continue;
                    }
                }
            } else if (menuAction==4) {
                System.out.println("Listing all " + i + " appointments: ");
                for (int j=0;j<i;j++) {
                    System.out.println(appointments[j].toString()+"\n");
                }
            } else if (menuAction==5) {
                quit=true;  //exits the program
                System.out.println("Your appointments have been saved. Have a good day.");
                try {
                    outputWriter = new PrintWriter(new FileOutputStream("appointments.txt"));
                    for (int w=0; w<i;w++){ //stores the values of the array into the appointments file
                        outputWriter.print(appointments[w].toString());
                     }
                    outputWriter.close();                
                } catch (FileNotFoundException e) {
                    System.out.println("File not found, created one.");
                    file = new File("appointments.txt");
                    for (int w=0; w<i;w++){ //stores the values of the array into the appointments file
                        outputWriter.print(appointments[w].toString());
                     }
                    outputWriter.close();                
                }
            } else {
                System.out.println("Sorry that is not a menu option.\n");   //final case if incorrect menu option was made
            }

        }

    }

}