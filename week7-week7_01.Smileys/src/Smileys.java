
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {
        int length = characterString.length();
        printWholeRow(length);
        
        if (length % 2 == 0) {
            System.out.println(":) " + characterString + " :)");
        }
        
        else if (length % 2 != 0) {
            System.out.println(":) " + characterString + "  :)");
        }
        
        printWholeRow(length);
    }
    
    private static void printWholeRow(int length) {
        System.out.print(":):");
        
        if (length % 2 == 0) {
            for (int i = 0; i < length/2; i++) {
                System.out.print("):");
            }
        }
        
        else if (length % 2 != 0) {
            for (int i = 0; i < (length+1)/2; i++) {
                System.out.print("):");
            }
        }
        
        System.out.print("):)\n");
    }

}
