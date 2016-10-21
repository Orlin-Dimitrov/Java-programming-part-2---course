/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Dmitry
 */
public class RatingRegister {
    private Map<Film, List<Rating>> map;
    private Map<Film, Map<Person, Rating>> personR;
    private Set<Person> reviewers;

    public RatingRegister() {
        map = new HashMap<Film, List<Rating>>();
        personR = new HashMap<Film, Map<Person, Rating>>();
        reviewers = new HashSet<Person>();
    }
    
    public void addRating(Film film, Rating rating) {
        if(!map.containsKey(film)) {
            map.put(film, new ArrayList<Rating>());
        }
        map.get(film).add(rating);
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if(!personR.containsKey(film)) {
            personR.put(film, new HashMap<Person, Rating>());
        }
        if(!personR.get(film).containsKey(person)){
            personR.get(film).put(person, rating);
        }
        addRating(film, rating);
        reviewers.add(person);
    }
    
    public List<Rating> getRatings(Film film) {
        List<Rating> list = new ArrayList<Rating>();
        list.addAll(map.get(film));
        return list;
    }
    
    public Rating getRating(Person person, Film film) {
        Rating r = personR.get(film).get(person);
        if (r == null) {
            return Rating.NOT_WATCHED;
        }
        return r;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        Map<Film, Rating> result = new HashMap<Film, Rating>();
        for(Map.Entry<Film, Map<Person, Rating>> m : personR.entrySet()) {
            if (m.getValue().containsKey(person)) {
                result.put(m.getKey(), m.getValue().get(person));
            }
        }
        return result;
    }
    
    public List<Person> reviewers() {
        return new ArrayList<Person>(reviewers);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return map;
    }
    
    

    
}
