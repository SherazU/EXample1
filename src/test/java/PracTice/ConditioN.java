package PracTice;

public class ConditioN {

    public static void main(String[] args) {

        int temp =2;


        if (temp > 30) {//false
            System.out.println("Its a hot day!");
            System.out.println("drink water!");
        }//end of if condition
        else if (temp > 20 && temp <= 30) {//&&=and //false
            System.out.println("Beautiful day");
        }//end of else if condition statement
        else {
            System.out.println("cold day");
        }//end of else statement

    }//end of main
}//end of class
