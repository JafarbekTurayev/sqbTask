package com.example.sqbtask.service;

import com.example.sqbtask.config.AppConfig;
import com.example.sqbtask.domain.Transaction;
import com.example.sqbtask.domain.User;
import com.example.sqbtask.domain.Wallet;
import com.example.sqbtask.domain.enums.TransactionStatus;
import com.example.sqbtask.dto.base.GenericParam;
import com.example.sqbtask.dto.getInformation.GetInformationRequest;
import com.example.sqbtask.dto.getInformation.GetInformationResponse;
import com.example.sqbtask.dto.performTransaction.PerformTransactionRequest;
import com.example.sqbtask.dto.performTransaction.PerformTransactionResponse;
import com.example.sqbtask.repository.TransactionRepository;
import com.example.sqbtask.repository.UserRepository;
import com.example.sqbtask.repository.WalletRepository;
import com.example.sqbtask.utils.RandomNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BaseServiceImpl implements BaseService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    private final CacheManager cacheManager;

    @Override
    public GetInformationResponse getInfo(GetInformationRequest request) {
        GetInformationResponse response = new GetInformationResponse();
        Optional<User> optionalUser = userRepository.findByUserNameAndPassword(request.getUsername(), request.getPassword());
        User user = optionalUser.orElse(null);
        if (user == null) {
            // User not found
            response.setStatus(404);
            response.setTimestamp(LocalDateTime.now());
            response.setErrorMsg("Bunday User tizimda mavjud emas!");
            return response;
        }

        String limit = RandomNumberGenerator.generateLimit();
        List<GenericParam> params = new ArrayList<>(Arrays.asList(
                GenericParam.builder().paramKey("phone").paramValue(user.getPhone()).build(),
                GenericParam.builder().paramKey("limit").paramValue(RandomNumberGenerator.generateLimit()).build()
        ));

        Objects.requireNonNull(cacheManager.getCache(AppConfig.LIMIT_CACHE)).put(Objects.requireNonNull(optionalUser.get().getPhone()), limit);

        response.setErrorMsg("INFO");
        response.setStatus(200);
        response.setTimestamp(LocalDateTime.now());
        response.setParameters(params);
        return response;
    }

    @Override
    public PerformTransactionResponse perform(PerformTransactionRequest request) {
        PerformTransactionResponse response = new PerformTransactionResponse();

        Optional<User> optionalUser = userRepository.findByUserNameAndPassword(request.getUsername(), request.getPassword());

        if (!optionalUser.isPresent()) {
            response.setTimestamp(LocalDateTime.now());
            response.setErrorMsg("Bunday User mavjud emas!");
            response.setStatus(404);
            return response;
        }
        User user = optionalUser.get();

        Cache.ValueWrapper valueWrapper = Objects.requireNonNull(Objects.requireNonNull(cacheManager.getCache(AppConfig.LIMIT_CACHE)).get(user.getPhone()));
        String limit = (String) Objects.requireNonNull(valueWrapper).get();

        Optional<Wallet> optionalWallet = walletRepository.findByUserId(user.getId());
        if (!optionalWallet.isPresent()) {
            response.setStatus(404);
            response.setErrorMsg("Bu Userni walleti mavjud emas!");
            response.setTimestamp(LocalDateTime.now());
            return response;
        }
        Wallet wallet = optionalWallet.get();


        if (request.getAmount() <= Long.parseLong(Objects.requireNonNull(limit))) {
            Transaction transaction = transactionRepository.save(Transaction.builder()
                    .amount(request.getAmount())
                    .status(TransactionStatus.SUCCESSFUL)
                    .wallet(wallet)
                    .createdAt(LocalDateTime.now())
                    .build());

            wallet.setBalance(wallet.getBalance() + request.getAmount());
            walletRepository.save(wallet);

            response.setTimestamp(LocalDateTime.now());
            response.setErrorMsg("Balans to'ldirildi");
            response.setStatus(200);
            response.setProviderTrnId(transaction.getId());
            return response;
        } else {
            response.setStatus(409);
            response.setErrorMsg("Limitdan ortiq balansni to'ldirish imkoni yo'q");
            response.setTimestamp(LocalDateTime.now());
            return response;
        }
    }
}
