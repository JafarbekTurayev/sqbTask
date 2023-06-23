package com.example.sqbtask.dto.getInformation;


import com.example.sqbtask.dto.base.GenericArguments;
import com.example.sqbtask.dto.base.GenericParam;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetInformationRequest extends GenericArguments{
    private GenericParam parameters;
    private Long serviceId;
}
