package com.example.sqbtask.service;

import com.example.sqbtask.dto.getInformation.GetInformationRequest;
import com.example.sqbtask.dto.getInformation.GetInformationResponse;
import com.example.sqbtask.dto.performTransaction.PerformTransactionRequest;
import com.example.sqbtask.dto.performTransaction.PerformTransactionResponse;
import org.springframework.stereotype.Service;

@Service
public interface BaseService {
    GetInformationResponse getInfo(GetInformationRequest request);
    PerformTransactionResponse perform(PerformTransactionRequest request);
}
