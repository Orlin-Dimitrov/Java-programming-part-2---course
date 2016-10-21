
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
public class UserInterface {
    private SkiTournament game;
    private Scanner reader;

    public UserInterface(SkiTournament game, Scanner reader) {
        this.game = game;
        this.reader = reader;
    }
    
    public void startTournament() {
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        while(true) {
            System.out.print("  Participant name: ");
            String jumperName = reader.nextLine();
            if (jumperName.isEmpty())
                break;
            game.addJumper(jumperName);
        }
        System.out.println();
        
        System.out.println("The tournament begins!\n");
        int i = 1;
        while(true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            if (!(command.equals("jump")))
                break;
            System.out.println("\nRound " + i + "\n");
            game.printJumpOrder();
            game.makeJump();
            
            System.out.println("Results of round " + i);
            game.printJumpResult();
            game.updatePoints();
            i++;
        }
        
        System.out.println("\nThanks!\n\nTournament results:");
        game.printFinalResult();
    }
}
