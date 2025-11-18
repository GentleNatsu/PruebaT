package com.mercadona.pruebat.base.application.lib;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public boolean isBlank(String string) {
        return string == null || string.trim().isEmpty();
    }

    public String rtrim(String value) {
        if (value == null) {
            return null;
        }
        return value.replaceAll("\\s+$", "");
    }

    public String padLeft(Object string, int size) {
        return padLeft(string.toString(), size, "0");
    }

    public String padLeft(Object object, int size, String character) {
        return String.format("%1$" + size + "s", object.toString()).replace(" ", character);
    }

    public String padRight(Object object, int size, String character) {
        return String.format("%1$-" + size + "s", object.toString()).replace(" ", character);
    }
}
