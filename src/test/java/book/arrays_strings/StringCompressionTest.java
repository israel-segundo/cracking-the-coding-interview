package book.arrays_strings;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringCompressionTest {

    @Test
    public void test_when_using_example(){
        Assert.assertEquals(StringCompression.compress("aabcccccaaa"), "a2b1c5a3");
    }

    @Test
    public void test_when_compressed_string_is_larger_than_original(){
        Assert.assertEquals(StringCompression.compress("a"), "a");
        Assert.assertEquals(StringCompression.compress("ab"), "ab");
    }
}
