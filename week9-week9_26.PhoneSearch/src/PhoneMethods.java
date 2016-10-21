
import java.util.ArrayList;
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
public interface PhoneMethods {
    public void addPhoneNumber(String person, String number);
    public void searchNumberByPerson(String person);
    public void searchPersonByNumber(String number);
    public void addAnAddress(String name, String address);
    public Map<String, List<String>> searchInfo(String person);
    public void removePerson(String  person);
    public Map<String, Map<String, List<String>>> filteredSearch(String keyWord);
    
}
