package com.nttdata.bootcamp.mscredit.controller;

import com.nttdata.bootcamp.mscredit.dto.CreditCardDTO;
import com.nttdata.bootcamp.mscredit.model.CreditCard;
import com.nttdata.bootcamp.mscredit.service.impl.CreditCardServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("/bootcamp/creditcard")
public class CreditCardController {

    @Autowired
    CreditCardServiceImpl creditCardService;

    @GetMapping(value = "/findAllCreditCards")
    @ResponseBody
    public Flux<CreditCard> findAllCreditCards() {
        return creditCardService.findAll();
    }

    @PostMapping(value = "/createCreditCard")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreditCardDTO> createSavingsCreditCard(@RequestBody CreditCardDTO creditCardDTO) {
        return creditCardService.createCreditCard(creditCardDTO);
    }

    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public Mono<CreditCard> findCreditCardById(@PathVariable Integer id) {
        return creditCardService.findById(id)
                .defaultIfEmpty(null);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Mono<CreditCard> updateCreditCard(@PathVariable Integer id, @RequestBody CreditCard creditCard) {
        return creditCardService.update(id, creditCard)
                .defaultIfEmpty(null);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Mono<Void> deleteByIdCreditCard(@PathVariable Integer id) {
        return creditCardService.delete(id)
                .defaultIfEmpty(null);
    }

}
