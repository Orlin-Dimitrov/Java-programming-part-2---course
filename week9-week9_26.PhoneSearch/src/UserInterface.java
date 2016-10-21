
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class UserInterface {
    
    private Scanner reader;
    private PhoneSearch search;

    public UserInterface(Scanner reader, PhoneSearch search) {
        this.reader = reader;
        this.search = search;
    }
    
    private String readMessage() {
        return reader.nextLine();
    }
    
    private void printInfo(Map<String, List<String>> map) {
        if(!(map.containsKey("address"))) {
            System.out.println("  address unknown");
        }
        else {
            System.out.println("  address: " + map.get("address").get(0));
        }
        if(!(map.containsKey("number"))) {
            System.out.println("  phone number not found");
        }
        else {
            System.out.println("  phone numbers:");
            for(String list : map.get("number")){
                System.out.println("   " + list);
            }
        }
    }
    
        
    private void printFilter(Map<String, Map<String, List<String>>> map) {
        Map<String, Map<String, List<String>>> sorted = new TreeMap<String, Map<String, List<String>>>(map);
        if (sorted.isEmpty()) {
            System.out.println(" keyword not found");
        }
        for(Map.Entry<String, Map<String, List<String>>> m : sorted.entrySet()) {
            System.out.println("\n " + m.getKey());
            printInfo(m.getValue());
        }
    }
    
    public void start() {
        System.out.println("phone search\n" +
                            "available operations:\n" +
                            " 1 add a number\n" +
                            " 2 search for a number\n" +
                            " 3 search for a person by phone number\n" +
                            " 4 add an address\n" +
                            " 5 search for personal information\n" +
                            " 6 delete personal information\n" +
                            " 7 filtered listing\n" +
                            " x quit");
        label:
        while(true) {
            System.out.println();
            System.out.print("command: ");
            String command = readMessage();
            
            if (command.equals("x")) {
                break;
            }
            
            int commandNumber;
            try {
                commandNumber = Integer.parseInt(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Type the number of allowed commands or \"x\" to quit");
                continue;
            }
            
            switch(commandNumber) {
                case 1:
                    System.out.print("whose number: ");
                    String person = readMessage();
                    System.out.print("number: ");
                    String number = readMessage();
                    search.addPhoneNumber(person, number);
                    break;
                
                case 2:
                    System.out.print("whose number: ");
                    String whoseNumber = readMessage();
                    search.searchNumberByPerson(whoseNumber);
                    break;
                    
                case 3:
                    System.out.print("number: ");
                    String numberTosearch = readMessage();
                    search.searchPersonByNumber(numberTosearch);
                    break;
                    
                case 4:
                    System.out.print("whose address: ");
                    String name = readMessage();
                    System.out.print("street: ");
                    String street = readMessage();
                    System.out.print("city: ");
                    String city = readMessage();
                    search.addAnAddress(name, street + " " + city);
                    break;
                    
                case 5:
                    System.out.print("whose information: ");
                    String info = readMessage();
                    Map<String, List<String>> mapInfo;
                    try {
                        mapInfo = search.searchInfo(info);
                        printInfo(mapInfo);
                    } catch (Exception e) {
                        System.out.println("  not found");
                        continue label;
                    }
                    break;
                    
                case 6:
                    System.out.print("whose information: ");
                    String delete = readMessage();
                    search.removePerson(delete);
                    break;
                    
                case 7:
                    System.out.print("keyword (if empty, all listed): ");
                    String keyWord = readMessage();
                    printFilter(search.filteredSearch(keyWord));
                    break;
            }
        }
    }
}
