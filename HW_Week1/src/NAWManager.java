import java.util.ArrayList;

/**
 * Created by mafn on 4/22/15.
 */

public class NAWManager {
    public NAW[] NAWList;

    public NAWManager(){
        this.NAWList = new NAW[20];

        for(int i = 0; i < 10; i++){
            this.NAWList[i] = new NAW();
        }
    }

    private int getIndexOfItemWithName(String nameToCheck){
        for(int i = 0; i < this.NAWList.length; i++){
            //Check if the instance actually exists
            if(this.NAWList[i] != null) {
                if (this.NAWList[i].nameEqualsTo(nameToCheck)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private Integer[] getIndexesOfItemWithName(String nameToCheck){
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        for(int i = 0; i < this.NAWList.length; i++){
            //Check if the instance actually exists
            if(this.NAWList[i] != null){
                if(this.NAWList[i].nameEqualsTo(nameToCheck)){
                    indexes.add(i);
                }
            }
        }

        return indexes.toArray(new Integer[indexes.size()]);
    }

    private int getIndexOfItemWithAddress(int addressToCheck){
        for(int i = 0; i < this.NAWList.length; i++){
            if(this.NAWList[i].addressEqualsTo(addressToCheck)){
                return i;
            }
        }

        return -1;
    }

    private int getIndexOfItemWithCityOfResidence(String cityOfResidenceToCheck){
        for(int i = 0; i < this.NAWList.length; i++){
            if(this.NAWList[i].cityOfResidenceEqualsTo(cityOfResidenceToCheck)){
                return i;
            }
        }

        return -1;
    }

    private int getIndexOfItemWithAddressAndCityOfResidence(int addressToCheck, String cityOfResidenceToCheck){
        for(int i = 0; i < this.NAWList.length; i++){
            if(this.NAWList[i] != null) {
                if (this.NAWList[i].cityOfResidenceEqualsTo(cityOfResidenceToCheck) && this.NAWList[i].addressEqualsTo(addressToCheck)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int binary_getClosestBound(String name, int address, String cityOfResidence){
        int middle, low = 0;
        int high = this.NAWList.length-1;

        while(low <= high){
            middle = (low + high) / 2;

            if(this.NAWList[middle].compareTo(name, address, cityOfResidence) == 0){
                //Item already exists!
                return -1;
            }

            if(this.NAWList[middle].compareTo(name, address, cityOfResidence) < 0){
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        System.out.println("Lowerbound = " + low);
        System.out.println("Upperbound = " + high);

        return low;
    }

    public void binary_addItem(String name, int address, String cityOfResidence){
        int index = this.binary_getClosestBound(name, address, cityOfResidence);

        if(index != -1){
            this.addItem(index, name, address, cityOfResidence);
        } else {
            System.out.println("Item already exists");
        }
    }

    public int binary_getIndexOfItem(String name, int address, String cityOfResidence){
        int middle, low = 0;
        int high = this.NAWList.length-1;

        while(low <= high){
            middle = (low + high) / 2;

            if(this.NAWList[middle].compareTo(name, address, cityOfResidence) == 0){
                return middle;
            }

            if(this.NAWList[middle].compareTo(name, address, cityOfResidence) < 0){
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        System.out.println("Lowerbound = " + low);
        System.out.println("Upperbound = " + high);

        return -1;
    }

    public void addItem(int index, String name, int address, String cityOfResidence){
        //Move everything past the point of insertion 1 index up
        System.arraycopy(this.NAWList, index, this.NAWList, index+1, (this.NAWList.length-1) - index);

        this.NAWList[index] = new NAW();
        this.NAWList[index].setName(name);
        this.NAWList[index].setAddress(address);
        this.NAWList[index].setCityOfResidence(cityOfResidence);
    }

    public void updateItem(int index, String name, int address, String cityOfResidence){
        if(index < this.NAWList.length - 1){
            this.NAWList[index].setName(name);
            this.NAWList[index].setAddress(address);
            this.NAWList[index].setCityOfResidence(cityOfResidence);
        }
    }

    public void binary_removeItemWithProperties(String name, int address, String cityOfResidence){
        int index = this.binary_getIndexOfItem(name, address, cityOfResidence);

        if(index != -1){
            this.removeItemWithIndex(index);
        } else {
            System.out.println("Couldn't find item, not removing anything");
        }
    }

    public void removeItemWithIndex(int index){
        //Stuff a new instance of NAW on the index(Which resets it's values to default)
        this.NAWList[index] = new NAW();

        //Move all elements one index downwards
        System.arraycopy(this.NAWList, index+1, this.NAWList, index, (this.NAWList.length-1) - index);
    }

    public boolean removeFirstItemWithName(String name){
        boolean success = false;

        int targetIndex = this.getIndexOfItemWithName(name);

        if(targetIndex != -1){
            this.removeItemWithIndex(this.getIndexOfItemWithName(name));
            success = true;
        }

        return success;
    }

    public boolean removeLastItemWithName(String name){
        boolean success = false;

        Integer[] targetIndexes = this.getIndexesOfItemWithName(name);

        if(targetIndexes.length > 0){
            this.removeItemWithIndex(targetIndexes[targetIndexes.length - 1]);
            success = true;
        }

        return success;
    }

    public boolean removeAllItemsWithName(String name){
        boolean success = false;

        int index = this.getIndexOfItemWithName(name);

        while(index != -1){
            success = true;
            this.removeItemWithIndex(index);

            index = this.getIndexOfItemWithName(name);
        }

        return success;
    }

    public boolean removeFirstItemWithAddressAndCityOfResidence(int address, String cityOfResidence){
        boolean success = false;

        int targetIndex = this.getIndexOfItemWithAddressAndCityOfResidence(address, cityOfResidence);

        if(targetIndex != -1){
            this.removeItemWithIndex(targetIndex);
            success = true;
        }

        return success;
    }

    //Incredibly long name...
    public boolean removeAllItemsWithAddressAndCityOfResidence(int address, String cityOfResidence){
        boolean success = false;

        int index = this.getIndexOfItemWithAddressAndCityOfResidence(address, cityOfResidence);

        while(index != -1){
            success = true;
            this.removeItemWithIndex(index);

            index = this.getIndexOfItemWithAddressAndCityOfResidence(address, cityOfResidence);
        }

        return success;
    }
}
