
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public static int howMany(String stringa, String stringb) {
        if (stringb.isEmpty()) return 0;
        int count = 0;
        int fromIndex = 0;
        while(true) {
            int index =  stringb.indexOf(stringa, fromIndex);
            if (index == -1) break;
            fromIndex = index + stringa.length();
            count++;
        }
        
        return count;
    }
    
    public static void testCountGenes() {
        String dna = "ATGCGATCCTAAGAGA";
        System.out.println("How many? : " + howMany("GA", dna));
    }
}
