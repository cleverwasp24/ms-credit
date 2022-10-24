package com.nttdata.bootcamp.mscredit.infrastructure;

import com.nttdata.bootcamp.mscredit.model.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, Integer> {

    Flux<Transaction> findAllByCreditCardId(Integer id);
}
