package book.arrays_strings;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PalindromePermutationTest {
    @Test
    public void test_when_called_with_example(){
        // Input:   Tact Coa
        //Output:  True (permutations: "taco cat", "atco cta", etc.)

        List<String> palindromePermutations = PalindromePermutation.getPalindromePermutations("tact coa");
        System.out.println("Palindromes found: "  + palindromePermutations.size());
        Assert.assertTrue(palindromePermutations.contains("taco cat"));
        Assert.assertTrue(palindromePermutations.contains("atco cta"));
    }
}
