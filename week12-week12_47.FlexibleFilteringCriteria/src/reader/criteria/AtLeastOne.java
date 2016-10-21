/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dmitry
 */
public class AtLeastOne implements Criterion {
    private List<Criterion> list = new ArrayList<Criterion>();

    public AtLeastOne(Criterion... obj) {
        for(Criterion c : obj) {
            list.add(c);
        }
    }

    @Override
    public boolean complies(String line) {
        for(Criterion c : list) {
            if(c.complies(line))
                return true;
        }
        return false;
    
    }
    
}
