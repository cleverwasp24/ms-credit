package com.nttdata.bootcamp.mscredit.controller;

import com.nttdata.bootcamp.mscredit.dto.LoanDTO;
import com.nttdata.bootcamp.mscredit.model.Loan;
import com.nttdata.bootcamp.mscredit.service.impl.LoanServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("/bootcamp/loan")
public class LoanController {

    @Autowired
    LoanServiceImpl loanService;

    @GetMapping(value = "/findAllLoans")
    @ResponseBody
    public Flux<Loan> findAllLoans() {
        return loanService.findAll();
    }

    @PostMapping(value = "/createSavingsLoan")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<LoanDTO> createPersonalLoan(@RequestBody LoanDTO loanDTO) {
        return loanService.createPersonalLoan(loanDTO);
    }

    @PostMapping(value = "/createBusinessLoan")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<LoanDTO> createBusinessLoan(@RequestBody LoanDTO loanDTO) {
        return loanService.createBusinessLoan(loanDTO);
    }

    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public Mono<Loan> findLoanById(@PathVariable Integer id) {
        return loanService.findById(id)
                .defaultIfEmpty(null);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Mono<Loan> updateLoan(@PathVariable Integer id, @RequestBody Loan loan) {
        return loanService.update(id, loan)
                .defaultIfEmpty(null);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Mono<Void> deleteByIdLoan(@PathVariable Integer id) {
        return loanService.delete(id)
                .defaultIfEmpty(null);
    }

}
