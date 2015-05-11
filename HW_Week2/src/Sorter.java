/**
 * Created by mafn on 5/11/15.
 */
public class Sorter {

    public static void bubblesortArray(int[] toSort){
        //Swap while incrementing the endindex until it approaches the length
        for(int endIndex = 0; endIndex < toSort.length-1; endIndex++){
            //One swap routine(From end to endIndex)
            for(int currentIndex = toSort.length-1; currentIndex > 0; currentIndex--){
                if(toSort[currentIndex] < toSort[currentIndex-1]){
                    swapArrayItems(toSort, currentIndex, currentIndex-1);
                }
            }
        }
    }

    private static void swapArrayItems(int[] toSwap, int swapIndex1, int swapIndex2){
        int copy = toSwap[swapIndex1];
        toSwap[swapIndex1] = toSwap[swapIndex2];
        toSwap[swapIndex2] = copy;
    }

    public static void bubblesortNAWArray_FullCompare(NAW[] toSort){
        int inner, outer;
        NAW copy;

        for(outer = toSort.length-1; outer > 0; outer--){
            for(inner=0; inner < outer; inner++){
                if(toSort[inner].compareTo(toSort[inner+1]) >= 0){
                    copy = toSort[inner];
                    toSort[inner] = toSort[inner+1];
                    toSort[inner+1] = copy;
                }
            }
        }
    }

    public static void bubblesortNAWArray_split(NAW[] toSort){
        int inner, outer;
        NAW copy;

        //Sort by address
        for(outer = toSort.length-1; outer > 0; outer--){
            for(inner=0; inner < outer; inner++){
                if(toSort[inner].getAddress() - toSort[inner+1].getAddress() > 0){
                    copy = toSort[inner];
                    toSort[inner] = toSort[inner+1];
                    toSort[inner+1] = copy;
                }
            }
        }

        //Sort by cityOfResidence
        for(outer = toSort.length-1; outer > 0; outer--){
            for(inner=0; inner < outer; inner++){
                if(toSort[inner].getCityOfResidence().compareTo(toSort[inner + 1].getCityOfResidence()) > 0){
                    copy = toSort[inner];
                    toSort[inner] = toSort[inner+1];
                    toSort[inner+1] = copy;
                }
            }
        }
    }

    public static void selectionSortArray(int[] toSort){
        long start_time = System.nanoTime();
        for(int currentPlacementIndex = toSort.length-1; currentPlacementIndex >= 0; currentPlacementIndex--){
            int highestIndex = currentPlacementIndex;

            for(int currentIndex = 0; currentIndex < currentPlacementIndex; currentIndex++){
                if(toSort[currentIndex] > toSort[highestIndex]){
                    highestIndex = currentIndex;
                }
            }

            swapArrayItems(toSort, currentPlacementIndex, highestIndex);
        }
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println("time taken: " + difference);
    }
}
