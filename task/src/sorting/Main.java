package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
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
}
