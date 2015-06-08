import java.util.Random;

/**
 * Created by mafn on 5/11/15.
 */
public class Main {

    public static void main(String args[]){
        int[] testArray = {7, 3, 8, 1, 2, 5, 4, 6, 9, 0};

        Sorter.insertionSortArray(testArray);

        for(int i = 0; i < testArray.length; i++){
            System.out.print(testArray[i]);
        }
        System.out.println();
    }

}
