/*
Description:This program will make a checkerboard with the input of the user for width,
              height, and size for the board.
Author: Paul Vilcapoma
Date of Creation: Oct 18 2019
*/
import java.util.Scanner;
public class test
{
    public static void main(String[] args)
    {
        //This will aks user input for the height,width, and size
        Scanner keyboard= new Scanner(System.in);
        System.out.print("Enter height: ");
        int height= keyboard.nextInt();
        System.out.print("Enter the width: ");
        int width= keyboard.nextInt();
        System.out.print("Enter size: ");
        int size= keyboard.nextInt();
        String str = "+";
        String umm = "|";

        String repeated = new String(new char[width]).replace("\0", str); //This will repeat the number of times as the width number
        String repeatedHeight= new String(new char[height]).replace("\0", str); //This will repeat the number of times as the height number
        String repeatUmm= new String(new char[width]).replace("\0", umm); //This will repeat the number of times as the width number
        //This will create the top part of the board
        for (int i = 0; i < repeated.length(); i++){
            System.out.print(i % size == 0 ? repeated.charAt(i) : "-");
        }
        //This will create the outer and inside of the board
        for (int i = 0; i < repeatedHeight.length(); i++){
            System.out.println(i % size == 0 ? repeated.charAt(i) : "|" );
            for (int j = 0; j < repeatUmm.length(); j++){
                if (j == width){
                    System.out.print(" ");
                    continue;
                }
                System.out.print(j % size == 0 ? repeatUmm.charAt(j) : "#" );


            }
        }
        //System.out.print(j % size == 0 ? repeatUmm.charAt(j) : " "
    }
}
