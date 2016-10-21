/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;

/**
 *
 * @author Dmitry
 */
public class Console {
    private static Scanner reader = new Scanner(System.in);
    
    public static String readCommand() {
        return reader.nextLine();
    }
}
