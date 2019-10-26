/* CSE 2 - Ralph Haddad - Poker Hand Check - 2/15/19
Draws 5 cards from 5 different decks and describes the hand
you revieved based on poker rules. */

public class PokerHandCheck {
  public static void main (String[] args) {
    //initiates the number of each card to be recorded for later
    int Kings = 0;
    int Queens = 0;
    int Jacks = 0;
    int Aces = 0;
    int diamonds = 0;
    int clubs = 0;
    int hearts = 0;
    int spades = 0;
    
    System.out.println("Your random cards were:");
//First Card Draw
        //Randomly drawn card identifier taken from lab04
        //determines a number between 1 and 52
        Integer cardnumber = (int) (Math.random() * 52) + 1;    //Rather than using an int which is primitive, idea taken from StackOverflow, 
        Integer cardidentity = cardnumber % 13;                 //I opted for Integer which can be used as a wrap with .equals used below
        //Determines the card identity from 0 being king to 12 which would be queen
        //0 is king, 1 is ace, 12 is queen, 11 is jack 
        //this is because the remainder of mod reset the value of king to 0
      switch (cardidentity) {
          case 0:
            System.out.print("  the King of ");
            Kings = Kings + 1;
            break;
          case 1:
            System.out.print("  the Ace of ");
            Aces = Aces + 1;
            break;
          case 12:
            System.out.print("  the Queen of ");
            Queens = Queens + 1;
            break;
          case 11:
            System.out.print("  the Jack of ");
            Jacks = Jacks + 1;
            break;
          default:  //defauls other values to just their card number since they are not royals
            System.out.print("  the " + cardidentity + " of ");
        }//end of switch statement to find the royalty cases and regular numbers
          if ( 1 <= cardnumber && 13 >= cardnumber) {             //determines diamonds suite
              System.out.println("diamonds!");
              diamonds = diamonds + 1;
            }  else if ( 14 <= cardnumber && 26 >= cardnumber) {  //determines clubs suite
              System.out.println("clubs!");
              clubs = clubs + 1;
            }  else if ( 27 <= cardnumber && 38 >= cardnumber) {  //determines hearts suite
              System.out.println("hearts!");
              hearts = hearts + 1;
            }  else if ( 39 <= cardnumber && 52 >= cardnumber) {  //determines sapdes suite
              System.out.println("spades!");
              spades = spades + 1;
            }
//Second Card Draw
    
        //Randomly drawn card identifier taken from lab04
        //determines a number between 1 and 52
        Integer cardnumber2 = (int) (Math.random() * 52) + 1;
        Integer cardidentity2 = cardnumber2 % 13;
        //Determines the card identity from 0 being king to 12 which would be queen
        //0 is king, 1 is ace, 12 is queen, 11 is jack 
        //this is because the remainder of mod reset the value of king to 0
      switch (cardidentity2) {
          case 0:
            System.out.print("  the King of ");
            Kings = Kings + 1;
            break;
          case 1:
            System.out.print("  the Ace of ");
            Aces = Aces + 1;
            break;
          case 12:
            System.out.print("  the Queen of ");
            Queens = Queens + 1;
            break;
          case 11:
            System.out.print("  the Jack of ");
            Jacks = Jacks + 1;
            break;
          default:  //defauls other values to just their card number since they are not royals
            System.out.print("  the " + cardidentity2 + " of ");
        }//end of switch statement to find the royalty cases and regular numbers
          if ( 1 <= cardnumber2 && 13 >= cardnumber2) {             //determines diamonds suite
              System.out.println("diamonds!");
              diamonds = diamonds + 1;
            }  else if ( 14 <= cardnumber2 && 26 >= cardnumber2) {  //determines clubs suite
              System.out.println("clubs!");
              clubs = clubs + 1;
            }  else if ( 27 <= cardnumber2 && 38 >= cardnumber2) {  //determines hearts suite
              System.out.println("hearts!");
              hearts = hearts + 1;
            }  else if ( 39 <= cardnumber2 && 52 >= cardnumber2) {  //determines sapdes suite
              System.out.println("spades!");
              spades = spades + 1;
            }
//Third Card Draw

        //Randomly drawn card identifier taken from lab04
        //determines a number between 1 and 52
        Integer cardnumber3 = (int) (Math.random() * 52) + 1;
        Integer cardidentity3 = cardnumber3 % 13;
        //Determines the card identity from 0 being king to 12 which would be queen
        //0 is king, 1 is ace, 12 is queen, 11 is jack 
        //this is because the remainder of mod reset the value of king to 0
      switch (cardidentity3) {
          case 0:
            System.out.print("  the King of ");
            Kings = Kings + 1;
            break;
          case 1:
            System.out.print("  the Ace of ");
            Aces = Aces + 1;
            break;
          case 12:
            System.out.print("  the Queen of ");
            Queens = Queens + 1;
            break;
          case 11:
            System.out.print("  the Jack of ");
            Jacks = Jacks + 1;
            break;
          default:  //defauls other values to just their card number since they are not royals
            System.out.print("  the " + cardidentity3 + " of ");
        }//end of switch statement to find the royalty cases and regular numbers
          if ( 1 <= cardnumber3 && 13 >= cardnumber3) {             //determines diamonds suite
              System.out.println("diamonds!");
              diamonds = diamonds + 1;
            }  else if ( 14 <= cardnumber3 && 26 >= cardnumber3) {  //determines clubs suite
              System.out.println("clubs!");
              clubs = clubs + 1;
            }  else if ( 27 <= cardnumber3 && 38 >= cardnumber3) {  //determines hearts suite
              System.out.println("hearts!");
              hearts = hearts + 1;
            }  else if ( 39 <= cardnumber3 && 52 >= cardnumber3) {  //determines sapdes suite
              System.out.println("spades!");
              spades = spades + 1;
            }
//Fourth Card Draw

        //Randomly drawn card identifier taken from lab04
        //determines a number between 1 and 52
        Integer cardnumber4 = (int) (Math.random() * 52) + 1;
        Integer cardidentity4 = cardnumber4 % 13;
        //Determines the card identity from 0 being king to 12 which would be queen
        //0 is king, 1 is ace, 12 is queen, 11 is jack 
        //this is because the remainder of mod reset the value of king to 0
      switch (cardidentity4) {
          case 0:
            System.out.print("  the King of ");
            Kings = Kings + 1;
            break;
          case 1:
            System.out.print("  the Ace of ");
            Aces = Aces + 1;
            break;
          case 12:
            System.out.print("  the Queen of ");
            Queens = Queens + 1;
            break;
          case 11:
            System.out.print("  the Jack of ");
            Jacks = Jacks + 1;
            break;
          default:  //defauls other values to just their card number since they are not royals
            System.out.print("  the " + cardidentity4 + " of ");
        }//end of switch statement to find the royalty cases and regular numbers
          if ( 1 <= cardnumber4 && 13 >= cardnumber4) {             //determines diamonds suite
              System.out.println("diamonds!");
              diamonds = diamonds + 1;
            }  else if ( 14 <= cardnumber4 && 26 >= cardnumber4) {  //determines clubs suite
              System.out.println("clubs!");
              clubs = clubs + 1;
            }  else if ( 27 <= cardnumber4 && 38 >= cardnumber4) {  //determines hearts suite
              System.out.println("hearts!");
              hearts = hearts + 1;
            }  else if ( 39 <= cardnumber4 && 52 >= cardnumber4) {  //determines sapdes suite
              System.out.println("spades!");
              spades = spades + 1;
            }
//Fifth Card Draw

        //Randomly drawn card identifier taken from lab04
        //determines a number between 1 and 52
        Integer cardnumber5 = (int) (Math.random() * 52) + 1;
        Integer cardidentity5 = cardnumber5 % 13;
        //Determines the card identity from 0 being king to 12 which would be queen
        //0 is king, 1 is ace, 12 is queen, 11 is jack 
        //this is because the remainder of mod reset the value of king to 0
      switch (cardidentity5) {
          case 0:
            System.out.print("  the King of ");
            Kings = Kings + 1;
            break;
          case 1:
            System.out.print("  the Ace of ");
            Aces = Aces + 1;
            break;
          case 12:
            System.out.print("  the Queen of ");
            Queens = Queens + 1;
            break;
          case 11:
            System.out.print("  the Jack of ");
            Jacks = Jacks + 1;
            break;
          default:  //defauls other values to just their card number since they are not royals
            System.out.print("  the " + cardidentity5 + " of ");
        }//end of switch statement to find the royalty cases and regular numbers
          if ( 1 <= cardnumber5 && 13 >= cardnumber5) {             //determines diamonds suite
              System.out.println("diamonds!");
              diamonds = diamonds + 1;
            }  else if ( 14 <= cardnumber5 && 26 >= cardnumber5) {  //determines clubs suite
              System.out.println("clubs!");
              clubs = clubs + 1;
            }  else if ( 27 <= cardnumber5 && 38 >= cardnumber5) {  //determines hearts suite
              System.out.println("hearts!");
              hearts = hearts + 1;
            }  else if ( 39 <= cardnumber5 && 52 >= cardnumber5) {  //determines sapdes suite
              System.out.println("spades!");
              spades = spades + 1;
            }
    
//Process to determine the strength of your draw
    //Value initiation for poker hands
        int p1,p2,p3,p4,p5,p6,p7,p8,p9,p10; //Checks for 10 combinations (5 choose 2) of matching card values to determine pairs, etc.

          p1 = cardidentity.equals(cardidentity2) ? 1:0;    //  card1 = card2   
          p2 = cardidentity.equals(cardidentity3) ? 1:0;    //  card1 = card3 
          p3 = cardidentity.equals(cardidentity4) ? 1:0;    //  card1 = card4
          p4 = cardidentity.equals(cardidentity5) ? 1:0;    //  card1 = card5
          p5 = cardidentity2.equals(cardidentity3) ? 1:0;   //  card2 = card3
          p6 = cardidentity2.equals(cardidentity4) ? 1:0;   //  card2 = card4
          p7 = cardidentity2.equals(cardidentity5) ? 1:0;   //  card2 = card5
          p8 = cardidentity3.equals(cardidentity4) ? 1:0;   //  card3 = card4
          p9 = cardidentity3.equals(cardidentity5) ? 1:0;   //  card3 = card5
          p10 = cardidentity4.equals(cardidentity5) ? 1:0;  //  card4 = card5  

        int ptot = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10;  //sums the values of true or false to determine number of individual pairs 

        switch (ptot) { 
          case 1: //two cards of the same value
            System.out.println("You have a pair!"); 
            break;
          case 2: //two pairs of cards of the same value
            System.out.println("You have a two pair!");
            break;
          case 3: //three of a kind case
            System.out.println("You have a three of a kind!");
            break;
          case 4: //two of a kind case
            System.out.println("You have a two of a kind!");
            break;
          case 6: //four of a kind case
            System.out.println("You have a four of a kind!");
            break;
          default:  //defaults to high card hand if there is no matches
            System.out.println("You have a high card hand!");
        }
  } //end of method
} //end of class