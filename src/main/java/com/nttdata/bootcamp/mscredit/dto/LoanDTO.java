package com.nttdata.bootcamp.mscredit.dto;

import lombok.Data;

@Data
public class LoanDTO {

    private Integer id;
    private Integer clientId;
    private String debtAmount;
    private Integer installments;

}
