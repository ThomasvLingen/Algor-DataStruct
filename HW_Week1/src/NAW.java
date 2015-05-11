/**
 * Created by mafn on 4/22/15.
 */
public class NAW {
    private String name;
    private int address;
    private String cityOfResidence;

    public NAW(){
        this.name = "Default";
        this.address = 1010;
        this.cityOfResidence = "Default";
    }

    public String getName(){
        return this.name;
    }

    public String getCityOfResidence(){
        return this.cityOfResidence;
    }

    public int getAddress(){
        return this.address;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(int address){
        this.address = address;
    }

    public void setCityOfResidence(String cityOfResidence){
        this.cityOfResidence = cityOfResidence;
    }

    public boolean nameEqualsTo(String nameToCheck){
        return this.name.equals(nameToCheck);
    }

    public boolean addressEqualsTo(int addressToCheck){
        return this.address == addressToCheck;
    }

    public boolean cityOfResidenceEqualsTo(String addressToCheck){
        return this.cityOfResidence.equals(addressToCheck);
    }

    public int compareTo(String name, int address, String cityOfResidence){
        NAW toCompare = new NAW();

        toCompare.setName(name);
        toCompare.setAddress(address);
        toCompare.setCityOfResidence(cityOfResidence);

        return this.compareTo(toCompare);
    }

    public int compareTo(NAW toCompare){
        int cityOfResidenceCompare = this.cityOfResidence.compareTo(toCompare.cityOfResidence);
        int addressCompare = this.address - toCompare.address;
        int nameCompare = this.name.compareTo(toCompare.name);

        //Order of importance isn't defined by the assignment, so I've defined it as follows:
        //cityOfResidence - address - name
        if(cityOfResidenceCompare != 0){
            return cityOfResidenceCompare;
        }
        if(addressCompare != 0){
            return addressCompare;
        }
        if(nameCompare != 0){
            return nameCompare;
        }
        //If we've reached this point, it's safe to say that we're dealing with 2 equal objects
        return 0;
    }
}
