package com.nttdata.bootcamp.mscredit.model;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
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
    @Indexed(unique = true)
    private Integer id;
    @NonNull
    private Integer clientId;
    @NonNull
    private Integer loanType; // 0 - CREDITO PERSONAL, 1 - CREDITO EMPRESARIAL
    @NonNull
    private Double debtAmount;
    @NonNull
    private Integer installments;
    @NonNull
    private LocalDateTime loanDate;

}
