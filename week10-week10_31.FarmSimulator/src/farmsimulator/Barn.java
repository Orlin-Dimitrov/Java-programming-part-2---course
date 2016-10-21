/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author Dmitry
 */
public class Barn {
    private BulkTank tank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        milkingRobot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow) {
        if(this.milkingRobot == null) {
            throw new IllegalStateException("The milking robot has not been installed");
        }
        milkingRobot.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        if(this.milkingRobot == null) {
            throw new IllegalStateException("The milking robot has not been installed");
        }
        
        for(Milkable cow : cows) {
            milkingRobot.milk(cow);
        }
    }

    @Override
    public String toString() {
        return tank.toString();
    }
    
    
}
