package sorting;

import java.util.*;

public class InputAnalyzer {

    static class CountedEntry implements Comparable<CountedEntry>{
        int count;
        Object value;
        DataType dataType;

        public CountedEntry(int count, Object value, DataType dataType) {
            this.count = count;
            this.value = value;
            this.dataType = dataType;
        }

        @Override
        public int compareTo(CountedEntry other) {
            if (this.count > other.count) {
                return 1;
            } else if (this.count == other.count) {
                if (dataType == DataType.LONG) {
                    return Long.compare((Long)this.value, (Long)other.value);
                } else {
                    return this.value.toString().compareTo(other.value.toString());
                }
            } else {
                return -1;
            }
        }
    }

    public static void sortStringsNatural(ArrayList<String> input, DataType dataType) {
        input.sort(String::compareTo);

        System.out.printf("Total %ss: %d%n", dataType.getName(), input.size());
        System.out.print("Sorted data: ");

        input.forEach(s -> {
            System.out.printf("%s ", s);
            if (dataType == DataType.LINE) {
                System.out.println();
            }
        });
    }

    public static void sortLongsNatural(ArrayList<Long> input) {
        input.sort(Long::compareTo);
        StringBuilder sb = new StringBuilder();
        input.forEach(num -> sb.append(num).append(" "));
        System.out.printf("Total numbers: %d.%n", input.size());
        System.out.print("Sorted data: ");
        input.forEach(num -> System.out.print(num + " "));
    }

    public static void sortByCount(Collection<? extends Object> input, DataType dataType) {
        HashMap<Object,Integer> map = new HashMap<>();
        ArrayList<CountedEntry> output = new ArrayList<>();

        for (Object o : input) {
             int keyCount = (map.containsKey(o)) ? map.get(o) + 1 : 1;
             map.put(o, keyCount);
        }

        map.forEach((value, count) -> {
                    CountedEntry thisEntry = new InputAnalyzer.CountedEntry(count, value, dataType);
                    output.add(thisEntry);
                });

        output.sort(CountedEntry::compareTo);

        printSortedData(output, dataType, input.size());
    }

    private static void printSortedData(ArrayList<CountedEntry> sortedList, DataType dataType, int totalCount) {
        String typeString = dataType.equals(DataType.LONG) ? "number" : dataType.getName();

        System.out.printf("Total %ss: %d%n", typeString, totalCount);
        sortedList.forEach((CountedEntry entry) -> {
            double percentage = ((double) entry.count / totalCount) * 100;
            System.out.printf("%s: %d time(s), %.0f%%%n", entry.value.toString(), entry.count, percentage);
        });
    }
}
