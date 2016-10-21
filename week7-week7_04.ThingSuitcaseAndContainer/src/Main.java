
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
       Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 0; i < 100; i++) {
            Thing brick = new Thing("Brick", 1 + i);
            Suitcase suitcase = new Suitcase(1 + i);
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);
        }
    }

}
