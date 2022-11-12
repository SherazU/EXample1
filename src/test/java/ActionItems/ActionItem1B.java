package ActionItems;
/* Using String[] region & int[] areaCode with while loop and linear array
create at least 4 data for each variable and iterate through each to print out the i for both variables.
For instance, System.out.printIn("My region is
" + region!] +
" and my area code is " + areaCode li]);*/

public class ActionItem1B {
    public static void main(String[] args) {
        //declare string variable
        String[] region;
//declare int variable
        int[] areaCode;
        //define region values for the linear string array
        region = new String[]{"Brooklyn", "Jersey", "Queens", "Bronx"};
        //define areaCode values for the linear int array
        areaCode = new int[]{1,2,3,4};
        //iterate through region and areaCode with variable i
        int i = 0;
        //now set condition for while loop
        //linear array gets the count by using .length command
        while ( i < region.length){
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
            //incrementation goes at the end of while loop
            i++;

        }//end of while loop
    }//end of main method
}//end of class
