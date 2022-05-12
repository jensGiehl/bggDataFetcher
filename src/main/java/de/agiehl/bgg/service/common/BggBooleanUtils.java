package de.agiehl.bgg.service.common;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BggBooleanUtils {

    private static BggBooleanUtils instance;

    public boolean toBool(Short value) {
        return value == 1;
    }

    public String toStringValue(boolean value) {
        return value ? "1" : "0";
    }

    public Short toValue(boolean value) {

        return value ? Short.valueOf((short) 1) : Short.valueOf((short) 0);
    }

    public static BggBooleanUtils getInstance() {
        if (Objects.isNull(instance)) {
            instance = new BggBooleanUtils();
        }

        return instance;
    }

}
