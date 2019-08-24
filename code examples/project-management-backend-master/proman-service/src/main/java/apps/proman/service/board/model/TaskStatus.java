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
 * An enum representing task's status.
 */
public enum TaskStatus {

    OPEN(0), IN_PROGRESS(1), ON_HOLD(2), COMPLETED(3), REOPENED(4), CLOSED(5), DELETED(6);

    private static final Map<Integer, TaskStatus> LOOKUP = new HashMap();

    static {
        for (final TaskStatus enumeration : values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final int code;

    private TaskStatus(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskStatus get(final int code) {
        return LOOKUP.get(code);
    }

}