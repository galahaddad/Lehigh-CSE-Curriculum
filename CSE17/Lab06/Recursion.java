import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ralph Haddad
 * Recursion program - CSE17
 */
public class Recursion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a filename to search: ");
        String inFile = in.next();
        System.out.println("Enter a path to be searched: ");
        String inPath = in.next();
        if (searchFile(inPath, inFile)=="") {
            System.out.println("File not found");
        } else {    //returns an appropriate file size unit
            long filesize = getSize(searchFile(inPath, inFile));
            if (filesize>=10000) {
                System.out.println("Pathsize is " + filesize/10000 + "Kbytes");
            } else if (filesize>=1000000) {
                System.out.println("Pathsize is " + filesize/1000000 + "Mbytes");
            } else if (filesize>=1000000000) {
                System.out.println("Pathsize is " + filesize/1000000000 + "Gbytes");
            } else {
                System.out.println("Pathsize is " + filesize + "bytes");
            }
        }
        System.close();
    }

    /**
     * getSize function to find the size of a file within a directory
     * @param path the path found from searchFile
     * @return size of the file in bytes
     */
    public static long getSize(String path) { 
      long totalSize = 0;
      ArrayList<String> directory = new ArrayList<String>();
      File file = new File(path);
      
      if(file.isDirectory()) { 
         directory.add(file.getAbsolutePath());
         while (directory.size() > 0) {
            String folderPath = directory.get(0);
            System.out.println("Size of this :"+folderPath);
            directory.remove(0);
            File folder = new File(folderPath);
            File[] filesInFolder = folder.listFiles();
            int noOfFiles = filesInFolder.length;
            
            for(int i = 0 ; i < noOfFiles ; i++) { 
               File f = filesInFolder[i];
               if(f.isDirectory()) { 
                  directory.add(f.getAbsolutePath());
               } else { 
                  totalSize += f.length();
               } 
            } 
         } 
      } else { 
         totalSize = file.length();
      } 
      return totalSize;
   }

    /**
     * searchFile method provided by the professor
     * @param currentPath the path to be searched
     * @param targetFile the file to be found
     * @return the pathname of the found file
     */
    public static String searchFile(String currentPath, String targetFile) {
        String recursivePath;
        System.out.println("Searching in " + currentPath + " for " + targetFile);
        File findFile = new File(currentPath);
        if (!findFile.isDirectory()) {
            return "";
        } else {
            File[] fileList = findFile.listFiles();
            for (int i=0; i<fileList.length; i++) {
                if (fileList[i].isFile()) {
                    System.out.println("Comparing " + targetFile + " to filename " + fileList[i].getName());
                    if(fileList[i].getName().equals(targetFile)) {
                        return fileList[i].getPath();
                    }
                }
                if (fileList[i].isDirectory()) {
                    System.out.println("Going inside directory " + fileList[i].getName());
                    recursivePath=searchFile(fileList[i].getPath(), targetFile);
                    if (!recursivePath.equals("")) {    
                        return recursivePath;
                    }
                }
            }
        }
        return "";
    }
}