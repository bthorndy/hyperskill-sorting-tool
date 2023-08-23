package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sortByCount = false;
        DataType dataType = DataType.WORD; //word is default if none or invalid dataype argument provided
        ArrayList<Long> longInput = new ArrayList<>();
        ArrayList<String> stringInput = new ArrayList<>();

        //Process command-line arguments
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-sortingType")) {
                if (i >= args.length - 1) {
                    System.out.println("No sorting type defined!");
                    return;
                } else {
                    if (args[i + 1].equals("byCount")) {
                        sortByCount = true;
                    } else if (args[i + 1].equals("natural")) {
                        sortByCount = false;
                    } else {
                        System.out.println("No sorting type defined!");
                        return;
                    }
                }
            } else if (args[i].equals("-dataType")) {
                if (i >= args.length - 1) {
                    System.out.println("No data type defined!");
                    return;
                } else {
                    try {
                        dataType = DataType.valueOf(args[i + 1].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("No data type defined!");
                        return;
                    }
                }
            }
        }

        //read input and add to appropriate array
        if (dataType == DataType.LONG) {
            while (scanner.hasNext()) {
                longInput.add(scanner.nextLong());
            }
        } else if (dataType == DataType.LINE) {
            while (scanner.hasNext()) {
                stringInput.add(scanner.nextLine());
            }
        }   else if (dataType == DataType.WORD) {
            while (scanner.hasNext()) {
                stringInput.add(scanner.next());
            }
        }

        if (sortByCount) {
            InputAnalyzer.sortByCount(dataType == DataType.LONG ? longInput : stringInput, dataType);
        } else {
            switch (dataType) {
                case WORD, LINE -> InputAnalyzer.sortStringsNatural(stringInput, dataType);
                case LONG -> InputAnalyzer.sortLongsNatural(longInput);
            }
        }
    }
}
