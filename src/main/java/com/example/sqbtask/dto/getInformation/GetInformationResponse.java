package com.example.sqbtask.dto.getInformation;

import com.example.sqbtask.dto.base.GenericParam;
import com.example.sqbtask.dto.base.GenericResult;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetInformationResponse extends GenericResult {
    public GetInformationResponse(String errorMsg, int status, LocalDateTime timestamp, List<GenericParam> parameters) {
        super(errorMsg, status, timestamp);
        this.parameters = parameters;
    }

    private List<GenericParam> parameters;
}
