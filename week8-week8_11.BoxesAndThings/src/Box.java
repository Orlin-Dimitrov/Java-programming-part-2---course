
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Box implements ToBeStored{
    private double maxW;
    private ArrayList<ToBeStored> list;

    public Box(double maxW) {
        this.maxW = maxW;
        this.list = new ArrayList<ToBeStored>();
    }
    
    public double weight() {
        double listWeight = 0;
        for (ToBeStored t : list) {
            listWeight += t.weight();
        }
        return listWeight;
    }
    
    public void add(ToBeStored thing) {
        double temp = weight();
        if (temp + thing.weight() <= maxW) {
            list.add(thing);
        }
    }

    @Override
    public String toString() {
        return "Box: " + list.size() + " things, total weight " + weight() + " kg";
    }
    
    
    
    
}
