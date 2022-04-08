package book.arrays_strings;

import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {

    @Test
    public void test_rotation() {
        //(e.g. "waterbottle" is a rotation of "erbottlewat").
        StringRotation stringRotation = new StringRotation();
        Assert.assertTrue(stringRotation.isRotation("waterbottle", "erbottlewat"));
    }
}
