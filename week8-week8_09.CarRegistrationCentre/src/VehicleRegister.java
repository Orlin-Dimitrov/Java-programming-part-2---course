
import java.util.ArrayList;
import java.util.Collections;
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
public class VehicleRegister {
    
    private HashMap<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String>();
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.containsKey(plate)) {
            return false;
        }
        else {
            owners.put(plate, owner);
            return true;
        }
    }
    
    public String get(RegistrationPlate plate) {
        return owners.get(plate);
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (!owners.containsKey(plate)) {
            return false;
        }
        else {
            owners.remove(plate);
            return true;
        }
    }
    
    public void printRegistrationPlates() {
        for (Map.Entry<RegistrationPlate, String> map : owners.entrySet()) {
            System.out.println(map.getKey());
        }
    }
    
    public void printOwners() {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<RegistrationPlate, String> map : owners.entrySet()) {
            String val = map.getValue();
            if (!(list.contains(val))) {
                list.add(val);
                System.out.println(val);
            }
        }
    }
}
