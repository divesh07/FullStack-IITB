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
 * Error code for PROJECTS module.
 */
public enum ProjectErrorCode implements ErrorCode {

    PRJ_001("PRJ-001", "Project with identifier [{0}] does not exist"),

    PRJ_002("PRJ-002", "Project with name [{0}] already exist"),

    PRJ_003("PRJ-003", "Not a valid project status. Supported statuses are [{0}]"),

    PRJ_004("PRJ-004", "Project with identifier [{0}] does not belong to the specified board [{1}]"),

    PRJ_005("PRJ-005", "Member with identifier [{0}] does not belong to the specified project [{1}]"),

    PRJ_006("PRJ-006", "Task cannot be added to a project which is in [{0}] status"),

    PRJ_007("PRJ-007", "Project with identifier [{0}] is in DELETED status"),
    ;

    private static final Map<String, ProjectErrorCode> LOOKUP = new HashMap<String, ProjectErrorCode>();

    static {
        for (final ProjectErrorCode enumeration : ProjectErrorCode.values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final String code;

    private final String defaultMessage;

    private ProjectErrorCode(final String code, final String defaultMessage) {
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