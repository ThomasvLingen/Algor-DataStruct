import java.util.EmptyStackException;

/**
 * Created by mafn on 6/1/15.
 */
public class StringStack {
    private String[] stack;
    private int size;
    private int stackPointer;

    public StringStack(int size){
        this.stack = new String[size];
        this.size = size;

        this.stackPointer = -1;
    }

    public boolean isFull(){
        return(this.stackPointer > this.size);
    }

    public boolean isEmpty(){
        return(this.stackPointer < 0);
    }

    public void push(String toPush){
        if(!this.isFull()){
            this.stackPointer++;
            this.stack[stackPointer] = toPush;
        } else {
            throw new StackOverflowError();
        }
    }

    public String pop(){
        if(!this.isEmpty()){
            String toReturn = this.stack[stackPointer];

            this.stack[stackPointer] = "";
            this.stackPointer--;

            return toReturn;
        } else {
            throw new EmptyStackException();
        }
    }

    public String peek(){
        if(!this.isEmpty()){
            return(this.stack[stackPointer]);
        } else {
            throw new EmptyStackException();
        }
    }
}
