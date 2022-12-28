
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public static boolean twoOccurrences(String stringa, String stringb) {
        String[] subStrings = stringb.split(stringa);
        return subStrings.length > 2 ? true : false;
    }
    
    public static String lastPart(String stringa, String stringb) {
        int startIndex = stringb.indexOf(stringa) != -1 ? stringb.indexOf(stringa) + stringa.length() : 0;
        return stringb.substring(startIndex);
    }
    
    public static void testString() {
        System.out.println("Substring `" + "my" + "`" + "appeared more than twice in string '" + "my second time to go to the level today");
        System.out.println(twoOccurrences("my", "my second time to go to my level today"));
        
        System.out.println("Substring `" + "my" + "`" + "appeared more than twice in string '" + "my second time to go to the level today");
        System.out.println(twoOccurrences("my", "my second time to go to the level today"));
        
        System.out.println("Substring `" + "my" + "`" + "appeared more than twice in string '" + "");
        System.out.println(twoOccurrences("m", ""));
        
        System.out.println("String = `" + "my second time to go to the level today'");
        System.out.println(lastPart("my ", "my second time to go to the level today"));
    }
    
    public static void main(String[] args) {
        testString();
    }
}
