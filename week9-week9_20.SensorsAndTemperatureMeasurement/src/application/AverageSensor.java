/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dmitry
 */
public class AverageSensor implements Sensor {
    private List<Sensor> sensors = new ArrayList<Sensor>();
    private List<Integer> readings = new ArrayList<Integer>();
    
    @Override
    public boolean isOn() {
        for(Sensor sensor : sensors) {
            if (!sensor.isOn())
                return false;
        }
        return true;
    }

    @Override
    public void on() {
        for(Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for(Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        int size = sensors.size();
        int total = 0;
        for(Sensor sensor : sensors) {
            total += sensor.measure();
        }
        int avrg = total / size;
        readings.add(avrg);
        return avrg;
    }
    
    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }
    
    public List<Integer> readings() {
        return readings;
    }
    
}
