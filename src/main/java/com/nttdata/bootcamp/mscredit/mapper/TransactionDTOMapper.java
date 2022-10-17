package com.nttdata.bootcamp.mscredit.mapper;

import com.nttdata.bootcamp.mscredit.dto.TransactionDTO;
import com.nttdata.bootcamp.mscredit.model.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class TransactionDTOMapper {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public TransactionDTO convertToDto(Transaction transaction){
        return modelMapper.map(transaction, TransactionDTO.class);
    }
    public Transaction convertToEntity(TransactionDTO transactionDTO) {
        Transaction account = modelMapper.map(transactionDTO, Transaction.class);
        account.setTransactionDate(LocalDateTime.now());
        return account;
    }
}