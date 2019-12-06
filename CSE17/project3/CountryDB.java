import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;
/**
 * CountryDB
 */
public class CountryDB {
    public static void main(String[] args) {
        Scanner inputStream1, inputStream2;
        ArrayList<Country> countries = new ArrayList<>();
        Random rand = new java.util.Random();
        Scanner userIn = new Scanner(System.in);
        String [] all;
        String [] allItems = null;
        String code, name;
        Double area;
        Country country;
        ArrayList<Integer> population = null;

        try {
            inputStream1 = new Scanner(new FileInputStream("countries.txt"));
            inputStream2 = new Scanner(new FileInputStream("population.txt"));
            while(inputStream1.hasNextLine()) {
                all = inputStream1.nextLine().split("[||]");
                code = all[0];
                name = all[1];
                area = Double.parseDouble(all[2]);
                countries.add(new Country(name, code, area));
            }
            // while(inputStream2.hasNextLine()){
            //     allItems = inputStream2.nextLine().split("[||]");
            //     for(int i=0; i<countries.size();i++){
            //         if(countries.get(i).getCountryCode().equals(allItems[0])) {
            //             population = new ArrayList<>();
            //             for(int j=0;j<100;j++) {
            //                 allItems = inputStream2.nextLine().split("[||]");
            //                 population.add(Integer.parseInt((allItems[2])));
            //             }
            //             countries.get(i).setPopulationInfo(population);
            //         }
            //     }
            // }
            System.out.println("Census data uploaded.");
        } catch (FileNotFoundException e) {
            System.out.println("Country file not found.");
        }
        
        LinkedList<Country> countryList = new LinkedList<>();
        BST<Country> countryBST = new BST<>();
        for(int i=0; i<countries.size();i++) {
            countryList.add(countries.get(i));
            countryBST.insert(countries.get(i));            
        }

        ArrayList<Object> noShuffle = new ArrayList<>();
        ArrayList<Country> randCountries = new ArrayList<>();
        for(int i=0;i<20;i++) {
            int index = rand.nextInt(countries.size());
            randCountries.add(countries.get(index));
            noShuffle.add(countryList.searchComparisons(countries.get(index)));
            noShuffle.add(countryBST.searchComparisons(countries.get(index)));
        }

        countryList.clear();
        countryBST.clear();
        shuffle(countries);
        for(int i=0; i<countries.size(); i++) {
            countryBST.insert(countries.get(i));
            countryList.add(countries.get(i));
        }
        ArrayList<Object> wShuffle = new ArrayList<>();

        for(int i=0; i<randCountries.size();i++) {
            for(int j=0; j<countries.size();j++) {
                if(randCountries.get(i).compareTo(countries.get(j))==0) {
                    wShuffle.add(countryList.searchComparisons(countries.get(j)));
                    wShuffle.add(countryBST.searchComparisons(countries.get(j)));
                }
            }
        }
        /**
         * Prints out the search comparisons for both before and after a suffle
         */
        System.out.println("Search result for LinkedList and BinarySearchTree\n");
        System.out.printf("\t\t\t\t%3s\t\t%3s","Without Shuffle","With Shuffle\n");
        System.out.printf("%-30s%4s\t\t\t%3s", "Country", "LL    BST","LL    BST\n");
        for(int i=0;i<20;i+=2) {
            String print = String.format("%-30s%3s\t%3s\t\t%3s\t%3s", randCountries.get(i).getCountryName(), noShuffle.get(i), noShuffle.get(i+1), wShuffle.get(i), wShuffle.get(i+1));
            System.out.println(print);
        }
       
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