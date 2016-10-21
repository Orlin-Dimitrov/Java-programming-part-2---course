
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write test code here
        Scanner reader = new Scanner(System.in);
        System.out.print("Give a string: ");
        String s = reader.nextLine();
        clockTime(s);
        
    }
    
    public static boolean isAWeekDay(String string) {
        if(string.matches("mon|tue|wed|thu|fri|sat|sun")){
            System.out.println("The form is fine.");
            return true;
        } else {
            System.out.println("The form is wrong.");
            return false;
        }
    }
    
    public static boolean allVowels(String string) {
        if(string.matches("(a|e|i|o|u|y|ä|ö)*")){
            System.out.println("The form is fine.");
            return true;
        } else {
            System.out.println("The form is wrong.");
            return false;
        }
    }
    
     public static boolean clockTime(String string) {
         
            if(string.matches("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")) {
                System.out.println("The form is fine.");
                return true;
            } else {
                System.out.println("The form is wrong.");
                return false;
            }
         
     }
}
