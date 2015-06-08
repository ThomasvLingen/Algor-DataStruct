/**
 * Created by mafn on 5/27/15.
 */
public class NAWLink {
    public NAW linkItem;

    public NAWLink nextNAWLink;

    public NAWLink(NAW linkItem) {
        this.linkItem = linkItem;
    }

    public void setLink(NAWLink link){
        this.nextNAWLink = link;
    }

    public boolean hasLink(){
        return(this.nextNAWLink != null);
    }
}
