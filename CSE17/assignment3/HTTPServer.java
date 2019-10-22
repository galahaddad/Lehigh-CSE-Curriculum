/**
 * HTTPServer
 */
import java.util.Scanner;
public class HTTPServer {
    public static void main(String[] args) {
        Scanner yum = new Scanner(System.in);
        int menuAction;
        Stack myStack = new Stack();
        System.out.println("Welcome to the http server.");
        do{
            System.out.println("\nSelect an operation: \n1. Enter new request \n2. View only last request \n3. View and remove last request \n4. Quit\n");
            do {
                if(yum.hasNextInt()){
                    menuAction=yum.nextInt();
                    if(menuAction<1||menuAction>4){
                        System.out.println("Pick an operation between 1 and 4: ");
                        continue;
                    } else {
                        break;
                    }
                } else {
                    String junk =yum.next();
                    System.out.println("Please select a valid operation. ");
                }
            } while (true);

            if (menuAction==1){
                do{
                    System.out.println("Enter page URL:");
                    String input = yum.next();
                    if(!input.startsWith("https://www.") && !input.startsWith("https://www.") || !input.endsWith(".com")) {
                        System.out.print("That is not a valid URL. Enter another.");
                    } else {
                        myStack.push(input);
                        System.out.println("Request added succesfully!");
                        break;
                    }
                }while (true);
            } else if (menuAction==2) {
                System.out.println(myStack.peek());
            } else if (menuAction==3) {
                System.out.println(myStack.peek());
                System.out.println(myStack.pop());
            }
        } while (menuAction !=4);
        System.out.println("Thanks for using the http server.");
    }
}