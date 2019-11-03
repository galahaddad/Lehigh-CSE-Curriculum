import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Ralph Haddad
 * Generics active learning assignment 7 
 */
public class Generics {
    public static void main(String[] args) {
        ArrayList<Pair<String, Integer>> listTrees = new ArrayList<>();
        listTrees.add(new Pair<String,Integer>("Leather Leaf Acaia", 12));
        listTrees.add(new Pair<String,Integer>("Key Lime", 24));
        listTrees.add(new Pair<String,Integer>("American Hazelnut", 24));
        listTrees.add(new Pair<String,Integer>("Flowering Maple", 24));
        listTrees.add(new Pair<String,Integer>("Silverberry", 36));

        ArrayList<Pair<Integer, Double>> listStudents = new ArrayList<>();
        listStudents.add(new Pair<Integer,Double>(12345, 3.96));
        listStudents.add(new Pair<Integer,Double>(54321, 2.25));
        listStudents.add(new Pair<Integer,Double>(12453, 3.50));
        listStudents.add(new Pair<Integer,Double>(53421, 2.83));
        listStudents.add(new Pair<Integer,Double>(51234, 1.25));

        Scanner haha = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Select an operation:\n1. TreeList\n2. StudentList\n3. Exit");
            int menuAction = haha.nextInt(); haha.nextLine();
            if (menuAction==1) {
                try {
                    System.out.println("Enter a tree name: ");
                    String treeString = haha.nextLine();
                    if (search(listTrees, treeString)!=-1) {
                        System.out.println("That tree exists in index " + search(listTrees, treeString));
                    } else {
                        throw new Exception("Item not found");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (menuAction==2) {
                try {
                    System.out.println("Enter a student name: ");
                    int studentID = haha.nextInt();
                    if (search(listStudents, studentID)!=-1) {
                        System.out.println("That student exists in index " + search(listStudents, studentID));
                    } else {
                        throw new Exception("Item not found");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (menuAction==3){
                System.out.println("Peace!");
                exit=true;
            } else {
                System.out.println("That is not a menu option");
            }
        }


    }

    /**
     * Searches the array of pairs for equal first values
     * @param <E1> first generic of the pair  
     * @param <E2> second generic of the pair
     * @param list the arraylist name
     * @param key the generic being found
     * @return -1 if no pair was found, or the index where there was a match
     */
    public static <E1, E2> int  search(ArrayList<Pair<E1, E2>> list, E1 key) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getFirst().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
}