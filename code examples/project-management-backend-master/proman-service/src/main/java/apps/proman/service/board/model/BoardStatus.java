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
 * An enum representing board's status.
 */
public enum BoardStatus {

    OPEN(0), CLOSED(1), DELETED(2);

    private static final Map<Integer, BoardStatus> LOOKUP = new HashMap();

    static {
        for (final BoardStatus enumeration : values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final int code;

    private BoardStatus(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BoardStatus get(final int code) {
        return LOOKUP.get(code);
    }

}