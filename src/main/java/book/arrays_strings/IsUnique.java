package book.arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 *      What if you cannot use additional data structures.
 */
interface IsUniqueStrategy {
    boolean hasUniqueCharacters(final String word);
}

/**
 * IsUniqueExtraSpaceStrategy
 *  Relies on a hash to store char as key and number of occurrences as value. If any character on hash has a count
 *  greater than one, then we have duplicate chars.
 */
class IsUniqueExtraSpaceStrategy implements IsUniqueStrategy {

    public boolean hasUniqueCharacters(final String word) {

        if (null == word || word.isEmpty()) {
            return false;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            if(!charMap.containsKey(word.charAt(i))) {
                charMap.put(word.charAt(i), 0);
            }
            charMap.put(word.charAt(i), charMap.get(word.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
        }

        return true;
    }
}

/**
 * IsUniqueNoExtraSpaceStrategy
 *  Relies on an in-place sorting algorithm, so we can have duplicate chars next to each other. Then iterate the
 *  word and check if we have two identical characters next to each other.
 */
class IsUniqueNoExtraSpaceStrategy implements IsUniqueStrategy {

    public boolean hasUniqueCharacters(final String word) {
        if (null == word || word.isEmpty()) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }

        char [] charArray = word.toCharArray();
        Arrays.sort(charArray);

        char previousChar = charArray[0];

        for (int i = 1; i < charArray.length; i++) {

            var currentChar = charArray[i];
            if(previousChar == currentChar) {
                return false;
            }
            previousChar = currentChar;
        }

        return true;
    }
}

