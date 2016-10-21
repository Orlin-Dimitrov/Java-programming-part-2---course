/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author Dmitry
 */
public class Vampire extends BaseObject {
    
    private char[] dir = {'w', 's', 'a', 'd'};
    private Random rand = new Random();

    public Vampire(int x, int y) {
        super(x, y);
    }
    
    public void move() {
        int tempX = x;
        int tempY = y;
        char direction = dir[rand.nextInt(4)];
        if (direction == 'w' && y - 1 >= 0) {
            y += -1;
        }
        else if (direction == 's' && y + 1 < Dungeon.game.getHeight()) {
            y += 1;
        }
        else if (direction == 'a' && x - 1 >= 0) {
            x += -1;
        }
        else if (direction == 's' && x + 1 < Dungeon.game.getLength()) {
            x += 1;
        }
        
        for(Vampire v : Dungeon.game.getVampList()) {
            if(this.equals(v)) {
                continue;
            }
            if(this.isIntersec(v)) {
                x = tempX;
                y = tempY;
                break;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'v');
    }
    
}
