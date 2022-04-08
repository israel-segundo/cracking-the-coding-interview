package book.arrays_strings;

/**
 * 1.5 There are three types of edits that can be performed on strings: insert a character, remove a character, or
 * replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * Example:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneAway {

    public static boolean isOneAway(String s1, String s2) {

        if (Math.abs(s1.length() - s2.length()) > 1){
            return false;
        }

        boolean isInsert = s1.length() < s2.length();
        boolean isRemove = s1.length() > s2.length();
        boolean isUpdate = s1.length() == s2.length();

        if (isUpdate) {
            int changesNeeded = 0;
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    changesNeeded++;
                }
            }
            return changesNeeded <= 1;

        } else if (isRemove) {
            for (int i = 0; i < s1.length(); i++) {
                String prefix = s1.substring(0, i);
                String suffix = s1.substring(i + 1);

                if (s2.equals(prefix + suffix)) {
                    return true;
                }
            }

        } else if(isInsert) {
            for (int i = 0; i < s2.length(); i++) {
                String prefix = s2.substring(0, i);
                String suffix = s2.substring(i, s2.length() - 1);

                if (s1.equals(prefix + suffix)) {
                    return true;
                }
            }
        }
        return false;
    }
}
