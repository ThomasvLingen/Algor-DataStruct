/**
 * Created by mafn on 6/1/15.
 */

//LOL DEZE SHIT WERKT NIET HELEMAAL WANT HAAST
public class IntLinkedListHistory extends IntLinkedList {

    public IntLink currentLink;

    public IntLinkedListHistory(IntLink firstLink){
        super(firstLink);
        this.currentLink = this.firstLink;
    }

    @Override
    public void addLink(IntLink linkToAdd){
        linkToAdd.setNextLink(this.currentLink);
        this.firstLink.setPreviousLink(linkToAdd);

        this.firstLink = linkToAdd;
        this.currentLink = this.firstLink;

        this.length++;
    }

    public void undo(){
        if(this.currentLink.nextLink != null){
            this.currentLink = this.currentLink.nextLink;
        } else {
            System.out.println("Can't undo stuff");
        }
    }

    public void redo(){
        if(this.currentLink != this.firstLink){
            this.currentLink = this.currentLink.previousLink;
        } else {
            System.out.println("Can't redo stuff");
        }
    }

    @Override
    public void printContents() {
        for(IntLink current = this.currentLink; current != null; current = current.nextLink){
            System.out.print(current.value + " - ");
        }
        System.out.println("");
    }
}
