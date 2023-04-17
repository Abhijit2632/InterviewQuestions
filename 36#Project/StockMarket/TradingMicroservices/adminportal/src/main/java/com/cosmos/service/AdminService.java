package com.cosmos.service;

import com.cosmos.document.Wallet;
import com.cosmos.repository.WalletRepository;
import com.cosmos.util.CommonUtil;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private CommonUtil commonUtil;

    public Wallet addCash(Wallet wallet) {
        Float amount = wallet.getCash();
        Long txId = commonUtil.generateSequence("WalletTxSequence");
        Wallet wallet1 = Wallet.builder()
                .txId(txId)
                .walletId(1L)
                .isWithdrawal(false)
                .cash(amount)
                .txDate(LocalDate.now())
                .build();
        Float val = calculateBalanceAmount(wallet1);
        wallet1.setTotalCash(val);
        return walletRepository.save(wallet1);
    }
    public Wallet withdrawCash(Wallet wallet) {
        Float amount = wallet.getCash();
        Long txId = commonUtil.generateSequence("WalletTxSequence");
        Wallet wallet1 = Wallet.builder()
                .txId(txId)
                .walletId(1L)
                .isWithdrawal(true)
                .cash(amount)
                .txDate(LocalDate.now())
                .build();
        Float val = calculateBalanceAmount(wallet1);
        wallet1.setTotalCash(val);
        return walletRepository.save(wallet1);
    }

    private Float calculateBalanceAmount(Wallet wallet) {
        //get latest wallet balance
        Float availableBalance = 0F;
        Optional<Wallet> optionalWallet = walletRepository.findById(wallet.getWalletId());
        if(optionalWallet.isPresent()) {
            availableBalance = optionalWallet.get().getTotalCash();
        }
        if(wallet.isWithdrawal()){
            return availableBalance-wallet.getCash();
        }else {
            return availableBalance+ wallet.getCash();
        }
    }
}
