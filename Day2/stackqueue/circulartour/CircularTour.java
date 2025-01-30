package stackqueue.circulartour;


public class CircularTour {
    //Method returns the starting position to start the tour if tour cannot be completed then it returns -1
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        //Start point
        int startPoint = 0;

        //Sum of cost of the tour
        int totalDist = 0;

        //Required gas to complete the tour
        int totalFuel = 0;

        //If we cant complete a circle with current starting pos
        int deficit = 0;

        //Loop through both arrays
        for (int i = 0; i < gas.length; i++) {

            deficit += gas[i] - cost[i];
            totalDist += cost[i];
            totalFuel += gas[i];

            //If condition to update the starting position
            if (deficit < 0) {
                startPoint = i + 1;
                deficit = 0;
            }
        }

        //If the tour cannot be completed
        if (totalDist > totalFuel) {
            return -1;
        }

        //Tour completed with start point
        return startPoint;
    }
    public static void main(String[] args) {

        int gas[] = {1,2,3,4,5};
        int distance[] = {3,4,5,1,2};

        //Calculating if it is possible to do circular tour and return the start location
        int startingPos = canCompleteCircuit(gas, distance);

        //Printing the answer
        if (startingPos == -1) {
            System.out.println("There is no starting point to complete a circular tour");
        }else {
            System.out.println("Starting point of the tour: "+ startingPos);
        }
    }
}
