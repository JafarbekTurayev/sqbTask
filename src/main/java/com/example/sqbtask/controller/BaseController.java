package com.example.sqbtask.controller;

import com.example.sqbtask.dto.getInformation.GetInformationRequest;
import com.example.sqbtask.dto.getInformation.GetInformationResponse;
import com.example.sqbtask.dto.performTransaction.PerformTransactionRequest;
import com.example.sqbtask.dto.performTransaction.PerformTransactionResponse;
import com.example.sqbtask.service.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BaseController {

    private final BaseServiceImpl baseService;


    @GetMapping("/getInfo")
    public ResponseEntity<GetInformationResponse> getInfo(@RequestBody GetInformationRequest request){
        GetInformationResponse info = baseService.getInfo(request);
        return ResponseEntity.status(info.getStatus()).body(info);
    }

    @PostMapping("/perform")
    public ResponseEntity<PerformTransactionResponse> perform(@RequestBody PerformTransactionRequest request){
        PerformTransactionResponse perform = baseService.perform(request);
        return ResponseEntity.status(perform.getStatus()).body(perform);
    }
}
