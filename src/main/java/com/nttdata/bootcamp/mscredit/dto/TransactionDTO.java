package com.nttdata.bootcamp.mscredit.dto;

import lombok.Data;

@Data
public class TransactionDTO {

    private Integer id;
    private Integer creditCardId;
    private Integer transactionType;
    private String description;
    private Double amount;

}