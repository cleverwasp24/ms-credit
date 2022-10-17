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

@Document(collection = "creditcard")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCard {

    @Id
    @Indexed(unique = true)
    private Integer id;
    @NonNull
    private Integer clientId;
    @NonNull
    @Indexed(unique = true)
    private String creditCardNumber;
    @NonNull
    private Double creditAmount;
    @NonNull
    private LocalDateTime creationDate;

}
