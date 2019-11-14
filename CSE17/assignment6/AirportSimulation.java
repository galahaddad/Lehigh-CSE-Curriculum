import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.awt.geom.Rectangle2D.Double;
import java.util.LinkedList;

/**
 * @author Ralph Haddad
 * AirportSimulation program - Houria - CSE 17
 */
public class AirportSimulation {

    public static void main(String[] args) {
        int timeDuration, takeoffTime, landingTime, takeoffRate, landingRate;
        do{
            try {
                Scanner interact = new Scanner(System.in);
                System.out.println("What is the duration of time to be simulated?: ");
                timeDuration = interact.nextInt();
                System.out.println("What is the takeoff time?: ");
                takeoffTime = interact.nextInt();
                System.out.println("What is the landing time?: ");
                landingTime = interact.nextInt();
                System.out.println("What is the landing rate?: ");
                landingRate = interact.nextInt();
                if (landingRate<60) {   //when a rate is 60 or less, reject it
                    throw new Exception("Must be a value 60 or greater");
                }
                System.out.println("What is the takeoff rate?");
                takeoffRate = interact.nextInt();
                if (landingRate<60) {   //when a rate is 60 or less, reject it
                    throw new Exception("Must be a value 60 or greater");
                } 
                break;
            } catch (Exception e) {
                System.out.println("That input is invalid. Error: " + "(" + e.getMessage() + ")");
            } 
        }while(true);
        System.out.println("Simulating an airport using given parameters under a time duration of " +timeDuration+ " minutes:\nLanding time: " + landingTime + "\t Landing Rate: "+landingRate+"\nTakeoff time: "+takeoffTime+"\tTakeoff Rate: "+takeoffRate);
        PriorityQueue<Integer> landingQueue = new PriorityQueue<>();
        Queue<Integer> takeoffQueue = new LinkedList<>();
        Queue<Integer> runway = new LinkedList<>();
        int landingPlanes = 0;  //initializing variables for measurement
        int landedPlanes = 0;
        int takeoffPlanes = 0;
        int takenoffPlanes = 0;
        int averageLandingSize = 0;
        int averageTakeoffSize = 0;
        int landingQueueTime = 0;
        int takeoffQueueTime = 0;
        for (int t=0; t<timeDuration; t++) {
            boolean runwayFree = true;
            double val1 = Math.random();   //landing time
            double val2 = Math.random();   //takeoff time
            if (val1 < landingRate/60) {        //landing time is stored if it is less than the rate per hour
                landingQueue.add(landingTime);
                landingQueueTime += t - landingRate;
                landingPlanes++;         
            }
            if (val2 < takeoffRate/60) {        //takeoff time is stored if it is less than the rate per hour
                takeoffQueue.add(takeoffTime);
                takeoffQueueTime += t - takeoffRate;
                takeoffPlanes++;
            }

            averageLandingSize+=landingQueue.size();
            averageTakeoffSize+=takeoffQueue.size();
            if (runway.isEmpty()) {
                if (!landingQueue.isEmpty()) {
                    runway.add(landingQueue.poll());
                } else if (!takeoffQueue.isEmpty()) {
                    runway.add(takeoffQueue.poll());
                }
            } else if (!runway.isEmpty()) {
                if (runway.peek() == landingTime) {
                        landedPlanes++;
                } else {
                        takenoffPlanes++;
                }
                t += runway.poll();
            }
               
        }   //proceeds to print all values
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nPlanes landing: " + landingPlanes 
        + "\tPlanes to take off: " + takeoffPlanes 
        + "\nLanded planes: " + landedPlanes 
        + "\tTaken off planes: " + takenoffPlanes 
        + "\nAverage size of landing qeueue: " + averageLandingSize/timeDuration 
        + "\tAverage size of takeoff queue: " + averageTakeoffSize/timeDuration
        + "\nAverage landing queue time: " + landingQueueTime/timeDuration
        + "\tAverage takeoff queue time: " + takeoffQueueTime/timeDuration);
    }
}