package com.nttdata.bootcamp.mscredit.infrastructure;

import com.nttdata.bootcamp.mscredit.model.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, Integer> {
}
