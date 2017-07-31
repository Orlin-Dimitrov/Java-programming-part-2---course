/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Orlin
 */
public class Player extends BaseObject {

    public Player(int x, int y) {
        super(x, y);
    }

    public void move(char button, int lenght, int height) {
        if (button == 'w') {
            if (y - 1 >= 0) {
                y += -1;
            }
        }
        if (button == 's') {
            if (y + 1 < height) {
                y += 1;
            }
        }
        if (button == 'a') {
            if (x - 1 >= 0) {
                x += -1;
            }
        }
        if (button == 'd') {
           if (x + 1 < lenght){
                x += 1;
            }
        }
    }

    @Override
    public void draw(PlayField playfield) {
        playfield.SetPoint(x, y, '@');
    }

}
