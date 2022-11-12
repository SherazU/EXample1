package Day2_100222;

import java.util.ArrayList;

public class T2_Arraylist {

    public static void main(String[] args) {

        //choose java.util library from the suggestion when you type ArrayList
        //define and declare ArrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("india");

        //print usa from the countries list
        System.out.println(" Countries value: " + countries.get(0));

        //get all the count of the countries list
        System.out.println("Countries count is : " + countries.size());


        //call integer arrayList from StreetNumber
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(222);
        streetNumber.add(333);
        streetNumber.add(444);
        streetNumber.add(555);

        //print from streetNumber list
        System.out.println("First street Number is: " + streetNumber.get(0));

        //get count from streetNumber list
        System.out.println(" Street number count is: " + streetNumber.size());

    }//end of main method
}//end of class
