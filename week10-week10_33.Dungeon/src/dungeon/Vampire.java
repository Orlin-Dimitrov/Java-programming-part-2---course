/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Orlin
 */
public class Vampire extends BaseObject {

    private char[] dir = {'w', 's', 'a', 'd'};
    private Random rand = new Random();

    public Vampire(int x, int y) {
        super(x, y);
    }

    public void move(int length, int height, List<Vampire> vampList) {
        int tempX = x;
        int tempY = y;
        char direction = dir[rand.nextInt(4)];

        if (direction == 'w' && y - 1 >= 0) {
            y += -1;
        }
        if (direction == 's' && y + 1 < height) {
            y += 1;
        }
        if (direction == 'a' && x - 1 >= 0) {
            x += -1;
        }
        if (direction == 'd' && x + 1 < length) {
            x += 1;
        }

        for (Vampire v : vampList) {
            if (this.equals(v)) {
                continue;
            }
            if (this.isIntersec(v)) {
                x = tempX;
                y = tempY;
                break;
            }
        }
    }

    @Override
    public void draw(PlayField playfield) {
        playfield.SetPoint(x, y, 'v');
    }
}
