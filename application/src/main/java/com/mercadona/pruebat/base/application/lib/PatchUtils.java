package com.mercadona.pruebat.base.application.lib;

import java.lang.reflect.Field;

public class PatchUtils {

    public static <T> void patchObject(T target, T patch) {
        if (target == null || patch == null) {
            return;
        }

        Class<?> clazz = patch.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(patch);

                // Solo copiar si el campo NO es null
                if (value != null) {
                    field.set(target, value);
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error al hacer patch en el campo: " + field.getName(), e);
            }
        }
    }


}
