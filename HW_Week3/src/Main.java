import java.util.Random;

/**
 * Created by mafn on 5/27/15.
 */
public class Main {

    public static void main(String[] args){
        IntLinkedListHistory hallo = new IntLinkedListHistory(new IntLink(1));
        hallo.addLink(2);
        hallo.addLink(3);
        hallo.addLink(4);
        hallo.addLink(5);

        hallo.printContents();
        hallo.undo();
        hallo.printContents();
        hallo.redo();
        hallo.printContents();
        hallo.undo();
        hallo.printContents();
        hallo.addLink(1010);
        hallo.printContents();
        hallo.undo();
        hallo.printContents();
    }

}
