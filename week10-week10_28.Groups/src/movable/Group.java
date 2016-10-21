/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dmitry
 */
public class Group implements Movable {
    
    private List<Movable> list = new ArrayList<Movable>();
    
    public void addToGroup(Movable movable) {
        list.add(movable);
    }
    
    public String toString() {
        String s = "";
        for(Movable m : list) {
            s += m.toString() + "\n";
        }
        return s;
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable m : list) {
            m.move(dx, dy);
        }
    }
    
}
