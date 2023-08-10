package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType = "word";

        //Process command-line arguments
        for (int i = 0; i < args.length; i++) {

            if ("-datatype".equals(args[i].toLowerCase())) {

                if (i < args.length - 1) {
                    dataType = args[i + 1].toLowerCase();
                } else {
                    System.out.println("No datatype value provided, defaulting to \"word\" datatype.");
                }

                //Right now we don't have any additional arguments, can stop once we find datatype.
                break;
            }
        }

        switch (dataType) {
            case "long" -> InputAnalyzer.readLongInput(scanner);
            case "word" -> InputAnalyzer.readStringInput(scanner, "word");
            case "line" -> InputAnalyzer.readStringInput(scanner, "line");
            default -> {
                System.out.println("Invalid datatype provided, defaulting to \"word\" datatype.");
            }
        }
    }
}
