package by.markov.cryptocurrencywatcher.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCoin;

    private String symbol;

    private String name;

    private double priceUsd;

    private LocalDateTime time;
}
