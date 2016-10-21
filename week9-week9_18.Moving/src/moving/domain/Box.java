/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dmitry
 */
public class Box implements Thing {
    private int maximumCapacity;
    private List<Thing> things = new ArrayList<Thing>();
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }
    
    public boolean addThing(Thing thing) {
        if (thing.getVolume() + getVolume() <= maximumCapacity) {
            things.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (Thing thing : things) {
            totalVolume += thing.getVolume();
        }
        return totalVolume;
    }
    
    
}
