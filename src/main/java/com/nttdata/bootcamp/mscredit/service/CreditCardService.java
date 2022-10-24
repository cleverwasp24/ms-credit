package com.nttdata.bootcamp.mscredit.service;

import com.nttdata.bootcamp.mscredit.dto.CreditCardDTO;
import com.nttdata.bootcamp.mscredit.model.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    Flux<CreditCard> findAll();

    Mono<CreditCard> create(CreditCard creditCard);

    Mono<CreditCard> findById(Integer id);

    Mono<CreditCard> update(Integer id, CreditCard creditCard);

    Mono<Void> delete(Integer id);

    Mono<String> createCreditCard(CreditCardDTO creditCardDTO);

    Flux<CreditCard> findAllByClientId(Integer id);

    Mono<String> checkFields(CreditCardDTO creditCard);
}
