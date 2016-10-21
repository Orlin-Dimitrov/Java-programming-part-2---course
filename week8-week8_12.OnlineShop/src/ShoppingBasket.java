
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
public class ShoppingBasket {
    private Map<String, Purchase> purchase = new HashMap<String, Purchase>();
    
    public void add(String product, int price) {
        if (purchase.containsKey(product)) {
            purchase.get(product).increaseAmount();
        }
        else {
            purchase.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int totalPrice = 0;
        for (Purchase p : purchase.values()) {
            totalPrice += p.price();
        }
        return totalPrice;
    }
    
    public void print() {
        for (Purchase p : purchase.values()) {
            System.out.println(p);
        }
    }
}
