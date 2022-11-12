package PracTice;
/* Create a list of words and combine them with a space in between.
Example: if you had: "Hello","my","name","is" we want it to be
"Hello my name is"*/

import java.util.ArrayList;

public class Practice100722 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();

        words.add("Hello");
        words.add("my");
        words.add("name");
        words.add("is");
String temp;
temp = "";
        for (int i = 0; i<words.size(); i++) {
          temp = temp+ words.get(i) + " ";

        }
       System.out.println(temp);

    }//end of main method
}//end of class
