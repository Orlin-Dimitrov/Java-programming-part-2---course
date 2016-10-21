
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
public class Reader {
    
    private Scanner scan = new Scanner(System.in);
    
    public String readString() {
        String line = scan.nextLine();
        return line;
    }
    
    public int readInteger() {
        String temp = scan.nextLine();
        int number = Integer.parseInt(temp);
        return number;
    }
    
}
