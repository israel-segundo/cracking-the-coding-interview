package book.arrays_strings;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IsUniqueTest {

    @DataProvider(name = "getStrategies")
    public static Object[][] getStrategies() {
        return new Object[][] {
                { new IsUniqueExtraSpaceStrategy() },
                { new IsUniqueNoExtraSpaceStrategy() }};
    }

    @Test(dataProvider = "getStrategies")
    public void when_passing_null_string_then_expect_false(IsUniqueStrategy strategy) {
        Assert.assertFalse(strategy.hasUniqueCharacters(null));
    }

    @Test(dataProvider = "getStrategies")
    public void when_passing_empty_string_then_expect_false(IsUniqueStrategy strategy) {
        Assert.assertFalse(strategy.hasUniqueCharacters(""));
    }

    @Test(dataProvider = "getStrategies")
    public void when_passing_string_with_repeated_characters_then_expect_false(IsUniqueStrategy strategy) {
        assertThat(strategy.hasUniqueCharacters("i am the walrus doo doo doo"), is(false));
    }

    @Test(dataProvider = "getStrategies")
    public void when_passing_a_string_of_length_one_then_expect_true(IsUniqueStrategy strategy) {
        Assert.assertTrue(strategy.hasUniqueCharacters("z"));
    }

    @Test(dataProvider = "getStrategies")
    public void when_passing_a_string_with_all_unique_characters_then_expect_true(IsUniqueStrategy strategy) {
        Assert.assertTrue(strategy.hasUniqueCharacters("aeiou"));
    }
}
