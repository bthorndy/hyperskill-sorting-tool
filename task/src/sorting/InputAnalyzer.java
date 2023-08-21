package sorting;

import java.util.ArrayList;
import java.util.HashMap;

public class InputAnalyzer {
    public static void analyzeLongInput(ArrayList<Long> userInput) {
        long maxNum = Long.MIN_VALUE;
        HashMap<Long, Integer> counts = new HashMap<>();

        for (Long number : userInput) {

            //Only need to keep track of max count, so stop if this num isn't current max.
            if (number >= maxNum) {
                maxNum = number;

                if (counts.containsKey(number)) {
                    counts.put(number, counts.get(number) + 1);
                } else {
                    counts.put(number, 1);
                }
            }
        }

        System.out.printf("Total numbers: %d.%n", userInput.size());
        System.out.printf("The greatest number: %d (%d times(s)).", maxNum, counts.get(maxNum));
    }

    public static void analyzeStringInput(ArrayList<String> stringInput, DataType dataType) {
        String longestString = "";
        int stringCount = 0;
        int longestStringCount = 0;
        StringComparator comparator = new StringComparator();

        for (String currentString : stringInput) {
            if (currentString.equals(longestString)) {
                longestStringCount++;
            } else if (comparator.compare(currentString, longestString) > 0) {
                longestString = currentString;
                longestStringCount = 1;
            }
            stringCount++;
        }

        double longestStringPercentage = ((double) longestStringCount / stringCount) * 100;
        System.out.printf("Total %ss: %d.%n", dataType.getName(), stringCount);

        if (dataType == DataType.LINE) {
            System.out.printf("""
                    The longest line:
                    %s
                    (%d time(s), %.0f%%).
                    """, longestString, longestStringCount, longestStringPercentage);
        } else {
            System.out.printf("The longest %s: %s (%d times(s), %.0f%%).",
                    dataType.getName(), longestString, longestStringCount,longestStringPercentage );
        }
    }

    public static void sortIntegers(ArrayList<Long> input) {
        System.out.printf("Total numbers: %d.%n", input.size());
        System.out.print("Sorted data: ");
        input.sort(Long::compareTo);
        input.forEach(num -> System.out.print(num + " "));
    }
}
