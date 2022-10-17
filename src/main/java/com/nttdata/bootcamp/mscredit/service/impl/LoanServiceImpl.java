package com.nttdata.bootcamp.mscredit.service.impl;

import com.nttdata.bootcamp.mscredit.dto.LoanDTO;
import com.nttdata.bootcamp.mscredit.infrastructure.LoanRepository;
import com.nttdata.bootcamp.mscredit.mapper.LoanDTOMapper;
import com.nttdata.bootcamp.mscredit.model.Loan;
import com.nttdata.bootcamp.mscredit.model.enums.LoanTypeEnum;
import com.nttdata.bootcamp.mscredit.service.LoanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    private LoanDTOMapper loanDTOMapper = new LoanDTOMapper();

    @Override
    public Flux<Loan> findAll() {
        log.info("Listing all loans");
        return loanRepository.findAll();
    }

    @Override
    public Mono<Loan> create(Loan loan) {
        log.info("Creating loan: " + loan.toString());
        return loanRepository.save(loan);
    }

    @Override
    public Mono<Loan> findById(Integer id) {
        log.info("Searching loan by id: " + id);
        return loanRepository.findById(id);
    }

    @Override
    public Mono<Loan> update(Integer id, Loan loan) {
        log.info("Updating loan with id: " + id + " with : " + loan.toString());
        return loanRepository.findById(id)
                .flatMap(savedLoan -> {
                    savedLoan.setClientId(loan.getClientId());
                    savedLoan.setLoanType(loan.getLoanType());
                    savedLoan.setDebtAmount(loan.getDebtAmount());
                    savedLoan.setInstallments(loan.getInstallments());
                    savedLoan.setLoanDate(loan.getLoanDate());
                    return loanRepository.save(savedLoan);
                });
    }

    @Override
    public Mono<Void> delete(Integer id) {
        log.info("Deleting loan with id: " + id);
        return loanRepository.deleteById(id);
    }

    @Override
    public Mono<LoanDTO> createPersonalLoan(LoanDTO loanDTO) {
        log.info("Creating personal loan: " + loanDTO.toString());
        Loan loan = loanDTOMapper.convertToEntity(loanDTO, LoanTypeEnum.PERSONAL);
        return loanRepository.save(loan)
                .map(c -> loanDTOMapper.convertToDto(c));
    }

    @Override
    public Mono<LoanDTO> createBusinessLoan(LoanDTO loanDTO) {
        log.info("Creating business loan: " + loanDTO.toString());
        Loan loan = loanDTOMapper.convertToEntity(loanDTO, LoanTypeEnum.BUSINESS);
        return loanRepository.save(loan)
                .map(c -> loanDTOMapper.convertToDto(c));
    }

}
