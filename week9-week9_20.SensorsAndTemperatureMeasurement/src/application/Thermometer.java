/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Dmitry
 */
public class Thermometer implements Sensor{
    private boolean power = false;
    
    @Override
    public boolean isOn() {
        if(power == true)
            return true;
        return false;
    }

    @Override
    public void on() {
        power = true;
    }

    @Override
    public void off() {
        power = false;
    }

    @Override
    public int measure() {
        if(!isOn())
            throw new IllegalStateException();
        return new Random().nextInt(61) + (-30);
    }
    
}
