package com.nttdata.bootcamp.mscredit.service;

import com.nttdata.bootcamp.mscredit.dto.LoanDTO;
import com.nttdata.bootcamp.mscredit.model.Loan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService {

    Flux<Loan> findAll();

    Mono<Loan> create(Loan loan);

    Mono<Loan> findById(Integer id);

    Mono<Loan> update(Integer id, Loan loan);

    Mono<Void> delete(Integer id);

    Mono<String> createPersonalLoan(LoanDTO loanDTO);

    Mono<String> createBusinessLoan(LoanDTO loanDTO);

    Flux<Loan> findAllByClientId(Integer id);

    Mono<String> checkFields(LoanDTO loan);

}
