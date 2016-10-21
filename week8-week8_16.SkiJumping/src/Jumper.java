
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Jumper implements Comparable<Jumper> {
    private String name;
    private int points = 0;
    private List<Integer> lenght = new ArrayList<Integer>();
    private int[] votes = new int[5];

    public Jumper(String name) {
        this.name = name;
    }
        
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public List<Integer> getLenght() {
        return lenght;
    }

    public int[] getVotes() {
        return votes;
    }
        
    public void setPoints(int points) {
        this.points = points;
    }

    public void setVotes(int[] votes) {
        this.votes = votes;
    }
    
    public void addJump(int len) {
        lenght.add(len);
    }
    
    public int compareTo(Jumper o) {
        return this.points - o.getPoints();
    }
    
    public String toString() {
        return name + " (" + points + " points)";
    }
    
}
