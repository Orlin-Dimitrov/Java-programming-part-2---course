/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dmitry
 */
public class MaxWeightBox extends Box {
    
    private int maxWeight;
    private List<Thing> things = new ArrayList<Thing>();

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
    
    
    @Override
    public void add(Thing thing) {
        int boxWeight = 0;
        for (Thing t : things) {
            boxWeight += t.getWeight();
        }
        boxWeight += thing.getWeight();
        if (boxWeight <= maxWeight) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(things.contains(thing)) {
            return true;
        }
        return false;
    }
    
}
