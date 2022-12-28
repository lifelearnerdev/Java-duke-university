
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public static String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) return "";
        int stopIndex = dna.indexOf("TAA", startIndex);
        if (stopIndex == -1) return "";
        
        String gene = dna.substring(startIndex, stopIndex + 3);
        if (gene.length() % 3 == 0) return gene;
        return "";
    }
    
    public static void testSimpleGene() {
        String dna = "";
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna));
        
        dna = "ATTTTATGCTAAAA";
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna));
        
        dna = "ATGCATTCAAATCGATCTAA";
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna));
        
        dna = "ATGCATTCAAATCGATCTTAA";
        System.out.println("The DNA Sequence is: " + dna);
        System.out.println("The gene is the above sequence is: " + findSimpleGene(dna));
    }
    
    public static void main(String[] args) {
        testSimpleGene();
    }
}
