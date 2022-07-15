package by.markov.cryptocurrencywatcher.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "time")
public class Coin {

    @Id
    @JsonProperty("id")
    private long idCoin;

    private String symbol;

    private String name;

    @JsonProperty("price_usd")
    private double priceUsd;

    private LocalDateTime time;
}
