
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public static String findSimpleGene(String dna, String startCodon, String stopCodon) {
        int startIndex = dna.toLowerCase().indexOf(startCodon.toLowerCase());
        if (startIndex == -1) return "";
        int stopIndex = dna.toLowerCase().indexOf(stopCodon.toLowerCase(), startIndex);
        if (stopIndex == -1) return "";
        
        String gene = dna.substring(startIndex, stopIndex + 3);
        if (gene.length() % 3 == 0) return gene;
        return "";
    }
    
    public static void testSimpleGene() {
        String dna = "";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna, startCodon, stopCodon));
        
        dna = "ATTTTATGCTAAAA";
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna, startCodon, stopCodon));
        
        dna = "ATGCATTCAAATCGATCTAA";
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna,startCodon, stopCodon));
        
        dna = "ATGCATTCAAATCGATCTTAAatt".toLowerCase();
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna, startCodon, stopCodon));
    }
    
    public static void main(String[] args) {
        testSimpleGene();
    }
}
