package book.arrays_strings;

/**
 * 1.3 Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 * space at the end to hold the additional characters, and you are given the 'true' length of the string. (Note:
 * If implementing in Java, please use a character array so that you can perform this operation in place.)
 *
 * Example:
 * Input:   "Mr John Smith", 13
 * Output:  "Mr%20John%20Smith"
 */
public class Urlify {
    public static void urlify(char [] word, int realSize) {
        int space_count = 0;
        int i = 0;
        for (; i < word.length; i++) {
            if (word[i] == ' ') {
                space_count++;
            }
        }

        // Ignore spaces at the end, they are meant to make up the new characters we need to add.
        while(word[i - 1] == ' ') {
            space_count--;
            i--;
        }

        // realSize considers spaces.
        // As we are replacing one space (1 char) with '%20' (3 chars), we need to add 2 extra chars per space.
        int newLength = realSize + (2 * space_count);

        // To do in place, we need to fill the array backwards
        for (int j = realSize - 1, endPointer = newLength - 1; j >= 0; j--) {
            if (word[j] == ' ') {
                word[endPointer] = '0';
                word[endPointer - 1] = '2';
                word[endPointer - 2] = '%';
                endPointer = endPointer - 3;
            } else {
                word[endPointer] = word[j];
                endPointer = endPointer - 1;
            }
        }
    }
}
