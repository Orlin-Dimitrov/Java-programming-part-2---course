/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Flight {
    private String depart;
    private String dest;

    public Flight(String depart, String dest) {
        this.depart = depart;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "(" + depart + "-" + dest + ")";
    }
    
    
    
}
