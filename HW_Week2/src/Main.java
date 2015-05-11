import java.util.Random;

/**
 * Created by mafn on 5/11/15.
 */
public class Main {

    public static void main(String args[]){
        int size = 100;
        Random RNG = new Random();

        //Populate array
        int[] testArray = new int[size];
        for(int i = 0; i < size; i++){
            testArray[i] = RNG.nextInt(10);
        }

        //Measure time and sort
        /*long start_time = System.nanoTime();*/
         Sorter.selectionSortArray(testArray);
        /*long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;*/

/*        //Print result
        System.out.println("Time taken in ms: " + difference);*/
        for(int i = 0; i < size; i++){
            System.out.print(testArray[i]);
        }
        System.out.println();
    }

}
