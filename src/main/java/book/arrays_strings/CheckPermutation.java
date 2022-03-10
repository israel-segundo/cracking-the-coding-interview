package book.arrays_strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1.2 Given two strings, write a method to decide if one is a permutation of the other.
 */
interface IsPermutationStrategy {
     boolean isPermutation(final String word1, final String word2);
}

/**
 * CheckPermutationExtraSpace
 *  Relies on a hash to store char as key and number of occurrences as value. Then, for the second word we subtract
 *  the occurrence number from the hash.
 */
class CheckPermutationExtraSpace implements IsPermutationStrategy {

    public boolean isPermutation(final String word1, final String word2) {

        if (null == word1 || null == word2) {
            return false;
        }

        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();

        // Count chars of word1 and store on hash
        for (int i = 0; i < word1.length(); i++) {
            var currChar = word1.charAt(i);

            if(!charMap.containsKey(currChar)) {
                charMap.put(currChar, 0);
            }
            charMap.put(currChar, charMap.get(currChar) + 1);
        }

        // Iterate over word2 and remove occurrences from map
        for (int i = 0; i < word2.length(); i++) {
            var currChar = word2.charAt(i);

            if (!charMap.containsKey(currChar)) {
                return false;
            }

            charMap.put(currChar, charMap.get(currChar) - 1);

            if (charMap.get(currChar) == 0) {
                charMap.remove(currChar);
            }
        }

        return charMap.isEmpty();
    }
}

/**
 * CheckPermutationNoExtraSpace
 *  Relies on an in-place sorting algorithm. Then we compare both sorted words and if they are equal, they are
 *  permutations.
 */
class CheckPermutationNoExtraSpace implements IsPermutationStrategy {

    private String sortString(final String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean isPermutation(final String word1, final String word2) {

        if (null == word1 || null == word2) {
            return false;
        }

        if (word1.length() != word2.length()) {
            return false;
        }

        var sortedWord1 = sortString(word1);
        var sortedWord2 = sortString(word2);

        return sortedWord1.equalsIgnoreCase(sortedWord2);
    }
}
