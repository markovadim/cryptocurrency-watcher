package by.markov.cryptocurrencywatcher.entities;


import lombok.*;

import javax.persistence.*;
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

    private String username;

    private String symbolOfCurrency;

    private LocalDateTime localDateTime;

    private double priceCurrencyByRegistration;

    private double actualPrice;
}
