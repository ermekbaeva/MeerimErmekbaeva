package com.epam.tc.hw9.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
    public static String randomString() {
        return RandomStringUtils.random(10, true, false);
    }
}
