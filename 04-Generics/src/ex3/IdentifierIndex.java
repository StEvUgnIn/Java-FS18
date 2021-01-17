package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IdentifierIndex {

    public static Map<String, Set<Integer>> createIndex (String filename) throws FileNotFoundException {
        Map<String, Set<Integer>> indexToLineNumber = new TreeMap<>();

        Scanner in = new Scanner(new File(filename));
        int linenumber = 1;
        while (in.hasNextLine()) {
            Scanner lineParser = new Scanner(in.nextLine());
            lineParser = lineParser.useDelimiter("\\W+");
            while (lineParser.hasNext()) {
                String identifier = lineParser.next();
                indexToLineNumber.putIfAbsent(identifier, new TreeSet<>());
                indexToLineNumber.get(identifier).add(linenumber);
            }
            linenumber++;
        }
        return indexToLineNumber;
    }

    public static void main (String[] args) throws FileNotFoundException {
        Map<String, Set<Integer>> indexToLineNumbers = createIndex("src/ex3/IdentifierIndex.java");
        System.out.println(indexToLineNumbers);
    }
}
