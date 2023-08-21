package sorting;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        boolean sameLength = s1.length() == s2.length();
        if (s1.equals(s2)) {
            return 0;
        } else if (s1.length() > s2.length() || (sameLength && s1.compareTo(s2) > 0)) {
            return 1;
        } else {
            return -1;
        }
    }
}
