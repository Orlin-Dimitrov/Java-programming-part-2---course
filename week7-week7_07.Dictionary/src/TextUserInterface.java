
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dic;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dic = dictionary;
    }
    
    public void start() {
        System.out.println("Statements:\n" +
"  add - adds a word pair to the dictionary\n" +
"  translate - asks a word and prints its translation\n" +
"  quit - quits the text user interface");
        
        while(true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }
            
            else if (command.equals("add")) {
                System.out.println("In Finish: ");
                String key = reader.nextLine();
                System.out.println("Translation: ");
                String value = reader.nextLine();
                dic.add(key, value);
            }
            
            else if (command.equals("translate")) {
                System.out.println("Give a word: ");
                String word = reader.nextLine();
                System.out.println("Translation: " + dic.translate(word));
            }
            
            else {
                System.out.println("Unknown statement");
            }
        }
    }
    
}
