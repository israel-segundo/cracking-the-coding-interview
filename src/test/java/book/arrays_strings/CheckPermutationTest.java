package book.arrays_strings;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckPermutationTest {


    @DataProvider(name = "getStrategies")
    public static Object[][] getStrategies() {
        return new Object[][] {
                { new CheckPermutationExtraSpace() },
                { new CheckPermutationNoExtraSpace() }};
    }

    @Test(dataProvider = "getStrategies")
    public void givenNullWord1_When_CheckPermutation_Then_returnFalse(final IsPermutationStrategy strategy) {
        Assert.assertFalse(strategy.isPermutation(null, "word2"));
    }

    @Test(dataProvider = "getStrategies")
    public void givenNullWord2_When_CheckPermutation_Then_returnFalse(final IsPermutationStrategy strategy) {
        Assert.assertFalse(strategy.isPermutation("word1", null));
    }

    @Test(dataProvider = "getStrategies")
    public void givenWordsDifferentSizes_When_CheckPermutation_Then_returnFalse(final IsPermutationStrategy strategy) {
        Assert.assertFalse(strategy.isPermutation("frodo", "baggins"));
    }

    @Test(dataProvider = "getStrategies")
    public void givenEmptyWords_When_CheckPermutation_Then_returnTrue(final IsPermutationStrategy strategy) {
        Assert.assertTrue(strategy.isPermutation("", ""));
    }

    @Test(dataProvider = "getStrategies")
    public void givenWordsArePermutations_When_CheckPermutation_Then_returnTrue(final IsPermutationStrategy strategy) {
        Assert.assertTrue(strategy.isPermutation("players", "parsleyq"));
    }
}
