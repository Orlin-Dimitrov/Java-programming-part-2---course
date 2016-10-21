package farmsimulator;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Test your program here
       Farm farm = new Farm("Esko", new Barn(new BulkTank()));

farm.addCow(new Cow());
farm.addCow(new Cow());
farm.addCow(new Cow());

farm.liveHour();
farm.liveHour();
System.out.println(farm);
    }
}
