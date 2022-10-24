package com.nttdata.bootcamp.mscredit.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "loan")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan {

    @Id
    private Integer id;
    @NonNull
    @Indexed(unique = true)
    private String loanCode;
    @NonNull
    private Integer clientId;
    @NonNull
    private Integer loanType;
    @NonNull
    private Double totalDebt;
    @NonNull
    private Double pendingDebt;
    @NonNull
    private Integer installments;
    @NonNull
    private LocalDateTime loanDate;

}
