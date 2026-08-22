package org.fintechtransfer.exeption;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record ErrorResponse(
String errorCode,
String getMessage,
LocalDateTime localDateTime
){}
