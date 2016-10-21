/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Dmitry
 */
public class Cow implements Milkable, Alive {
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    private String name;
    private double capacity = 15 + new Random().nextInt(26);
    private double amount = 0.0;

    public Cow() {
        name = NAMES[new Random().nextInt(31)];
    }

    public Cow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double  getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public double milk() {
        double milk = this.getAmount();
        amount = 0;
        return milk;
    }

    @Override
    public void liveHour() {
        amount += 0.7 + new Random().nextDouble() * 1.3;
        if(amount > capacity) {
            amount = capacity;
        }
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + capacity;
    }
    
    
    
    
    
    
    
}
