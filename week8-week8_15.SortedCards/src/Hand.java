
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Hand implements Comparable<Hand>{
    private  ArrayList<Card> cards = new ArrayList<Card>(); 

    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public int sum() {
        int sum = 0;
        for (Card c : cards) {
            sum += c.getValue();
        }
        return sum;
    }

    @Override
    public int compareTo(Hand o) {
        return this.sum() - o.sum();
    }
    
    public void sortAgainstSuit() {
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }
    
    
}
