package by.markov.cryptocurrencywatcher.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, message = "Username cannot be less 3 characters")
    private String username;


    @Size(min = 3, message = "Currency symbol cannot be less 3 characters")
    private String symbolOfCurrency;

    private LocalDateTime localDateTime;

    private double priceCurrencyByRegistration;

    private double actualPrice;
}
