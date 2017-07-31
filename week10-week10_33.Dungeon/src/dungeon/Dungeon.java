/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Orlin
 */
public class Dungeon {

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Player player = new Player(0, 0);
    private List<Vampire> vampList = new ArrayList<Vampire>();
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.reader = new Scanner(System.in);
    }

    public void printPositions() {
        System.out.println(moves + "\n");
        System.out.println("@ " + player.getX() + " " + player.getY());
        for (Vampire v : vampList) {
            System.out.println("v " + v.getX() + " " + v.getY());
        }
        System.out.println("");
    }

    public void createVampires() {
        for (int i = 0; i < this.vampires; i++) {
            int x = new Random().nextInt((this.length - 1) + 1);
            int y = new Random().nextInt((this.height - 1) + 1);
            Vampire v = new Vampire(x, y);
            this.vampList.add(v);
        }
    }

    public void draw(PlayField playField) {
        for (int h = 0; h < this.height; h++) {
            for (int l = 0; l < this.length; l++) {
                playField.SetPoint(l, h, '.');
            }
        }
        for (BaseObject v : this.vampList) {
            v.draw(playField);
        }
        player.draw(playField);
    }

    public void moveVampires() {
        for (Vampire v : this.vampList) {
            v.move(length, height, vampList);
        }
    }

    public void checkVampires() {
        for (Vampire v : this.vampList) {
            if (v.isIntersec(player)) {
                v.die();
            }
        }
    }

    public void removeDead() {
        List<Vampire> toRemove = new ArrayList<Vampire>();
        for (Vampire v : this.vampList) {
            if (!v.isAlive()) {
                toRemove.add(v);
            }
        }
        this.vampList.removeAll(toRemove);
    }

    public void run() {

        PlayField playfield = new PlayField(length, height);
        createVampires();
        printPositions();
        draw(playfield);
        playfield.PrintPlayField();

        while (moves > 0) {
            String command = reader.nextLine();
            int steps = command.length();
            for (int i = 0; i < steps; i++) {
                player.move(command.charAt(i), length, height);

                if (this.vampiresMove) {
                    moveVampires();
                }
                checkVampires();
                removeDead();
            }

            if (vampList.isEmpty()) {
                System.out.println("YOU WIN!");
                break;
            }

            moves--;
            printPositions();
            playfield.Clear();
            draw(playfield);
            playfield.PrintPlayField();
        }

        if (!vampList.isEmpty()) {
            System.out.println("YOU LOSE");
        }
    }
}
