/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author Dmitry
 */
public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    @Override
    public int compare(Film o1, Film o2) {
        List<Rating> f1 = ratings.get(o1);
        List<Rating> f2 = ratings.get(o2);
        int sum1 = 0;
        int sum2 = 0;
        
        
        for(Rating r : f1) {
            sum1 += r.getValue();
        }
        
        for(Rating r : f2) {
            sum2 += r.getValue();
        }
        
        int avg1 = sum1 / f1.size();
        int avg2 = sum2 / f2.size();
        
        return avg2 - avg1;
    }
    
}
