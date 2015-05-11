/**
 * Created by mafn on 4/22/15.
 */
public class Main {

    public static void main(String [ ] args) {
        NAWManager test = new NAWManager();

        for(int i = 0; i < 10; i++){
            test.NAWList[i].setName("Naam " + i);
            test.NAWList[i].setAddress(i);
            test.NAWList[i].setCityOfResidence("Stad " + i);
        }

        test.binary_addItem("Naam 2", 1, "Stad 2");
    }

    //Lowerbound and Upperbound values
    //
    //0:  0, -1
    //2:  1, 0
    //4:  2, 1
    //5:  2, 1
    //23: 6, 5
    //26: 6, 5
    //30: 7, 6
    //Relatie is dus dat lower en upperbound de 2 getallen zijn die het dichst grenzen aan het getal dat gezocht wordt
}
