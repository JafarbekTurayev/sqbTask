package com.example.sqbtask.dto.performTransaction;

import com.example.sqbtask.dto.base.GenericParam;
import com.example.sqbtask.dto.base.GenericResult;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PerformTransactionResponse extends GenericResult {
    private GenericParam parameters;
    private Long providerTrnId;
}
