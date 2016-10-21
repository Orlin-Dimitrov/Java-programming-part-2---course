
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class PhoneSearch implements PhoneMethods {
    
    private Map<String, Map<String, List<String>>> dic = new HashMap<String, Map<String, List<String>>>();
    
    private Map<String, List<String>> getMap (String person) {
        return dic.get(person);
    }
    
    private List<String> getList (String name, String info) {
        return getMap(name).get(info);
    }

    @Override
    public void addPhoneNumber(String person, String number) {
        if(!(this.dic.containsKey(person))) {
            dic.put(person, new HashMap<String, List<String>>());
        }
        if(!(getMap(person).containsKey("number"))) {
            getMap(person).put("number", new ArrayList<String>());
        }
        
        getList(person, "number").add(number);
    }

    @Override
    public void searchNumberByPerson(String person) {
        if (!(this.dic.containsKey(person))) {
            System.out.println("  not found");
        }
        else {
            for(String number : getList(person, "number")) {
                System.out.println(" " + number);
            }
        }
    }

    @Override
    public void searchPersonByNumber(String number) {
        boolean flag = true;
        label:
        for(Map.Entry<String, Map<String, List<String>>> map : this.dic.entrySet()) {
            for(Map.Entry<String, List<String>> secMap : map.getValue().entrySet()) {
                List<String> temp = secMap.getValue();
                if (temp.contains(number)) {
                    System.out.println(" " + map.getKey());
                    flag = false;
                    break label;
                }
            }
        }
        if(flag) {
            System.out.println("  not found");
        }
    }

    @Override
    public void addAnAddress(String person, String address) {
        if(!(this.dic.containsKey(person))) {
            dic.put(person, new HashMap<String, List<String>>());
        }
        if(!(getMap(person).containsKey("address"))) {
            getMap(person).put("address", new ArrayList<String>());
        }
        getList(person, "address").add(address);
    }

    @Override
    public Map<String, List<String>> searchInfo(String person) {
        return getMap(person);
    }

    @Override
    public void removePerson(String person) {
        this.dic.remove(person);
    }

    @Override
    public Map<String, Map<String, List<String>>> filteredSearch(String keyWord) {
        Map<String, Map<String, List<String>>> temp = new HashMap <String, Map<String, List<String>>>();
        for(Map.Entry<String, Map<String, List<String>>> map : this.dic.entrySet()) {
            if (map.getKey().contains(keyWord)) {
                temp.put(map.getKey(), map.getValue());
                continue;
            }
            for(Map.Entry<String, List<String>> secMap : map.getValue().entrySet()) {
                
                List<String> list = secMap.getValue();
                for (String s: list) {
                    if (s.contains(keyWord)) {
                        temp.put(map.getKey(), map.getValue());
                    }
                }
            }
        }
        return temp;
    }
    
}
