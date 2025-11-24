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
        myStringList.add("MULE");
        myStringList.add("HORSE");
        myStringList.add("SPARROW");
        myStringList.add("ELEPHANT");
        myStringList.add("SEAGULL");
        myStringList.add("GIRAFFE");
        myStringList.add("SEAL");
        myStringList.add("CHEETAH");
        List<String> myStringList2 = new ArrayList<String>();
        myStringList2.add("JOHN");
        myStringList2.add("DAVID");
        myStringList2.add("CAMERON");
        myStringList2.add("BILL");
        myStringList2.add("BOB");
        myStringList2.add("JERRY");
        myStringList2.add("MARY");
        myStringList2.add("JESSICA");
        List<String> myStringList3 = new ArrayList<String>();
        myStringList3.add("STEAK");
        myStringList3.add("PIZZA");
        myStringList3.add("PASTA");
        myStringList3.add("TOFU");
        myStringList3.add("SUSHI");
        myStringList3.add("RAMEN");
        myStringList3.add("CHICKEN");
        myStringList3.add("BURRITO");
        List<String> myStringList4 = new ArrayList<String>();
        myStringList4.add("RUSSIA");
        myStringList4.add("ISRAEL");
        myStringList4.add("MADAGASCAR");
        myStringList4.add("JAPAN");
        myStringList4.add("GERMANY");
        myStringList4.add("BRAZIL");
        myStringList4.add("BULGARIA");
        myStringList4.add("CHINA");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Welcome to 'The game formerly known as Hangman'!");
        System.out.println("Guess the randomized word by entering different letters.");
        System.out.println("Good luck!");
        System.out.println("Note: put keyboard on caps lock before playing");
        System.out.println("-------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Pick your category (type \"SEE CATEGORIES\" to see categories): ");
        String option = scan.nextLine();
        String chosenCategory = option;
        if (option.equals("SEE CATEGORIES")) {
            System.out.println(" ");
            System.out.println("CATEGORIES: ");
            System.out.println(">ANIMALS");
            System.out.println(">COUNTRIES");
            System.out.println(">FOOD");
            System.out.println(">COMMON NAMES");
            System.out.println(" ");
            System.out.print("Pick your category: ");
            chosenCategory = scan.nextLine();
        }
        String word = "";
        if (chosenCategory.equals("ANIMALS")) {
            word = myStringList.get(new Random().nextInt(myStringList.size()));
        }
        else if (chosenCategory.equals("COMMON NAMES")) {
            word = myStringList2.get(new Random().nextInt(myStringList2.size()));
        }
        else if (chosenCategory.equals("FOOD")) {
            word = myStringList3.get(new Random().nextInt(myStringList3.size()));
        }
        else if (chosenCategory.equals("COUNTRIES")) {
            word = myStringList4.get(new Random().nextInt(myStringList4.size()));
        }
        System.out.println(" ");
        String newString = "";
        String newStringLimited = limitString(newString, word.length());
        for (int i = 0; i < word.length(); i++){
            newStringLimited = newStringLimited + "_";
        }
        System.out.println(newStringLimited);
        char search = '_';
        while (newStringLimited.indexOf(search) != -1){
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
        }
        System.out.println(" ");
        return "You got it right! The correct word is " + word;
    }
}

