/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Dmitry
 */
public class Reference {
    private RatingRegister ratReg;

    public Reference(RatingRegister ratReg) {
        this.ratReg = ratReg;
    }
    
    public Film recommendFilm(Person person) {
        if (!ratReg.reviewers().contains(person)) {
           Map<Film, List<Rating>> fRat = ratReg.filmRatings();
            List<Film> films = new ArrayList<Film>(fRat.keySet());
            Collections.sort(films, new FilmComparator(fRat));
            return films.get(0); 
        }
        
        Map<Film, Rating> perRate = ratReg.getPersonalRatings(person);
        Set<Person> set = getSameTastePeople(person).keySet();
        List<Person> sameTaste = new ArrayList<Person>(set);
        Collections.sort(sameTaste, new PersonComparator(getSameTastePeople(person)));
        
        List<Film> goodFilms = new ArrayList<Film>();
        
        for(Person p : sameTaste) {
            Map<Film, Rating> otherPerRate = ratReg.getPersonalRatings(p);
            for(Map.Entry<Film, Rating> m : otherPerRate.entrySet()) {
                int rate = m.getValue().getValue();
                if(!perRate.containsKey(m.getKey()) && rate > 1) {
                    return m.getKey();
                }
            }
        }
        return null;
    }
    
    private Map<Person, Integer> getSameTastePeople(Person person) {
        Map<Person, Integer> sameTaste = new HashMap<Person, Integer>();
        Map<Film, Rating> perRate = ratReg.getPersonalRatings(person);
        List<Person> reviwers = ratReg.reviewers();
        for(Person p : reviwers) {
            Map<Film, Rating> otherPerRate = ratReg.getPersonalRatings(p);
            int similarity = 0;
            for(Film film : otherPerRate.keySet()) {
                if(perRate.containsKey(film)) {
                    similarity += perRate.get(film).getValue() * otherPerRate.get(film).getValue();
                }
            }
            if (similarity > 0) {
                sameTaste.put(p, similarity);
            }
        }
        return sameTaste;
    }
    
    
}
