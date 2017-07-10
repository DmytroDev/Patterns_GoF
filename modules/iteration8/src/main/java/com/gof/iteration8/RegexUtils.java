package com.gof.iteration8;

import java.util.regex.Pattern;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class RegexUtils {
    public static final String REGEX_CHARS = "[a-zA-Z]+";  // +  = match any char one or more times
    private static final String REGEX_NUMBERS = "[0-9]+";
    public static final Pattern PATTERN_CHARS = Pattern.compile(REGEX_CHARS);
    public static final Pattern PATTERN_NUMBERS = Pattern.compile(REGEX_NUMBERS);

}
