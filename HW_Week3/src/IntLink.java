/**
 * Created by mafn on 5/28/15.
 */
public class IntLink {
    int value;
    IntLink nextLink;
    IntLink previousLink;

    public IntLink(int value){
        this.value = value;
    }

    public void setNextLink(IntLink toSet){
        this.nextLink = toSet;
    }

    public void setPreviousLink(IntLink toSet){
        this.previousLink = toSet;
    }
}
