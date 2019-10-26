//hw02 - Arithmetic ASSignment - 2/4/19
//Ralph Haddad, Professor Chen
public class Arithmetic {
    public static void main (String[] args) {
        //VARIABLE ASSIGNMENTS//
        
        //Number of pairs of pants
        int numPants = 3;
        //Cost per pair of pants
        double pantsPrice = 34.98;
      
        //Number of sweatshirts
        int numShirts = 2;
        //Cost per shirt
        double shirtPrice = 24.99;
      
        //Number of belts
        int numBelts = 1;
        //cost per belt
        double beltCost = 33.99;
      
        //the tax rate
        double paSalesTax = 0.06;
      
      //Total Costs of Items
        double totalCostOfPants = (((int)(numPants * pantsPrice * 100))/(100.0)); //total cost of pants
        double totalCostOfShirts = (((int)(numShirts * shirtPrice * 100))/(100.0)); //total cost of shirts
        double totalCostOfBelts = (((int)(numBelts * beltCost * 100))/(100.0));  //total cost of belts
        
      //Sales Tax Charge on All Items
        double stPants = (((int)(totalCostOfPants * paSalesTax * 100))/(100.0)); //Sales tax on all pants
        double stShirts = (((int)(totalCostOfShirts * paSalesTax * 100))/(100.0)); //Sales tax on all shirts
        double stBelts = (((int)(totalCostOfBelts * paSalesTax * 100))/(100.0)); //Sales tax on all belts
      
      //Total Cost Before Tax
        double totalCostAll = (((int)(totalCostOfBelts + totalCostOfPants + totalCostOfShirts)*(100))/(100.0)); 
        
      //Total Sales Tax
        double totalST = (((int)((stPants + stShirts + stBelts)*(100)))/(100.0));
        
      //Total cost with pa tax
        double totalTotal = (((int)((totalCostAll + totalST)*(100)))/(100.0));
        
      //Print Statements of values
        System.out.println("Total cost of all products before tax: $" + totalCostAll); //prints total cost of all goods
        System.out.println("Total Sales Tax: $" + totalST); //prints total sales tax
        System.out.println("Total cost of all products with tax: $" + totalTotal); //prints total cost with tax
    }
}