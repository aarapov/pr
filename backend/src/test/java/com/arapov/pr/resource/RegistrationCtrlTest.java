package com.arapov.pr.resource;

import org.junit.Assert;
import org.junit.Test;

import java.net.URLDecoder;

/**
 * @author: Artem Arapov
 * Date: 05.10.13
 * Time: 16:17
 */
public class RegistrationCtrlTest {
    public static final String ENCODED_STRING = "%D0%90%D1%80%D1%82%D0%B5%D0%BC";

    public static final String EXPECTED_STRING = "Артем";

    @Test
    public void testDecode() throws Exception {
        String actualString = URLDecoder.decode(ENCODED_STRING, "UTF-8");
        Assert.assertEquals(EXPECTED_STRING, actualString);
    }
}
