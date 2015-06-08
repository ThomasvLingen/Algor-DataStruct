/**
 * Created by mafn on 6/1/15.
 */
public class Main {

    public static void main(String[] args){
        //Cheesy way of making a multilined string in java
        String XMLAssignment =  "<persoon>"                             +
                                    "<naam>Donald duck</naam>"          +
                                    "<adres>Eendenstad</adres>"         +
                                    "<woonplaats>Duckstad</woonplaats>" +
                                "</persoon>";

        String faultyXML =  "<persoon>"                             +
                                "<naaam>Donald duck</naam>"          +
                                "<adres>Eendenstad</adres>"         +
                                "<woonplots>Duckstad</woonplaats>" +
                            "</persoon>";

        XMLValidator validator = new XMLValidator(XMLAssignment);
        XMLValidator validator2 = new XMLValidator(faultyXML);

        System.out.println(validator.tagsValid);
        System.out.println(validator2.tagsValid);
    }
}
