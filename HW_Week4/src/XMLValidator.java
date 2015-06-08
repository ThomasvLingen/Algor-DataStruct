/**
 * Created by mafn on 6/1/15.
 */
public class XMLValidator {
    private StringStack tagStack;

    private State currentState;

    String XML;

    boolean tagsValid = false;

    private enum State {
        EndTag, BeginTag
    }

    public XMLValidator(String XML){
        this.tagStack = new StringStack(100);

        this.XML = XML;
        this.currentState = State.EndTag;

        this.stackify();
        this.validate();
    }

    public void stackify(){
        boolean stackifiedPart = true;

        while(stackifiedPart){
            stackifiedPart = stackifyStep();
        }
    }

    public boolean stackifyStep(){
        if(this.currentState == State.EndTag){
            int tagStart = XML.indexOf("<");
            if(tagStart != -1){
                this.XML = XML.substring(tagStart+1);
                this.currentState = State.BeginTag;
                return true;
            } else {
                return false;
            }
        }

        if(this.currentState == State.BeginTag){
            int tagEndIndex = this.XML.indexOf(">");
            if(tagEndIndex != -1){
                this.tagStack.push(this.XML.substring(0, tagEndIndex));
                this.XML = XML.substring(tagEndIndex+1);
                this.currentState = State.EndTag;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //Later more can be added to this(For example brace checking)
    public void validate(){
        this.tagsValid = validateTags();
    }

    public boolean validateTags(){
        StringStack validationStack = new StringStack(100);

        while(!this.tagStack.isEmpty()){
            if(this.tagStack.peek().charAt(0) == '/'){
                validationStack.push(this.tagStack.pop());
            } else if(this.tagStack.peek().equals(validationStack.peek().substring(1))){
                this.tagStack.pop();
                validationStack.pop();
            } else{
                this.tagStack.pop();
            }
        }

        return(validationStack.isEmpty());
    }
}
