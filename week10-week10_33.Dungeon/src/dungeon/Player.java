/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Dmitry
 */
public class Player extends BaseObject {

    public Player(int x, int y) {
        super(x, y);
    }

    public void move(char direction) {
        if (direction == 'w') {
            if(y - 1 >= 0)
                y += -1;
        }
        else if (direction == 's') {
            if(y + 1 < Dungeon.game.getHeight())
                y += 1;
        }
        else if (direction == 'a') {
            if(x - 1 >= 0)
                x += -1;
        }
        else if (direction == 'd') {
            if(x + 1 < Dungeon.game.getLength())
                x += 1;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, '@');
    }
    
}
