/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: UserStatus.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.board.model;

import java.util.HashMap;
import java.util.Map;

/**
 * An enum representing project's status.
 */
public enum ProjectStatus {

    OPEN(0), IN_PROGRESS(1), ON_HOLD(2), COMPLETED(3), DELETED(4);

    private static final Map<Integer, ProjectStatus> LOOKUP = new HashMap();

    static {
        for (final ProjectStatus enumeration : values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final int code;

    private ProjectStatus(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProjectStatus get(final int code) {
        return LOOKUP.get(code);
    }

}