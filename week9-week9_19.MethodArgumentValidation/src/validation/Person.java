package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        try {
        if(name.isEmpty() || name.equals(null) || name.length() > 40 || age < 0 || age > 120)
            throw new IllegalArgumentException();
        } catch(NullPointerException e){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        
        
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
