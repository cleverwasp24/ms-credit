package com.nttdata.bootcamp.mscredit.service.impl;

import com.nttdata.bootcamp.mscredit.dto.CreditCardDTO;
import com.nttdata.bootcamp.mscredit.infrastructure.CreditCardRepository;
import com.nttdata.bootcamp.mscredit.mapper.CreditCardDTOMapper;
import com.nttdata.bootcamp.mscredit.model.CreditCard;
import com.nttdata.bootcamp.mscredit.service.CreditCardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    private CreditCardDTOMapper creditCardDTOMapper = new CreditCardDTOMapper();

    @Override
    public Flux<CreditCard> findAll() {
        log.info("Listing all credit cards");
        return creditCardRepository.findAll();
    }

    @Override
    public Mono<CreditCard> create(CreditCard creditCard) {
        log.info("Creating credit card: " + creditCard.toString());
        return creditCardRepository.save(creditCard);
    }

    @Override
    public Mono<CreditCard> findById(Integer id) {
        log.info("Searching credit card by id: " + id);
        return creditCardRepository.findById(id);
    }

    @Override
    public Mono<CreditCard> update(Integer id, CreditCard creditCard) {
        log.info("Updating credit card with id: " + id + " with : " + creditCard.toString());
        return creditCardRepository.findById(id)
                .flatMap(savedCreditCard -> {
                    savedCreditCard.setClientId(creditCard.getClientId());
                    savedCreditCard.setCreditCardNumber(creditCard.getCreditCardNumber());
                    savedCreditCard.setCreditAmount(creditCard.getCreditAmount());
                    savedCreditCard.setCreationDate(creditCard.getCreationDate());
                    return creditCardRepository.save(savedCreditCard);
                });
    }

    @Override
    public Mono<Void> delete(Integer id) {
        log.info("Deleting credit card with id: " + id);
        return creditCardRepository.deleteById(id);
    }

    @Override
    public Mono<CreditCardDTO> createCreditCard(CreditCardDTO creditCardDTO) {
        log.info("Creating credit card: " + creditCardDTO.toString());
        CreditCard creditCard = creditCardDTOMapper.convertToEntity(creditCardDTO);
        return creditCardRepository.save(creditCard)
                .map(c -> creditCardDTOMapper.convertToDto(c));
    }

}
