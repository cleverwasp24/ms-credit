package com.nttdata.bootcamp.mscredit.service;

import com.nttdata.bootcamp.mscredit.dto.LoanPaymentDTO;
import com.nttdata.bootcamp.mscredit.dto.TransactionDTO;
import com.nttdata.bootcamp.mscredit.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> findAll();

    Mono<Transaction> create(Transaction transaction);

    Mono<Transaction> findById(Integer id);

    Mono<Transaction> update(Integer id, Transaction transaction);

    Mono<Void> delete(Integer id);

    Mono<TransactionDTO> createTransaction(TransactionDTO transactionDTO);

}
