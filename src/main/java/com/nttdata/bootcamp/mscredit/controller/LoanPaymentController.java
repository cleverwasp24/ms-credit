package com.nttdata.bootcamp.mscredit.controller;

import com.nttdata.bootcamp.mscredit.dto.LoanPaymentDTO;
import com.nttdata.bootcamp.mscredit.mapper.LoanPaymentDTOMapper;
import com.nttdata.bootcamp.mscredit.model.LoanPayment;
import com.nttdata.bootcamp.mscredit.service.impl.LoanPaymentServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("/bootcamp/loanPayment")
public class LoanPaymentController {

    @Autowired
    LoanPaymentServiceImpl loanPaymentService;

    @GetMapping(value = "/findAllLoanPayments")
    @ResponseBody
    public Flux<LoanPayment> findAllLoanPayments() {
        return loanPaymentService.findAll();
    }

    @PostMapping(value = "/createLoanPayment")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<LoanPaymentDTO> createLoanPayment(@RequestBody LoanPaymentDTO loanPaymentDTO) {
        return loanPaymentService.createLoanPayment(loanPaymentDTO);
    }

    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public Mono<LoanPayment> findLoanPaymentById(@PathVariable Integer id) {
        return loanPaymentService.findById(id)
                .defaultIfEmpty(null);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Mono<LoanPayment> updateLoanPayment(@PathVariable Integer id, @RequestBody LoanPayment loanPayment) {
        return loanPaymentService.update(id, loanPayment)
                .defaultIfEmpty(null);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Mono<Void> deleteByIdLoanPayment(@PathVariable Integer id) {
        return loanPaymentService.delete(id)
                .defaultIfEmpty(null);
    }
}
