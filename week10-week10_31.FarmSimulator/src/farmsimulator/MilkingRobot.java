/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Dmitry
 */
public class MilkingRobot {
    private BulkTank tank;

    public BulkTank getBulkTank() {
        if(this.tank == null) {
            return null;
        }
        return tank;
    }

    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }
    
    public void milk(Milkable milkable) {
        if(tank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        double milk = milkable.milk();
        tank.addToTank(milk);
    }
}
