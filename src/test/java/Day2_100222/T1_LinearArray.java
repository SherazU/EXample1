package Day2_100222;

public class T1_LinearArray {

    public static void main(String[] args) {

        //declare string variable

        String[] zipCode, streetNumber;


        //define zipcode values for the string array
        zipCode = new String[]{"11218" , "11222" , "10001" , "11377"};
                        //Array index start from 0,1,2,3,4 etc.

        //define streetNumber values for string array
        streetNumber = new String[]{ "222" , "333" , "444" , "555"};


        //print a value from zipcode. Array always starts from 0 index
        System.out.println("ZipCode: " + zipCode[3]);
        System.out.println("StreetNumber is " + streetNumber[3]);

        //printing both in the sametime
        System.out.println( "ZipCode : " + zipCode[2] + " " + "& StreetNumber is " + streetNumber[3]);

    }//end of main method
}//end of class
