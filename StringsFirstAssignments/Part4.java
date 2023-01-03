import edu.duke.*;

/**
 * This class finds URLs with youtube.com in them and preints them 
 * 
 * @author (Malaba) 
 * @version (4)
 */
public class Part4 {
    public static void printYoutube(URLResource url) {
        for (String ur: url.words()) {
            if (ur.toLowerCase().indexOf("youtube.com") != -1) {
                int startIndex = ur.indexOf("\"") + 1;
                int lastIndex = ur.lastIndexOf("\"");
                String uri = ur.substring(startIndex, lastIndex);
                System.out.println("Youtube links on the page are : " + uri);
            }
        }
        
    }
    
    public static void main(String[] args) {
        URLResource url = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        printYoutube(url);
    }
}
