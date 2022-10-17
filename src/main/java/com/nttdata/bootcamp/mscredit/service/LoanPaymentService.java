package com.nttdata.bootcamp.mscredit.service;

import com.nttdata.bootcamp.mscredit.dto.LoanPaymentDTO;
import com.nttdata.bootcamp.mscredit.model.LoanPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanPaymentService {

    Flux<LoanPayment> findAll();

    Mono<LoanPayment> create(LoanPayment loanPayment);

    Mono<LoanPayment> findById(Integer id);

    Mono<LoanPayment> update(Integer id, LoanPayment loanPayment);

    Mono<Void> delete(Integer id);

    Mono<LoanPaymentDTO> createLoanPayment(LoanPaymentDTO loanPaymentDTO);

}
