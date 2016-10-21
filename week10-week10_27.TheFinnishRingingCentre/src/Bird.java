
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getRingingYear() {
        return ringingYear;
    }
    
    


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    @Override
    public boolean equals(Object other) {
        
        if(other == null) {
            return false;
        }
        
        if(getClass() != other.getClass()) {
            return false;
        }
        
        Bird compared = (Bird) other;
        
        if(this.latinName != compared.getLatinName()) {
            return false;
        }
        
        if(this.ringingYear != compared.getRingingYear()) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode(){
        if(this.latinName == null) {
            return 7;
        }
        return this.ringingYear + this.latinName.hashCode();
    }
}


