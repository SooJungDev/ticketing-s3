package com.ticketing.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "TICKET01", "유효하지 않은 input 값입니다."),
    METHOD_NOT_ALLOWED(405, "TICKET02", "지원하지 않은 HTTP method 호출하였습니다."),
    INTERNAL_SERVER_ERROR(500, "TICKET03", "서버 내부에서 알 수 없는 에러가 발생했습니다."),
    INVALID_TYPE_VALUE(400, "TICKET04", "유효하지 않은 Type 값입니다.");

    private int status;

    private final String code;
    private final String message;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
