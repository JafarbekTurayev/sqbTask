package com.example.sqbtask.dto.base;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GenericParam {
    private String paramKey;
    private String paramValue;
}
