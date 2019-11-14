/*
Description: This program will create 5 random numbers to assign to cards and will test if they contain a poker identity to them.
Author: Paul Vilcapoma
Date of Creation: Oct 27 2019
*/
public class test{
    public static void main(String[]args){
      String suitName="";
      //String cIdentity=""; Make it carIdentity
      int[] numbers = new int[5];
      int[] cIdentity= new int[5];
      int[] sIdentity= new int[5];
      for(int i = 0; i < numbers.length; i++){
        numbers[i] = random();
        cIdentity[i]= numbers[i] % 13;
        sIdentity[i]= numbers[i];
      }
      if (threeOfaKind(numbers[0],numbers[1],numbers[2],numbers[3],numbers[4])){
        System.out.println("You have a three of a kind");
      }
      else if (twoPairTest(numbers[0],numbers[1],numbers[2],numbers[3],numbers[4])){
        System.out.println("You have a two pair");
      }
      else if(pairTest(numbers[0],numbers[1],numbers[2],numbers[3],numbers[4])){
        System.out.println("You have a pair");
      }
      else if(flush(numbers[0],numbers[1],numbers[2],numbers[3],numbers[4]));{
        System.out.println("You have a flush");
      }
    }
    public static int random(){
      int x= (int)(Math.random()*51)+2;
      return x;
    }
    public static boolean pairTest(int a, int b, int c, int d, int e){
      boolean pair= (a == b || a == c || a == d || a == e || b == c || b == d || b == e);
      boolean pair2=(c == d || c == e || d == e);
      if (pair || pair2){
        return true;
      }
      else{
        return false;
      }
    }
    public static boolean twoPairTest(int a, int b, int c, int d, int e){
      boolean two0,two1,two2,two3,two4,two5,two6,two7,two8,two9,two10,two11;
      two0= ((a==b && a==c)||(a==b && a==d)||(a==b && a==e)||(a==b && b==c));
      two1= ((a==b && b==d)||(a==b && b==e)||(a==b && c==d)||(a==b && c==e));
      two2= ((a==b && d==e)||(a==c && a==d)||(a==c && a==e)||(a==c && b==c));
      two3= ((a==c && b==d)||(a==c && b==e)||(a==c && c==d)||(a==c && c==e));
      two4= ((a==c && d==e)||(a==d && a==e)||(a==d && b==c)||(a==d && b==d));
      two5= ((a==d && b==e)||(a==d && c==d)||(a==d && c==e)||(a==d && d==e));
      two6= ((a==e && b==c)||(a==e && b==d)||(a==e && b==e)||(a==e && c==d));
      two7= ((a==e && c==e)||(a==e && d==e)||(b==c && b==d)||(b==c && b==e));
      two8= ((b==c && c==d)||(b==c && c==e)||(b==c && d==e)||(b==d && b==e));
      two9= ((b==d && c==d)||(b==d && c==e)||(b==d && d==e)||(b==e && c==d));
      two10= ((b==e && c==e)||(b==e && d==e)||(c==d && c==e)||(c==d && d==e));
      two11= ((c==e && d==e));
      if (two0 || two1 || two2 || two3 || two4 || two5 || two6 || two7 || two8 || two9 || two10 || two11){
        return true;
      }
      else{
        return false;
      }
    }
    public static boolean threeOfaKind(int a, int b, int c, int d, int e){
      boolean three0=(((a==b && a==c)&&(a==b && a==d))||((a==b && a==e)&&(a==b && b==c)));
      boolean three1=(((a==b && b==d)&&(a==b && b==e))||((a==b && c==d)&&(a==b && c==e)));
      boolean three2=(((a==b && d==e)&&(a==c && a==d))||((a==c && a==e)&&(a==c && b==c)));
      boolean three3=(((a==c && b==d)&&(a==c && b==e))||((a==c && c==d)&&(a==c && c==e)));
      boolean three4=(((a==c && d==e)&&(a==d && a==e))||((a==d && b==c)&&(a==d&&b==d)));
      boolean three5=(((a==d && b==e)&&(a==d && c==d))||((a==d && c==e)&&(a==d && d==e)));
      boolean three6=(((a==e && b==c)&&(a==e && b==d))||((a==e && b==e)&&(a==e && c==d)));
      boolean three7=(((a==e && c==e)&&(a==e && d==e))||((b==c && b==d)&&(b==c && b==e)));
      boolean three8=(((b==c && c==d)&&(b==c && c==e))||((b==c && d==e)&&(b==d && b==e)));
      boolean three9=(((b==d && c==d)&&(b==d && c==e))||((b==d && d==e)&&(b==e && c==d)));
      boolean three10=(((b==e && c==e)&&(b==e && d==e))||((c==d && c==e)&&(c==d && d==e)));
      boolean three11=(((c==e && d==e)));
      if (three0 || three1 || three2 || three3 || three4 || three5){
        return true;
      }
      else{
        return false;
      }
    }
    public static boolean flush(int a, int b, int c, int d, int e){
      boolean flush= (a == b && a == c && a == d && a == e && b == c && b == d && b == e);
      boolean flush2=(c == d && c == e && d == e);
      if (flush || flush2){
        return true;
      }
      else{
        return false;
      }
    }
  }
  