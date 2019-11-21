import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * TestShuffle
 */
public class TestShuffle {

    public static void main(String[] args) {
        String[ ][ ] stateCapitals = { {"Alabama", "Montgomery"}, {"Alaska", "Juneau"},  

                                {"Arizona", "Phoenix"},   {"Arkansas", "Little Rock"},  

                                {"California", "Sacramento"}, {"Colorado", "Denver"},  

                                {"Connecticut", "Hartford"}, {"Delaware", "Dover"}, 

                                {"Florida", "Tallahassee"},  {"Georgia", "Atlanta"},  

                                {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},

                                {"Illinois", "Springfield"}, {"Maryland", "Annapolis"},  

                                {"Minnesota", "Saint Paul"}, {"Iowa", "Des Moines"}, 

                                {"Maine", "Augusta"}, {"Kentucky", "Frankfort"},  

                                {"Indiana", "Indianapolis"},  {"Kansas", "Topeka"}, 

                                {"Louisiana", "Baton Rouge"},  {"Oregon", "Salem"},  

                                {"Oklahoma", "Oklahoma City"}, {"Ohio", "Columbus"},

                                {"North Dakota", "Bismark"}, {"New York", "Albany"},  

                                {"New Mexico", "Santa Fe"},  {"New Jersey", "Trenton"},  

                                {"New Hampshire", "Concord"}, {"Nevada", "Carson City"}, 

                                {"Nebraska", "Lincoln"}, {"Montana", "Helena"}, 

                                {"Missouri", "Jefferson City"},  {"Mississippi", "Jackson"}, 

                                {"Massachusetts", "Boston"}, {"Michigan", "Lansing"},

                                {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},  

                                {"South Carolina", "Columbia"},  {"South Dakota", "Pierre"}, 

                                {"Tennessee", "Nashville"}, {"Texas", "Austin"},  

                                {"Utah", "Salt Lake City"},  {"Vermont", "Montpelier"},  

                                {"Virginia", "Richmond"},  {"Washington", "Olympia"}, 

                                {"West Virginia", "Charleston"},  {"Wisconsin", "Madison"},  

                                {"Wyoming", "Cheyenne"}  };


        ArrayList<Pair<String,String>> listStates = new ArrayList<>();
        for (int i=0; i<stateCapitals.length; i++) {
            listStates.add(new Pair<String,String>(stateCapitals[i][0],stateCapitals[i][1]));
        }
        System.out.println("Unshuffled array:");
        System.out.println(listStates.toString());
        System.out.println("Shuffled array:");
        shuffle(listStates);
        System.out.println(listStates.toString());
        boolean exit = false;
        while(!exit) {
            System.out.println("\nPlease enter the name of the State");
            Scanner in = new Scanner(System.in);
            String State = in.next();
            if (search(listStates, State) != -1) {
                String res = listStates.get(search(listStates, State)).getSecond();
                System.out.println("The capital is: " + res);
                System.out.println("Do you want to continue? (y/n)");
                String menu = in.next();
                if (menu.matches("y")) {
                    continue;
                } else {
                    exit=true;
                }
            } else {
                System.out.println("Could not be found in the array");
            }
        }
        System.out.println("Exiting program."); 
    } 


    public static <E1,E2> void shuffle(ArrayList<Pair<E1, E2>> list) {
        Collections.shuffle(list, new Random());
    }
    


    public static <E1, E2> int search(ArrayList<Pair<E1, E2>> list, E1 key) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getFirst().equals(key)) {
                return i;
            }
        }
        return -1;
    }

}