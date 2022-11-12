package ActionItems;
import java.util.ArrayList;
/*Using String country & int countryCode with for loop and ArrayList create at least 4 data for each variable and iterate through each to print out the i for both
variables.For instance, System.out.printin("My country is " + country.get(i) + " and my country code is 3I + countryCode.get(i));*/
public class ActionItem1A {
    public static void main(String[] args) {
        //arraylist for country code variable
        ArrayList<Integer> countryCode = new ArrayList<>();
        //arraylist for country variable
        ArrayList<String> country = new ArrayList<>();
        //added for country arraylist
        country.add("USA");
        country.add("Bangladesh");
        country.add("China");
        country.add("Japan");
        //added to country code arraylist
        countryCode.add(1);
        countryCode.add(4);
        countryCode.add(7);
        countryCode.add(8);
        //call for loop to print all country values
        for(int i =0; i<country.size();i++) {
            //print out each country as well as all country-code in one statement automatically
            System.out.println("My country is " + country.get(i) + " and my country is " + countryCode.get(i));
        }
    }//end of main method
}//end of class
