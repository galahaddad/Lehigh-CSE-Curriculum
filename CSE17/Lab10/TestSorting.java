import java.util.ArrayList;
import java.util.Random;
/**
 * TestSorting
 */
public class TestSorting {

    public static void main(String[] args) {
        Random myRandom = new Random();
        int ran = myRandom.nextInt(100000);
        ArrayList<Integer>numArr = new ArrayList<>();
        for (int i=0; i<100000;i++) {
            numArr.add(ran);
        }

    }
}