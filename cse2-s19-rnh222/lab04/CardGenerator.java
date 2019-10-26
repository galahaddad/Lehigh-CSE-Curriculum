//CSE 2 - Ralph Haddad - Card Generator 2/15/19
//This program selects a random card from a deck of 52
public class CardGenerator {
  public static void main (String[] args) {
    //determines a number between 1 and 52
    int cardnumber = (int) (Math.random() * 52) + 1;
    int cardidentity = cardnumber % 13;
    //Determines the card identity from 0 being king to 12 which would be queen
    //0 is king, 1 is ace, 12 is queen, 11 is jack 
    //this is because the remainder of mod reset the value of king to 0
    switch (cardidentity) {
      case 0:
        System.out.print("You picked the King of ");
        break;
      case 1:
        System.out.print("You picked the Ace of ");
        break;
      case 12:
        System.out.print("You picked the Queen of ");
        break;
      case 11:
        System.out.print("You picked the Jack of ");
        break;
      default:  //defauls other values to just their card number since they are not royals
        System.out.print("You picked the " + cardidentity + " of ");
    }//end of switch statement to find the royalty cases and regular numbers
      if ( 1 <= cardnumber && 13 >= cardnumber) {             //determines diamonds suite
          System.out.println("diamonds!");
        }  else if ( 14 <= cardnumber && 26 >= cardnumber) {  //determines clubs suite
          System.out.println("clubs!");
        }  else if ( 27 <= cardnumber && 38 >= cardnumber) {  //determines hearts suite
          System.out.println("hearts!");
        }  else if ( 39 <= cardnumber && 52 >= cardnumber) {  //determines sapdes suite
          System.out.println("spades!");
        }
  }//end of main
}//end of class