package book.arrays_strings;

/**
 * 1.6 Implement a method to perform basic compression using the counts of repeated characters. For example: the
 * string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string. You can assume the string has only uppercase and lower case
 * letters (a-z)
 */
public class StringCompression {

    public static String compress(String word) {

        if (null == word || word.length() == 1) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        char currChar = word.charAt(0);
        int charCounter = 1;
        int i = 1;
        for (; i < word.length() - 1; i++) {
            if (word.charAt(i) == currChar) {
                charCounter++;
            } else {
                // Add to string
                sb.append(Character.toString(currChar) + Integer.toString(charCounter));
                // Reset
                currChar = word.charAt(i);
                charCounter = 1;
            }
        }

        // Last character
        if (word.charAt(i) == currChar) {
            sb.append(Character.toString(currChar) + Integer.toString(++charCounter));
        } else {
            sb.append(Character.toString(currChar) + Integer.toString(charCounter));
            sb.append(Character.toString(word.charAt(i)) + Integer.toString(1));
        }

        System.out.println(String.format("Original word: [%s]. Compressed word: [%s]", word, sb.toString()));
        if (sb.toString().length() > word.length()) {
            return word;
        }

        return sb.toString();
    }
}
