import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Hangman {


    public static String limitString(String input, int maxInput){
        if (input.length() <= maxInput){
            return input;
        }
        return input.substring(0, maxInput);
    }

    public static String replaceChar(String str, int index, char newChar) {
        char[] chars = str.toCharArray();
        chars[index] = newChar;
        return new String(chars);
    }

    public static String hangman(){
        Scanner scan = new Scanner(System.in);
        List<String> myStringList = new ArrayList<String>();
        myStringList.add("PRIDE");
        myStringList.add("DOUGH");
        myStringList.add("BILL");
        myStringList.add("COACH");
        myStringList.add("HORSE");
        myStringList.add("SOAR");
        myStringList.add("LINE");
        myStringList.add("TOP");
//        String word = myStringList.get(new Random().nextInt(myStringList.size()));
        String word = "WORD";
        System.out.println("----------------------------------------------------");
        System.out.println("Welcome to 'The game formerly known as Hangman'!");
        System.out.println("You have 10 tries to guess the randomized word.");
        System.out.println("Good luck!");
        System.out.println("Note: put keyboard on caps lock before playing");
        System.out.println("----------------------------------------------------");
        System.out.println(" ");
        String newString = "";
        String newStringLimited = limitString(newString, word.length());
        for (int i = 0; i < word.length(); i++){
            newStringLimited = newStringLimited + "_";
        }
        System.out.println(newStringLimited);
        char search = '_';
        int count = 0;
        while ((newStringLimited.indexOf(search) != -1) || (count != 10)){
            System.out.println(" ");
            System.out.print("Enter letter: ");
            char letter = scan.next().charAt(0);
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == letter){
                    newStringLimited = replaceChar(newStringLimited, i, letter);
                }
            }
            System.out.println(" ");
            System.out.println(newStringLimited);
            count++;
        }
        System.out.println(" ");
        return "You got it right! The correct word is " + word;
    }
}

