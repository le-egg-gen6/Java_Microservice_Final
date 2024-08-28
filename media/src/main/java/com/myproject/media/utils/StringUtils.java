package com.myproject.media.utils;

import lombok.experimental.UtilityClass;

/**
 * @author nguyenle
 */
@UtilityClass
public class StringUtils {

    public static boolean hastText(String s) {
        return s != null && !s.trim().isEmpty();
    }

}
