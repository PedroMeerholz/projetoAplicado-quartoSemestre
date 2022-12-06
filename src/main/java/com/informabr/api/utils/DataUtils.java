package com.informabr.api.utils;

public class DataUtils {
    public static boolean isEmptyString(String string) {
        //True is returned if it is null
        if(isNullString(string) || isEmpty(string.trim())) {
            return true;
        }
        return false;
    }

    public static boolean isNullString(Object string) {
        return string == null;
    }

    public static boolean isEmpty(String string) {
        return string.isEmpty();
    }
}
