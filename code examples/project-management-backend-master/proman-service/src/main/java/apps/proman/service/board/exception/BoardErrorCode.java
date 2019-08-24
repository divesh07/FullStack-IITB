/*
 * Copyright 2018-2019, https://beingtechie.io
 *
 * File: UserErrorCode.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.board.exception;

import java.util.HashMap;
import java.util.Map;

import apps.proman.service.common.exception.ErrorCode;

/**
 * Error code for BOARDS module.
 */
public enum BoardErrorCode implements ErrorCode {

    BRD_001("BRD-001", "Board with identifier [{0}] does not exist"),

    BRD_002("BRD-002", "Board with name [{0}] already exist"),

    BRD_003("BRD-003", "Not a valid board status. Supported statuses are [{0}]"),

    BRD_004("BRD-004", "Board is not in OPEN status. Current status is {0}"),

    BRD_005("BRD-005", "Board with identifier [{0}] is in DELETED status"),
    ;

    private static final Map<String, BoardErrorCode> LOOKUP = new HashMap<String, BoardErrorCode>();

    static {
        for (final BoardErrorCode enumeration : BoardErrorCode.values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final String code;

    private final String defaultMessage;

    private BoardErrorCode(final String code, final String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }

}