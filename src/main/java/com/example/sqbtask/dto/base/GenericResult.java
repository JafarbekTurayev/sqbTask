package com.example.sqbtask.dto.base;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GenericResult {
    private String errorMsg;
    private int status;
    private LocalDateTime timestamp;
}
