
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Airport {
    private ArrayList<Plane> planes;
    private HashMap<Flight, Plane> flights;

    public Airport() {
        planes = new ArrayList<Plane>();
        flights = new HashMap<Flight, Plane>();
    }
    
    public void addPlane(String id, int capacity) {
        planes.add(new Plane(id, capacity));
    }
    
    public void addFlight(String id, String depart, String dest) {
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                flights.put(new Flight(depart, dest), plane);
                break;
            }
        }
    }
    
    public void printPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }
    
    public void printFlights() {
        for (Map.Entry<Flight, Plane> entry : flights.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
    
    public void printPlaneInfo(String id) {
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                System.out.println(plane);
                break;
            }
        }
    }
    
    
    
}
