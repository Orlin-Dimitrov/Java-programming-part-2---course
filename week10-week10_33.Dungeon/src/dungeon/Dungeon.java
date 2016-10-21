/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dmitry
 */
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Player player = new Player(0, 0);
    private List<Vampire> vampList = new ArrayList<Vampire>();
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
    }
    
     public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getMoves() {
        return moves;
    }
    
    public void printPositions() {
        System.out.println(moves + "\n");
        System.out.println("@ " + player.getX() + " " + player.getY());
        for(Vampire v : vampList) {
            System.out.println("v " + v.getX() + " " + v.getY());
        }
        System.out.println();
    }

    public List<Vampire> getVampList() {
        return vampList;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void createVampires() {
        for(int i = 0; i < vampires; i++) {
            int x = new Random().nextInt(length - 1) + 1;
            int y = new Random().nextInt(height - 1) + 1;
            vampList.add(new Vampire(x, y));
        }
    }
    
    public void draw(Canvas canvas) {
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < height; j++)
            {
                canvas.setPoint(i, j, '.');
            }
        }
        
        for(BaseObject o : getVampList()){
            o.draw(canvas);
        }
        
        player.draw(canvas);
    }
    
    public void moveVampires() {
        for(Vampire v : getVampList()) {
            v.move();
        }
    }
    
    public void checkVampires() {
        for(Vampire v : getVampList()) {
            if(v.isIntersec(player)) {
                v.die();
            }
        }
    }
    
    public void removeDead() {
        for(Vampire v : new ArrayList<Vampire>(vampList)) {
            if(!v.isAlive()) {
                vampList.remove(v);
            }
        } 
    }
    
    public void run() {
        Canvas canvas = new Canvas(length, height);
        createVampires();
        printPositions();
        draw(canvas);
        canvas.print();
        
        while(moves > 0) {
            String command = Console.readCommand();
            int steps = command.length();
            for(int i = 0; i < steps; i++) {
                player.move(command.charAt(i));
                for(Vampire v : vampList) {
                    v.move();
                }
                checkVampires();
                removeDead();
            }
            
            if(vampList.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
                        
            moves--;
            printPositions();
            canvas.clear();
            draw(canvas);
            canvas.print();
            
        }
        
        if(!vampList.isEmpty())
            System.out.println("YOU LOSE");
    }
    
    public static Dungeon game;
    public static void main(String[] args) {
        //new Dungeon(10,10,5,14,true).run();
        game = new Dungeon(5, 5, 5, 5, true);
        game.run();
    }
    
    
}
