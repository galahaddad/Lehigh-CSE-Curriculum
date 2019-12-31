/*
Description:This program will shuffle a deck and get the first 5 numbers of the array that contains the deck.
            It will then see if a straight was drawn or not.
Date of Creation: Dec 10 2019
Author: Paul Vilcapoma
*/
import java.util.Random;
import java.util.Arrays;
public class test{
  public static void main(String [] args){
    int [] deck= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                   16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                   30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
                   44, 45, 46, 47, 48, 49, 50, 52};
    straight(sort(draw(generateDeck(deck))));
  }
  public static int[] generateDeck(int [] list){
    Random random= new Random();
    for(int i=0; i<list.length; i++){
      int rand= random.nextInt(52-i);
      int temp = list[rand];
      list[rand] = list[i];
      list[i] = temp;
    }
    return list;
  }
  public static int[] draw(int [] list){
    int [] yer= new int[5];
    for(int i=0; i<yer.length; i++){
      yer[i]=list[i];
    }
    return yer;
  }
  public static int[] sort(int [] list){
    Arrays.sort(list);
    return list;
  }
  public static void straight(int[] list){
    int num=0;
    int x=1;
    for(int i=0; i<list.length; i++){
      if(list[i]+1 != list[list.length-1-i]){
         num +=x;
      }
    }
    if(num>0){
      System.out.println("No straight!");
    }
    else{
      System.out.println("You have a straight!");
    }
  }
}
