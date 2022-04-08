package book.arrays_strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1.4 Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or
 * phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not
 * need to be limited to just dictionary words.
 *
 * Example
 * Input:   Tact Coa
 * Output:  True (permutations: "taco cat", "atco cta", etc.)
 */
public class PalindromePermutation {

    public static List<String> getPalindromePermutations(String word) {

        ArrayList<String> palindromePermutations = new ArrayList<>();
        Set<String> permutations = getPermutations(word.toLowerCase());
        for(String permutation : permutations) {

            // Remove spaces as they do not count for palindromes.
            if (isPalindrome(permutation.replace(" ", ""))) {
                palindromePermutations.add(permutation);
            }
        }

        return palindromePermutations;
    }

    public static boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while (i < j){
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static Set<String> getPermutations(String word) {
        Set<String> permutations = new HashSet<>();
        getPermutations(word, permutations);
        return permutations;
    }

    public static void getPermutations(String word, Set<String> permutations) {

        if (word.length() == 1) {
            permutations.add(word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i + 1);
                String wordMinusChar = prefix + suffix;

                Set<String> wordMinusCharPermutations = new HashSet<>();
                getPermutations(wordMinusChar, wordMinusCharPermutations);

                for(String permutation : wordMinusCharPermutations) {
                    permutations.add(Character.toString(word.charAt(i))+ permutation);
                }
            }
        }
    }

}
