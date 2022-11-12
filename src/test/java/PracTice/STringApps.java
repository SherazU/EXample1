package PracTice;

public class STringApps {
    public static void main(String[] args) {

        String str ="Hello-welcome-to-Java-world";

        String parts[]= str.split("-");

        for(int i =0; i< parts.length;i++){
            System.out.println("------> "+ parts[i]);
        }//end of loop


    }//end of main
}//end of class
