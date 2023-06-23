package com.example.sqbtask.dto.performTransaction;

import com.example.sqbtask.dto.base.GenericArguments;
import com.example.sqbtask.dto.base.GenericParam;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PerformTransactionRequest extends GenericArguments {
    private Long amount;
    private GenericParam parameters;
    private Long serviceId;
    private Long transactionId;
    private LocalDateTime transactionTime;
}
