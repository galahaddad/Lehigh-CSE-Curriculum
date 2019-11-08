/**
 * TestGenericGrid - Ralph Haddad - CSE17
 */
public class TestGenericGrid {

    public static void main(String[] args) {
        String [][] cStrings = new String [5][5];
        cStrings[0][0] = "Tamaqua";
        cStrings[0][1] = "Lehighton";
        cStrings[0][2] = "Dansville";
        cStrings[0][3] = "Liberty";
        cStrings[0][4] = "Hope";
        cStrings[1][0] = "Kempton";
        cStrings[1][1] = "Northampton";
        cStrings[1][2] = "Nazareth";
        cStrings[1][3] = "Lopatcong";
        cStrings[1][4] = "Washington";
        cStrings[2][0] = "Hamburg";
        cStrings[2][1] = "Allentown";
        cStrings[2][2] = "Bethlehem";
        cStrings[2][3] = "Easton";
        cStrings[2][4] = "Stewartsville";
        cStrings[3][0] = "Bernville";
        cStrings[3][1] = "Emmaus";
        cStrings[3][2] = "Hellertown";
        cStrings[3][3] = "Milford";
        cStrings[3][4] = "Alexandria";
        cStrings[4][0] = "Reading";
        cStrings[4][1] = "BoyerTown";
        cStrings[4][2] = "Harleysville";
        cStrings[4][3] = "Doylestown";
        cStrings[4][4] = "New Hope";
        GenericGrid<String> grid = new GenericGrid<>(cStrings);
        System.out.println(grid.toString());
        System.out.println(findPath(grid, 3, 0, 0, 4)); //findPath for bernville to hope
        System.out.println("Number of paths from Reading to Bethlehem: "+(findPaths(grid, 4, 0, 2, 2))); //findPath for Reading to Bethlehem
    }

    /**
     * findPath recursively prints the city values required to reach a destination
     * @param <E> generic object
     * @param grid the ArrayList of the city array
     * @param startRow beginning row
     * @param startCol beginning column
     * @param endRow end row
     * @param endCol end column
     * @return a final statement once the method completes its recursion
     */
    public static <E> String findPath(GenericGrid<E> grid, int startRow, int startCol, int endRow, int endCol) {
        System.out.print(grid.get(startRow,startCol)+"-");
        if (startRow==endRow && startCol==endCol) {
            return grid.get(endRow,endCol).toString();
        } else if (startRow>endRow && startCol<endCol) {
            double i = Math.random();
            if (i>.5) {
                findPath(grid, startRow, startCol+1, endRow, endCol);
            } else {
                findPath(grid, startRow-1, startCol, endRow, endCol);
            }
        } else if (startRow==endRow && startCol<endCol) {
            findPath(grid, startRow, startCol+1, endRow, endCol);
        } else if (startRow>endRow && startCol==endCol) {
            findPath(grid, startRow-1, startCol, endRow, endCol);
        }
        return "> *Google Assistant Voice* You have arrived. ";   
    }

    /**
     * findPaths finds the total paths between two cities
     * @param <E> generic object
     * @param grid the ArrayList of the city array
     * @param startRow beginning row
     * @param startCol beginning column
     * @param endRow end row
     * @param endCol end column
     * @return the total paths
     */
    public static <E> int findPaths(GenericGrid<E> grid, int startRow, int startCol, int endRow, int endCol) {
        int sumofpaths = 0;
        if (startRow>endRow && startCol<endCol){
            sumofpaths += 2;
            sumofpaths += findPaths(grid, startRow, startCol+1, endRow, endCol);
        } else if (startRow==endRow && startCol<endCol) {
            sumofpaths += findPaths(grid, startRow, startCol+1, endRow, endCol);
        } else if (startRow>endRow && startCol==endCol) {
            sumofpaths += findPaths(grid, startRow-1, startCol, endRow, endCol);
        } else if (startRow==endRow && startCol==endCol) {
            return 2;
        }
        return sumofpaths;
    }
    
}