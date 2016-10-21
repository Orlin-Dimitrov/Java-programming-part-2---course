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
public class Both implements Criterion{
    private Criterion obj1;
    private Criterion obj2;

    public Both(Criterion obj1, Criterion obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public boolean complies(String line) {
        if(obj1.complies(line) && obj2.complies(line))
            return true;
        return false;
    }
    
    
}
