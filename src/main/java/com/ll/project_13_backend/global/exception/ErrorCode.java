package com.ll.project_13_backend.global.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    ENTITY_NOT_FOUND(400, "C_001", "지정한 Entity를 찾을 수 없습니다."),
    INVALID_INPUT_VALUE(400, "C_002", "적절하지 않은 요청 값입니다."),
    NOT_FOUND(404, "C_003", "존재하지 않는 값을 요청했습니다."),
    FAIL_LOGIN(400, "AU_001", "아이디 또는 패스워드가 틀립니다."),
    UNAUTHORIZED_USER(400, "AU_002", "권한이 없는 사용자입니다."),
    DUPLICATED_LOGIN_ID(400, "AU_003", "이미 존재하는 ID입니다."),
    DUPLICATED_EMAIL(400, "AU_004", "이미 존재하는 E-mail입니다."),
    INVALID_PASSWORD_MATCH(400, "AU_005", "두 패스워드가 일치하지 않습니다."),
    IS_NOT_LOGIN(400, "AU_006", "로그인을 하지 않은 사용자입니다."),
    INTERNAL_SERVER_ERROR(500, "C_004", "서버에 문제가 생겼습니다.");

    private final int status;
    private final String code;
    private final String message;

}
