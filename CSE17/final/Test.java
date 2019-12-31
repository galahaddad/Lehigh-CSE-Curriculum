import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.io.PrintWriter;
import java.io.File;
/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        Scanner inputStream;
        BST<Student> studentBST = new BST<>();
        Heap<Student> studenHeap = new Heap<>();
        String inName;
        String inID;
        String inGPA;
        try {
            inputStream = new Scanner(new FileInputStream("students.txt"));
            while(inputStream.hasNextLine()) {
                inName=inputStream.nextLine();
                inID=inputStream.nextLine();
                int intID = Integer.parseInt(inID);
                inGPA=inputStream.nextLine();
                double doubleGPA = Double.parseDouble(inGPA);
                studenHeap.add(new Student(inName,intID,doubleGPA));
                studentBST.insert(new Student(inName,intID,doubleGPA));            
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (InputMismatchException e) {
            System.out.println("Found one input mismatch, ending program.");
        }
        System.out.println("Import of student information complete. Proceeding to sort nodes.");
        ArrayList<Object> snBST= studentBST.sortedNodes();
        ArrayList<Student> snHEAP = studenHeap.sortedNodes();
        int iterBST = BST.iterations;
        int iterHEAP = Heap.iterations;
        System.out.println("Nodes sorted. BST Iterations: " + iterBST + " Heap iterations: " + iterHEAP);

        try {
            File file = new File("studentBST.txt");
            File file2 = new File("studentHeap.txt");
            PrintWriter outPrintWriter = new PrintWriter(new FileOutputStream("studentBST.txt"));
            PrintWriter outPrintWriter2 = new PrintWriter(new FileOutputStream("studentHEap.txt"));
            for (int i=0;i<snHEAP.size(); i++) {
                outPrintWriter.println(snHEAP.get(i).toString());
            }
            for (int i=0;i<snBST.size(); i++) {
                outPrintWriter2.println(snBST.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        System.out.println("Files created! YEEHAW WE DONE.");
    }
}