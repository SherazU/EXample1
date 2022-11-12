package ActionItems;
/*Using Array(linear & ArrayList) and loops. I want you to create sets of data and iterate through the data and print out the result*/
import java.util.ArrayList;
public class ActionItem1 {
    public static void main(String[] args) {
        //declare int array variable
        int[] iD;
        //define id variable for int array
        iD = new int[]{13, 12, 14, 16,17};
        //iterate id array with for loop
        for ( int i =0; i <iD.length; i++){
            //print out all id automatically
            System.out.println("Id number is: " + iD[i]);
        }//end of for loop
        //declare & define arraylist for string variable names
        ArrayList<String>names = new ArrayList<>();
        names.add("David");
        names.add("John");
        names.add("Joe");
        names.add("Shay");
        //set the initializer
        int a=0;
        //set condition for while loop
        while (a< names.size()) {
            System.out.println("Names are: " + names.get(a));
            //incrementation for the while loop
            a++;
        }//end of while loop
    }//end if main method
}//end of class
