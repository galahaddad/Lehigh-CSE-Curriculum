/*
Description: Create an array and add the even and odd indices of the array. It will then compare the total sum of even
              and odd and will compare it to the last digit in the upc.
Date of Creation: Nov 8 2019
Author: Paul Vilcapoma
*/
import java.util.Scanner;
public class test{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter 12 digits: "); //Asks user for the barcode
    String barcode = scanner.nextLine();
    int[] result = extractDigits(barcode); //will create an array for the digits in the array
    for (int i=0; i<result.length; i++) {
      System.out.println(result[i]+" ");
    }
    int odd= getOddSum(result); //returns sum of the odd in the array
    int even= getEvenSum(result); //returns the sum of the even in the array
    System.out.println("The odd sum is: " + odd);
    System.out.println("The odd sum is: " + even);
    int total= odd + even; //Calculates the total of odd and even and saves it in total
    //Will compare if the total and the last digit in the upc are equal or not
    System.out.println(checkDigit(total, result[11]));//Will Either return true or false
  }
  public static int[] extractDigits(String bar){
    int[] array = new int[bar.length()];
    for(int i = 0; i < bar.length(); i++){
        array[i] = Integer.parseInt(Character.toString(bar.charAt(i)));
    }
    return array;
  }
  public static int getOddSum(int[] list){
    int sum = 0;
    for (int i= 0; i<list.length; i++){
      if(i % 2 == 0){
        continue;
      }
      else{
        sum += list[i];
      }
    }
    return sum * 3;
  }
  public static int getEvenSum(int[] list){
    int sum = 0;
    for (int i= 0; i<list.length; i++){
      if(i % 2 == 0){
        sum += list[i];
      }
      else{
        continue;
      }
    }
    return sum;
  }
  public static boolean checkDigit(int sum, int ye){
    if (sum == ye){
      return true;
    }
    else{
      return false;
    }
  }
}
