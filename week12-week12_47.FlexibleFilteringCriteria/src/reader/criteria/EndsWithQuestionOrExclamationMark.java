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
public class EndsWithQuestionOrExclamationMark implements Criterion {

    @Override
    public boolean complies(String line) {
        if(line.equals(""))
            return false;
        char c = line.charAt(line.length() - 1);
        if( c == '!' || c == '?' )
            return true;
        return false;
    }
    
}
