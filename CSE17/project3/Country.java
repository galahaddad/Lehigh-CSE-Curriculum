import java.util.ArrayList;

/**
 * Country
 */
public class Country implements Comparable<Country>{

    private String countryName, countryCode;
    private Double countryArea;
    //private ArrayList<Integer> populationInfo = new ArrayList<>();

    public Country() {
        countryName="";
        countryCode="";
        countryArea=0.0;
        //populationInfo = new ArrayList<>(100);
    } 

    public Country(String name, String code, Double area) {
        countryName=name;
        countryCode=code;
        countryArea=area;
        //populationInfo = new ArrayList<>(100);
        //populationInfo.addAll(population);
    }

    /**
     * @param countryArea the countryArea to set
     */
    public void setCountryArea(Double countryArea) {
        this.countryArea = countryArea;
    }
    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    // /**
    //  * @param populationInfo the populationInfo to set
    //  */
    // public void setPopulationInfo(ArrayList<Integer> populationInfo) {
    //     this.populationInfo = populationInfo;
    // }
    // /**
    //  * @return the countryArea
    //  */
    public Double getCountryArea() {
        return countryArea;
    }
    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }
    // /**
    //  * @return the populationInfo
    //  */
    // public ArrayList<Integer> getPopulationInfo() {
    //     return populationInfo;
    // }

    public int compareTo(Country country) {
        if (getCountryName()==country.getCountryName()) return 0;
        return -1;
    }
}