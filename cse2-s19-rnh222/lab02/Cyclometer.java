//CSE 2 - lab02 - Ralph Haddad - Cyclometer 2/1/19
public class Cyclometer {
    	// main method of Cyclometer program
   	public static void main(String[] args) {
      //Input data for trips
      int secsTrip1=480;     //Seconds in trip 1
      int secsTrip2=3220;    //Seconds in trip 2
		  int countsTrip1=1561;  //Counts in trip 1
		  int countsTrip2=9037;  //Counts in trip 2
      
      // our intermediate variables and output data. Document!
      double wheelDiameter=27.0,  //Diameter of the wheel
  	  PI=3.14159, //Value of constant Pi
  	  feetPerMile=5280,  //Feet per mile conversion
  	  inchesPerFoot=12,   //Inches per foot conversion
  	  secondsPerMinute=60;  //Seconds per minute conversion
	    double distanceTrip1, distanceTrip2, totalDistance;  //Initiates doubles of three distance variables
      
      System.out.println("Trip 1 took "+ (secsTrip1/secondsPerMinute)+" minutes and had "+ countsTrip1+" counts.");
	    System.out.println("Trip 2 took "+ (secsTrip2/secondsPerMinute)+" minutes and had "+ countsTrip2+" counts.");

//The below consists of computation of the values given above
      
      distanceTrip1=countsTrip1*wheelDiameter*PI;
    	// Above gives distance in inches
    	//(for each count, a rotation of the wheel travels
    	//the diameter in inches times PI)
      
	    distanceTrip1/=inchesPerFoot*feetPerMile; // Gives distance in miles
	    distanceTrip2=countsTrip2*wheelDiameter*PI/inchesPerFoot/feetPerMile; //converts units to find the distance of trip 2
	    totalDistance=distanceTrip1+distanceTrip2; //Gives the total distance of both trips
      
      //Print out the output data.
      System.out.println("Trip 1 was "+distanceTrip1+" miles");
	    System.out.println("Trip 2 was "+distanceTrip2+" miles");
	    System.out.println("The total distance was "+totalDistance+" miles");
      
	}  //end of Cyclometer main method   
} //end of Cyclometer class