package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sortIntegers = false;
        DataType dataType = DataType.WORD; //word is default if none or invalid dataype argument provided
        ArrayList<Long> longInput = new ArrayList<>();
        ArrayList<String> stringInput = new ArrayList<>();

        //Process command-line arguments
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-sortIntegers")) {
                sortIntegers = true;

            } else if (args[i].equals("-dataType")) {

                if (i < args.length - 1) {
                    try {
                        dataType = DataType.valueOf(args[i + 1].toUpperCase());
                    } catch (IllegalArgumentException e) {}
                }
            }
        }

        //read input and add to appropriate array
        if (sortIntegers || dataType == DataType.LONG) {
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

        if (sortIntegers) {
            InputAnalyzer.sortIntegers(longInput);
        } else {
            switch (dataType) {
                case WORD, LINE -> InputAnalyzer.analyzeStringInput(stringInput, dataType);
                case LONG -> InputAnalyzer.analyzeLongInput(longInput);
            }
        }
    }
}
