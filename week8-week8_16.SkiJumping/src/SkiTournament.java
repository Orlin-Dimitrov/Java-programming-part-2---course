
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class SkiTournament {
    private List<Jumper> jumpers = new ArrayList<Jumper>();
    private Random random = new Random();
    private int lenRange = 120 - 60 + 1;
    private int voteRange = 20 - 10 + 1;
    private int minLen = 60;
    private int minVote = 10;
    
    public void addJumper(String name) {
        jumpers.add(new Jumper(name));
    }
    
    public void printJumpOrder() {
        Collections.sort(jumpers);
        int i = 1;
        System.out.println("Jumping order:");
        for (Jumper j : jumpers) {
            System.out.print("  " + i + ". ");
            System.out.println(j);
            i++;
        }
        System.out.println();
    }
    
    public void makeJump() {
        for (Jumper jumper : jumpers) {
            int randLen = random.nextInt(lenRange) + minLen;
            jumper.addJump(randLen);
            
            int[] tempVotes = new int[5];
            for (int i = 0; i < 5; i++) {
                int randVote = random.nextInt(voteRange) + minVote;
                tempVotes[i] = randVote;
            }
            jumper.setVotes(tempVotes);
        }
    }
    
    public void printJumpResult() {
        for (Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName());
            System.out.println("    length: " + jumper.getLenght().get(jumper.getLenght().size() - 1));
            System.out.println("    judge votes: " + Arrays.toString(jumper.getVotes()));
        }
        System.out.println();
    }
    
    public void printFinalResult() {
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        System.out.println("Position    Name");
        int i = 1;
        for (Jumper jumper : jumpers) {
            System.out.print(i + "           ");
            System.out.println(jumper);
            System.out.print("            jump lengths: ");
            for (Integer len : jumper.getLenght()) {
                if (len == jumper.getLenght().get(jumper.getLenght().size() - 1))
                    System.out.print(len + " m");
                else
                    System.out.print(len + " m, ");
            }
            i++;
            System.out.println();
        }
        
    }
    
    public void updatePoints() {
        for (Jumper jumper : jumpers) {
            int index = jumper.getLenght().size() - 1;
            int lastJumpLength = jumper.getLenght().get(index);
            int[] votes = jumper.getVotes();
            Arrays.sort(votes);
            int pointsForJump = lastJumpLength + votes[1] + votes[2] + votes[3];
            jumper.setPoints(jumper.getPoints() + pointsForJump);
        }
    }
}
