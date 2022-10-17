package com.nttdata.bootcamp.mscredit.infrastructure;

import com.nttdata.bootcamp.mscredit.model.Loan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends ReactiveMongoRepository<Loan, Integer> {
}
