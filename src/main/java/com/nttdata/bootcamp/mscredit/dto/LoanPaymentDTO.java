package com.nttdata.bootcamp.mscredit.dto;

import lombok.Data;

@Data
public class LoanPaymentDTO {

    private Integer id;
    private Integer loanId;
    private String description;
    private Double amount;

}
