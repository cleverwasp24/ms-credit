package com.nttdata.bootcamp.mscredit.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

    @Id
    @Indexed(unique = true)
    private Integer id;
    @NonNull
    private Integer creditCardId;
    @NonNull
    private Integer transactionType;// 1 - CONSUMO DE TARJETA / 2 - PAGO DE TARJETA
    @NonNull
    private String description;
    @NonNull
    private Double amount;
    @NonNull
    private LocalDateTime transactionDate;

}
