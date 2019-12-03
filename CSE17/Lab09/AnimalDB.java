import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;


/**
 * @author Ralph Haddad
 * AnimalDB
 */
public class AnimalDB {
    public static void main(String[] args) {
        Scanner inputStream;
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> animalList = new LinkedList<>();
        BST<String> animalBST = new BST<>();
        /**
         * Attempts to connect to the file and take in the data into an array list
         * proceeds to shuffle the array and take in an input from the user for search
         */
        try {
            inputStream = new Scanner(new FileInputStream("animals.txt"));
            while(inputStream.hasNextLine()) {
                list.add(inputStream.nextLine());                
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        shuffle(list);
        for(int i=0;i<list.size();i++) {
            animalBST.insert(list.get(i));
            animalList.add(list.get(i));
        }

        String search = "";
        do {
            System.out.println("Enter an animal name to be searched: ");
            search = in.nextLine();
            if(search.isEmpty()){
                break;
            }
            if(animalList.contains(search)) {
                System.out.println(search + " is found in the LinkedList after " + animalList.searchComparisons(search) + " comparison iterations.");
            }
            if(animalBST.search(search)){
                System.out.println(search + " was found in the binary search tree after " + animalBST.searchComparisons(search) + " comparison iterations.");
            }
            else {
                System.out.println("Your search: '" + search + "' was not found.");
            }
        } while (true);

    }
    
    /**
     * Shuffles the originally imported array
     * @param <E> genric variable
     * @param list ArrayList to be shuffled
     */
    public static <E> void shuffle(ArrayList<E> list) {
        Collections.shuffle(list, new Random());
    }
}