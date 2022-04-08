package book.arrays_strings;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OneAwayTest {
    @Test
    public void test_book_example(){
        Assert.assertTrue(OneAway.isOneAway("pale", "ple"));
        Assert.assertTrue(OneAway.isOneAway("pales", "pale"));
        Assert.assertTrue(OneAway.isOneAway("pale", "bale"));
        Assert.assertFalse(OneAway.isOneAway("pale", "bake"));
    }
}
