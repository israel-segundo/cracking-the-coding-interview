package book.arrays_strings;

/**
 * 1.9 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1
 * and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g. "waterbottle" is a
 * rotation of "erbottlewat").
 */
public class StringRotation {

    public boolean isSubstring(String haystack, String needle) {
        return haystack.contains(needle);
    }

    public boolean isRotation(String s1, String s2) {
        return isSubstring(s2 + s2, s1);
    }
}
