package documentDistance;

import java.util.Arrays;
import java.util.HashMap;

public class DocumentDistance {
    public static double getDocumentDistance(String firstDocument,String secondDocument){
        var dict = new HashMap<String,Integer>();
        firstDocument = deleteAllPunctuations(firstDocument);
        secondDocument = deleteAllPunctuations(secondDocument);
        Arrays.stream(splitToWords(firstDocument)).forEach(System.out::println);
        return 0d;
    }

    private static String deleteAllPunctuations(String input){
        return input.replaceAll("[\\d.=+-;:/,&?!]","");
    }
    private static String[] splitToWords(String input){
        var tempArray = input.split("\\s");
        return Arrays.stream(tempArray).filter(x->!x.isEmpty()).toArray(String[]::new);
    }
}
