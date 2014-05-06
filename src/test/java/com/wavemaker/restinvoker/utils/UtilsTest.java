package com.wavemaker.restinvoker.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Dilip Kumar.
 * @since 6/5/14
 */
public class UtilsTest {
    private final Map<String, String> params;
    private final String TEST_URL = "http://example.com/example";
    private final String TEST_URL_WITH_PARAM = "http://example.com/example?id=10";

    public UtilsTest() {
        params = new HashMap<String, String>();
        params.put("name", "dilip");
        params.put("address", "hyderabad");
    }

    @Test
    public void testUpdatePathWithQueryParams() {
        String path = Utils.updatePathWithQueryParams(TEST_URL, params);
        assertEquals(TEST_URL + "?address=hyderabad&name=dilip", path);
    }

    @Test
    public void testUpdatePathQueryParamsWithParam() {
        String path = Utils.updatePathWithQueryParams(TEST_URL_WITH_PARAM, params);
        assertEquals(TEST_URL_WITH_PARAM + "&address=hyderabad&name=dilip", path);
    }
}
