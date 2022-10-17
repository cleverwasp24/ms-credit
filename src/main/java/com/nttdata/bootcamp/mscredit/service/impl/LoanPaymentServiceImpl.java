package com.nttdata.bootcamp.mscredit.service.impl;

import com.nttdata.bootcamp.mscredit.dto.LoanPaymentDTO;
import com.nttdata.bootcamp.mscredit.dto.LoanPaymentDTO;
import com.nttdata.bootcamp.mscredit.infrastructure.LoanPaymentRepository;
import com.nttdata.bootcamp.mscredit.mapper.LoanPaymentDTOMapper;
import com.nttdata.bootcamp.mscredit.model.LoanPayment;
import com.nttdata.bootcamp.mscredit.model.LoanPayment;
import com.nttdata.bootcamp.mscredit.service.LoanPaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class LoanPaymentServiceImpl implements LoanPaymentService {

    @Autowired
    private LoanPaymentRepository loanPaymentRepository;

    private LoanPaymentDTOMapper loanPaymentDTOMapper = new LoanPaymentDTOMapper();

    @Override
    public Flux<LoanPayment> findAll() {
        log.info("Listing all loan payments");
        return loanPaymentRepository.findAll();
    }

    @Override
    public Mono<LoanPayment> create(LoanPayment loanPayment) {
        log.info("Creating loan payment: " + loanPayment.toString());
        return loanPaymentRepository.save(loanPayment);
    }

    @Override
    public Mono<LoanPayment> findById(Integer id) {
        log.info("Searching loan payment by id: " + id);
        return loanPaymentRepository.findById(id);
    }

    @Override
    public Mono<LoanPayment> update(Integer id, LoanPayment loanPayment) {
        log.info("Updating loan payment with id: " + id + " with : " + loanPayment.toString());
        return loanPaymentRepository.findById(id)
                .flatMap(savedLoanPayment -> {
                    savedLoanPayment.setLoanId(loanPayment.getLoanId());
                    savedLoanPayment.setDescription(loanPayment.getDescription());
                    savedLoanPayment.setAmount(loanPayment.getAmount());
                    savedLoanPayment.setTransactionDate(loanPayment.getTransactionDate());
                    return loanPaymentRepository.save(savedLoanPayment);
                });
    }

    @Override
    public Mono<Void> delete(Integer id) {
        log.info("Deleting loan payment with id: " + id);
        return loanPaymentRepository.deleteById(id);
    }

    @Override
    public Mono<LoanPaymentDTO> createLoanPayment(LoanPaymentDTO loanPaymentDTO) {
        log.info("Creating loan payment: " + loanPaymentDTO.toString());
        LoanPayment loanPayment = loanPaymentDTOMapper.convertToEntity(loanPaymentDTO);
        return loanPaymentRepository.save(loanPayment)
                .map(c -> loanPaymentDTOMapper.convertToDto(c));
    }
}
