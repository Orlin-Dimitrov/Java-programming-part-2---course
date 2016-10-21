
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Storehouse {
    
    private Map<String, Integer> productMap = new HashMap<String, Integer>();
    private Map<String, Integer> stockMap = new HashMap<String, Integer>();
    
    public void addProduct(String product, int price, int stock) {
        productMap.put(product, price);
        stockMap.put(product, stock);
    }
    
    public int price(String product) {
        if (productMap.containsKey(product)) {
            return productMap.get(product);
        }
        return -99;
    }
    
    public int stock(String product) {
        if (stockMap.containsKey(product))
            return stockMap.get(product);
        return 0;
    }
    
    public boolean take(String product) {
        int val = 0;
        if (stockMap.containsKey(product)) 
            val = stockMap.get(product);
        if (stockMap.containsKey(product) && val > 0) {
            stockMap.put(product, val - 1);
            return true;
        }
        else
            return false;
            
    }
    
    public Set<String> products() {
        return productMap.keySet();
    }
    
    
    
    
}
