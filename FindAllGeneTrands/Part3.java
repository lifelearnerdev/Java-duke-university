
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public static void findAbc(String input) {
    int index = input.indexOf("abcdabc");
    while (true) {
        if (index == -1) {
            break;
        }
        if(index > input.length() - 3) break;
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc", index+4);
        //} else break;
    }
}
   public static void test() {
    //no code yet
    findAbc("abcdabc");
}

}
