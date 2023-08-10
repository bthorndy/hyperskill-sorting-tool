package sorting;

import java.util.HashMap;
import java.util.Scanner;

public class InputAnalyzer {
    public static void readLongInput(Scanner scanner) {
        long maxNum = Long.MIN_VALUE;
        int totalNumbers = 0;
        HashMap<Long, Integer> counts = new HashMap<>();

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            totalNumbers++;

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

        System.out.printf("Total numbers: %d.%n", totalNumbers);
        System.out.printf("The greatest number: %d (%d times(s)).", maxNum, counts.get(maxNum));
    }

    public static void readStringInput(Scanner scanner, String inputType) {
        String longestString = "";
        int stringCount = 0;
        int longestStringCount = 0;

        while (scanner.hasNext()) {
            String currentString = "";
            String longerString = "";

            if ("word".equals(inputType)) {
                currentString = scanner.next();
            } else if ("line".equals(inputType)) {
                currentString = scanner.nextLine();
            }



            if (currentString.equals(longestString)) {
                longestStringCount++;
            } else if (longerString(currentString, longestString) == currentString) {
                longestString = currentString;
                longestStringCount = 1;
            }
            stringCount++;
        }

        double longestStringPercentage = ((double) longestStringCount / stringCount) * 100;
        System.out.printf("Total %ss: %d.%n", inputType, stringCount);

        if (inputType.equals("line")) {
            System.out.printf("""
                    The longest line:
                    %s
                    (%d time(s), %.0f%%).
                    """, longestString, longestStringCount, longestStringPercentage);
        } else {
            System.out.printf("The longest %s: %s (%d times(s), %.0f%%).", inputType, longestString, longestStringCount,longestStringPercentage );
        }
    }

    private static String longerString(String s1, String s2) {
        boolean sameLength = s1.length() == s2.length();

        if (s1.length() > s2.length() || (sameLength && s1.compareTo(s2) > 0)) {
            return s1;
        } else {
            return s2;
        }

    }
}
