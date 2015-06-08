/**
 * Created by mafn on 5/27/15.
 */
public class NAWLinkedList {
    public NAWLink firstLink;
    private int length;

    public NAWLinkedList(NAWLink firstLink){
        this.firstLink = firstLink;

        this.length = 1;
    }

    public void addLink(NAWLink linkToAdd){
        linkToAdd.setLink(this.firstLink);
        this.firstLink = linkToAdd;

        this.length++;
    }

    public NAWLink getNAWIndex(String name, int address, String cityOfResidence){
        for(NAWLink currentLink = this.firstLink; currentLink != null; currentLink = currentLink.nextNAWLink){
            if(currentLink.linkItem.compareTo(name, address, cityOfResidence) == 0){
                return currentLink;
            }
        }

        return null;
    }

    public void removeNAWFromList(int nestedIndex){
        if(nestedIndex == 0){
            //This is a special case, since we only need to change the linkedlist's reference!
            this.firstLink = this.firstLink.nextNAWLink;
        } else{
            //We're dealing with a regular case, link the previous link to the next one
            NAWLink previousLink = this.getLink(nestedIndex - 1);
            NAWLink linkToRemove = this.getLink(nestedIndex);
            if(previousLink != null && linkToRemove != null) {
                previousLink.setLink(linkToRemove.nextNAWLink);
            }
        }

        this.length--;
    }

    public NAWLink getLink(int indexToGet){
        int linkCount = 0;

        for(NAWLink currentLink = this.firstLink; currentLink != null; currentLink = currentLink.nextNAWLink, linkCount++){
            if(linkCount == indexToGet){
                return currentLink;
            }
        }

        return null;
    }

    public void removeNAWLinks(String name, int address, String cityOfResidence){
        int currentLinkIndex = 0, removedItems = 0;

        for(NAWLink currentLink = this.firstLink; currentLink != null; currentLink = currentLink.nextNAWLink, currentLinkIndex++){
            if(currentLink.linkItem.compareTo(name, address, cityOfResidence) == 0){
                this.removeNAWFromList(currentLinkIndex);
                currentLinkIndex -= 1;
                this.length -= 1;
                //Since we're removing a link, naturally our currently link must be decreased as well
                removedItems++;
            }
        }

        System.out.println(removedItems + " NAWLinks removed");
    }


    public void removeNAWLinks2(String name, int address, String cityOfResidence){
        int removedItems = 0;

        for(int currentLinkIndex = 0; this.getLink(currentLinkIndex) != null; currentLinkIndex++){
            if(this.getLink(currentLinkIndex).linkItem.compareTo(name, address, cityOfResidence) == 0){
                this.removeNAWFromList(currentLinkIndex);
                currentLinkIndex -= 1;
                this.length -= 1;
                //Since we're removing a link, naturally our currently link must be decreased as well
                removedItems++;
            }
        }

        System.out.println(removedItems + " NAWLinks removed");
    }

    public void printContents(){
        //For some reason I'm unable to declare 2 differently typed variables in the initialisation of 1 for loop
        int linkCount = 0;
        for(NAWLink currentLink = this.firstLink; currentLink != null; currentLink = currentLink.nextNAWLink, linkCount++){
            System.out.format("Link %d: %s - %s:%d\n", linkCount, currentLink.linkItem.getName(), currentLink.linkItem.getCityOfResidence(), currentLink.linkItem.getAddress());
        }
    }

    public int length1(){
        int linkCount = 0;

        for(int currentLinkIndex = 0; this.getLink(currentLinkIndex) != null; currentLinkIndex++){
            linkCount++;
        }

        return linkCount;
    }

    public int length2(){
        return this.length;
    }
}
