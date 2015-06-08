/**
 * Created by mafn on 5/28/15.
 */
public class IntLinkedList {
    public IntLink firstLink;
    protected int length;

    public IntLinkedList(IntLink firstLink){
        this.firstLink = firstLink;

        this.length = 1;
    }

    public void addLink(IntLink linkToAdd){
        linkToAdd.setNextLink(this.firstLink);
        this.firstLink.setPreviousLink(linkToAdd);
        this.firstLink = linkToAdd;

        this.length++;
    }

    public void addLink(int value){
        this.addLink(new IntLink(value));
    }

    public IntLink getIntLinkByValue(int value){
        for(IntLink currentLink = this.firstLink; currentLink != null; currentLink = currentLink.nextLink){
            if(currentLink.value == value){
                return currentLink;
            }
        }

        return null;
    }

    public IntLink getIntLink(int index){
        int linkCount = 0;

        for(IntLink currentLink = this.firstLink; currentLink != null; currentLink = currentLink.nextLink, linkCount++){
            if(linkCount == index){
                return currentLink;
            }
        }

        return null;
    }

    public void printContents(){
        for(int currentLinkIndex = 0; this.getIntLink(currentLinkIndex) != null; currentLinkIndex++){
            System.out.format("[%d] : %d\n", currentLinkIndex, this.getIntLink(currentLinkIndex).value);
        }
    }

    public void setLink(int index, int value){
        IntLink toSet = this.getIntLink(index);

        if(toSet != null){
            toSet.value = value;
        }
    }

    public void removeIntLinkFromList(int nestedIndex){
        if(nestedIndex == 0){
            //This is a special case, since we only need to change the linkedlist's reference!
            this.firstLink = this.firstLink.nextLink;
        } else{
            //We're dealing with a regular case, link the previous link to the next one
            IntLink previousLink = this.getIntLink(nestedIndex - 1);
            IntLink linkToRemove = this.getIntLink(nestedIndex);
            if(previousLink != null && linkToRemove != null) {
                previousLink.setNextLink(linkToRemove.nextLink);
            }
        }

        this.length--;
    }

    //Dit zit zwaar retarded in elkaar en is trager dan je oma op een scooter
    public void bubbleSort(){
        //Swap whilst incrementing the endIndex until it approaches the length
        for(int endIndex = 0; endIndex < this.length -1; endIndex++){
            //One swap routine(From end to endIndex)
            for(int currentIndex = this.length -1; currentIndex > endIndex; currentIndex--){
                if(this.getIntLink(currentIndex).value < this.getIntLink(currentIndex-1).value){
                    this.swapLinks(currentIndex, currentIndex-1);
                }
            }
        }
    }

    private void swapLinks(int swapIndex1, int swapIndex2){
        int copy = this.getIntLink(swapIndex1).value;
        this.getIntLink(swapIndex1).value = this.getIntLink(swapIndex2).value;
        this.getIntLink(swapIndex2).value = copy;
    }

    //Dit is minder retarded en is sneller dan je oma op een scooter
    public void efficientBubbleSort(){
        for(int endIndex = this.length-1; endIndex > 0; endIndex--){
            //One swap routine(From endIndex to 0)
            IntLink currentLink = this.firstLink;
            for(int currentIndex = 0; currentIndex < endIndex; currentIndex++){
                if(currentLink.value > currentLink.nextLink.value){
                    this.efficientSwapNext(currentLink);
                }
                currentLink = currentLink.nextLink;
            }
        }
    }

    public void efficientSwapNext(IntLink toSwap){
        int copy = toSwap.value;
        toSwap.value = toSwap.nextLink.value;
        toSwap.nextLink.value = copy;
    }

    public int length1(){
        int linkCount = 0;

        for(int currentLinkIndex = 0; this.getIntLink(currentLinkIndex) != null; currentLinkIndex++){
            linkCount++;
        }

        return linkCount;
    }

    public int length2(){
        return this.length;
    }
}
