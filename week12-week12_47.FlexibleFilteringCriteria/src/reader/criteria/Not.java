/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author Dmitry
 */
public class Not implements Criterion {
    private Criterion obj;

    public Not(Criterion obj) {
        this.obj = obj;
    }

    @Override
    public boolean complies(String line) {
        if(!obj.complies(line)) {
            return true;
        }
        return false;
    }
    
}
