
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class RingingCentre {
    private Map<Bird, List<String>> map = new HashMap<Bird, List<String>>();
    
    public void observe(Bird bird, String place) {
        if(!map.containsKey(bird)) {
            map.put(bird, new ArrayList<String>());
        }
        map.get(bird).add(place);
    }
    
    public void observations(Bird bird) {
        if(!map.containsKey(bird)) {
            System.out.println(bird + " observations: 0");
        }
        else {
            System.out.println(bird + " observations: " + map.get(bird).size());
            for(String s : map.get(bird)) {
                System.out.println(s);
            }
        }
        
    }
}
