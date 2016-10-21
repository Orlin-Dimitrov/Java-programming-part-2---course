/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Dmitry
 */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory history = new ContainerHistory();

    public ProductContainerRecorder(String name, double capacity, double initialVolume) {
        super(name, capacity);
        history.add(initialVolume);
        super.addToTheContainer(initialVolume);
    }
    
    public String history() {
        return history.toString();
    }
    
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        history.add(this.getVolume());
    }
    
    public double takeFromTheContainer(double amount) {
        double toReturn = super.takeFromTheContainer(amount);
        history.add(this.getVolume());
        return toReturn;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName() + "\n History: " + history() + "\nGreatest product amount: " +
                history.maxValue() + "\nSmallest product amount: " + history.minValue() + "\nAverage: " + history.average() +
                "\nGreatest change: " + history.greatestFluctuation() + "\nVariance: " + history.variance());
    }
    
}
