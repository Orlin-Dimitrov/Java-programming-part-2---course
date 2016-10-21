/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dmitry
 */
public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private List<Cow> cows = new ArrayList<Cow>();

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
    }

    public String getOwner() {
        return owner;
    }
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }

    @Override
    public String toString() {
        String cow;
        if (cows.size() == 0) {
            cow = "No cows.";
        }
        else {
            cow = "Animals:\n";
            for(Milkable m : cows) {
                cow += "        " + m.toString() + "\n";
            }
        }
        return "Farm owner: " + owner + "\nBarn bulk tank: " + barn.toString() + "\n" + cow;
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }

    @Override
    public void liveHour() {
        for (Cow m : cows) {
            m.liveHour();
        }
    }
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    
    
}
