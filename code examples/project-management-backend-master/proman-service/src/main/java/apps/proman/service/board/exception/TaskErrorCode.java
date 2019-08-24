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
 * Error code for TASKS module.
 */
public enum TaskErrorCode implements ErrorCode {

    TSK_001("TSK-001", "Task with identifier [{0}] does not exist"),

    TSK_002("TSK-002", "Not a valid task status. Supported statuses are [{0}]"),

    TSK_003("TSK-003", "Task with identifier [{0}] does not belong to the specified board [{1}] and project [{2}]"),

    TSK_004("TSK-004", "Task with identifier [{0}] is in DELETED status")
    ;

    private static final Map<String, TaskErrorCode> LOOKUP = new HashMap<String, TaskErrorCode>();

    static {
        for (final TaskErrorCode enumeration : TaskErrorCode.values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final String code;

    private final String defaultMessage;

    private TaskErrorCode(final String code, final String defaultMessage) {
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