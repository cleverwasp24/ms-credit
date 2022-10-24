package com.nttdata.bootcamp.mscredit.dto;

import lombok.Data;

@Data
public class LoanDTO {

    private Integer id;
    private String loanCode;
    private Integer clientId;
    private Double totalDebt;
    private Integer installments;

}
