package Day2_100222;

import java.util.ArrayList;

public class T3_For_Loop_ArrayLIst {

    public static void main(String[] args) {

        //declare and define arrayList for zipcode
        ArrayList<String>zipCode = new ArrayList<>();

        zipCode.add("11208");
        zipCode.add("11416");
        zipCode.add("13161");
        zipCode.add("11415");
        zipCode.add("444517");
        zipCode.add("154252");

        //call for loop to print out all zipcode values from the array list
        //if you want to control the end point by number, then put actual number instead of zipcode.size()
        //for array list it uses  .size () to get the count of the list but liner array it uses  .length() to get the count of the list
        for (int i = 0; i < zipCode.size(); i++){

            //print out each zip code automatically
            System.out.println("zipcode : "+ zipCode.get(i));

        }//end of the for loop

    }//end of main method
}//end of class
