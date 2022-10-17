package com.nttdata.bootcamp.mscredit.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "loanpayment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanPayment {

    @Id
    @Indexed(unique = true)
    private Integer id;
    @NonNull
    private Integer loanId;
    @NonNull
    private String description;
    @NonNull
    private Double amount;
    @NonNull
    private LocalDateTime transactionDate;

}
