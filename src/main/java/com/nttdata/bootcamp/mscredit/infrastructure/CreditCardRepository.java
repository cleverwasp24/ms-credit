package com.nttdata.bootcamp.mscredit.infrastructure;

import com.nttdata.bootcamp.mscredit.model.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, Integer> {

    Flux<CreditCard> findAllByClientId(Integer id);

}
