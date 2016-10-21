/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Dmitry
 */
public class ProductContainer extends Container {

    private String productName;
    
    public ProductContainer(String productName, double tilavuus) {
        super(tilavuus);
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return productName + ": " + super.toString();
    }
}
