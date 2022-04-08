package book.arrays_strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 1.3 Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 * space at the end to hold the additional characters, and you are given the 'true' length of the string. (Note:
 * If implementing in Java, please use a character array so that you can perform this operation in place.)
 *
 * Example:
 * Input:   "Mr John Smith", 13
 * Output:  "Mr%20John%20Smith"
 */
public class UrlifyTest {

    @Test
    public void when_passing_happy_path() {
        char[] word = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        char[] expectedWord = {'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h'};

        Urlify.urlify(word, 13);
        Assert.assertTrue(Arrays.equals(word, expectedWord));
    }
}
