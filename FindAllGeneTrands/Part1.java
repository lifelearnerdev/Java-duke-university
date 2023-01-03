import edu.duke.*;
/**
 * Finds Many genes in a genes sequence.
 * 
 * @author (Eric) 
 */
public class Part1 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        if ((stopIndex - startIndex) % 3 == 0) {
            return stopIndex;
        }
        return dna.length();
    }
    public static void testFindStopCodon() {
        String dna = "TGATCCTAA";
        System.out.println("DNA : " + dna);
        System.out.println("Stop codon is found at index : " + findStopCodon(dna, 0, "TAA"));
        
        
        dna = "";
        System.out.println("DNA : " + dna);
        System.out.println("Stop codon is found at index : " + findStopCodon(dna, 0, "TAA"));
    }
    
    public static String findGene(String dna, int startFrom) {
        int startIndex = dna.indexOf("ATG", startFrom);
        if (startIndex == -1) {
            return "";
        }
        int stopCodonTAA = findStopCodon(dna, startIndex + 3, "TAA");
        int stopCodonTAG = findStopCodon(dna, startIndex + 3, "TAG");
        int stopCodonTGA = findStopCodon(dna, startIndex + 3, "TGA");
     
        int stopIndex = dna.length();
        int[] stopIndexes = {stopCodonTAA, stopCodonTAG, stopCodonTGA};
        for (int stopI : stopIndexes) {
            if (stopI < stopIndex && stopI != -1) {
                stopIndex = stopI;
            }
        }
        if (stopIndex == dna.length()) return "";
        return dna.substring(startIndex, stopIndex + 3);
    }
    public static StorageResource getAllGenes(String dna) {
        int startIndex = 0;
        StorageResource storage = new StorageResource();
        
        while(true) {
            String geneStrand = findGene(dna, startIndex);
            if (geneStrand.isEmpty()) break;
            storage.add(geneStrand);
            //System.out.println("" + geneStrand);
            startIndex += geneStrand.length();
        }
        return storage;
    }
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
    public static void processGenes(StorageResource sr) {
        System.out.println("Gene processing results : ");
        int longest = 0;
        for(String g: sr.data()) {
            if (g.length() > 60) System.out.println("Gene longer than 9 characters : " + g + " with number of characters : " + g.length());
            if (cgRatio(g) > 0.35) System.out.println("C-G Ratio greater than 0.35 : " + g + " with number of characters : " + g.length());
            if (g.length() > longest) longest = g.length();
        }
        System.out.println("Longest Gene has length : " + longest);
    }
    
    public static double cgRatio(String dna) {;
        double countC = howMany("c", dna.toLowerCase());
        double countG = howMany("g", dna.toLowerCase());
        return countC/countG;
    }
    public static int countCGT(String dna) {
        return howMany("cgt", dna.toLowerCase());
    }
    public static void testFindGene() {
        String dna = "ATGCGATCCTAA";
        System.out.println("DNA : " + dna);
        System.out.println("The gene strand found is : " + findGene(dna, 0));
        
        
        dna = "ATGCGATCCGTAAAATGA";
        System.out.println("DNA : " + dna);
        System.out.println("The gene strand found is : " + findGene(dna, 0));
       
        
        dna = "AATGCTAACTAGCTGACTAATTCCATGCTAACTAGCTGACTAAT";
        System.out.println("DNA : " + dna);
        StorageResource genes = getAllGenes(dna);
        System.out.println("All gene strands found are : ");
        for(String g: genes.data()) {
            System.out.println(g);
        }
        
        dna = "ATGCGATCCGTAAAATGA";
        System.out.println("DNA : " + dna);
        System.out.println("The ratio of cg in the above dna strand is : " + cgRatio(dna));
        System.out.println("The number of CGTs in the dna strand is : " + countCGT(dna));
    }
    public static void testProcessGene() {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        StorageResource genes = getAllGenes(dna);
        processGenes(genes);
        
        //System.out.println("DNA : " + dna);
        //System.out.println("The ratio of cg in the above dna strand is : " + cgRatio(dna));
        //System.out.println("The number of CGTs in the dna strand is : " + countCGT(dna));
    }
    
}
