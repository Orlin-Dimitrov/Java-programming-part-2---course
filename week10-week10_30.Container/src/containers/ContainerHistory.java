/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Dmitry
 */
public class ContainerHistory {
    private List<Double> history = new ArrayList<Double>();
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }

    @Override
    public String toString() {
        return history.toString();
    }

        
    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }
        
        return Collections.max(history);
    }
    
    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }
        
        return Collections.min(history);
    }
    
    public double average() {
        if (history.isEmpty()) {
            return 0;
        }
        
        double sum = 0;
        
        for(double d : history) {
            sum += d;
        }
        
        return sum / history.size();
    }
    
    public double greatestFluctuation() {
        double temp = 0;
        for(int i = 0; i < history.size()-1; i++) {
            double dif = Math.abs(history.get(i) - history.get(i+1));
            if (dif > temp)
                temp = dif;
        }
        return temp;
    }
    
    public double variance() {
        double avrg = this.average();
        double sum = 0;
        for(Double d : history) {
            sum += Math.pow((d - avrg), 2);
        }
        return sum / (history.size() - 1);
    }
}
