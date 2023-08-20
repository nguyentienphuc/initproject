package com.ngs.vna.users.core.entity;

import io.jmix.core.metamodel.datatype.EnumClass;
import org.springframework.lang.Nullable;


public enum UserType implements EnumClass<String> {

    ADMIN("ADMIN"),
    AGENT("AGENT"),
    SUBAGENT("SUBAGENT"),
    CA("CA"),
    SUBCA("SUBCA");


    private final String id;

    UserType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static UserType fromString(String id) {
        for (UserType at : UserType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
