package com.example.sqbtask.config;
import com.example.sqbtask.domain.User;
import com.example.sqbtask.domain.Wallet;
import com.example.sqbtask.repository.UserRepository;
import com.example.sqbtask.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    public DatabaseInitializer(UserRepository userRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(1L,"John","12345","+998912455897");
        userRepository.save(user1);

        User user2 = new User(2L,"Jane","11111","+998907458497");
        userRepository.save(user2);

        Wallet wallet1 = new Wallet(1L, 91111111111111L,user1,0L);
        walletRepository.save(wallet1);

        Wallet wallet2 = new Wallet(2L, 92222222222222L,user2, 20000L);
        walletRepository.save(wallet2);

    }

}
