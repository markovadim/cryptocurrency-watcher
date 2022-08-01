package by.markov.cryptocurrencywatcher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(value = "time")
public class CoinDTO {

    @JsonProperty("id")
    private long idCoin;

    private String symbol;

    private String name;

    @JsonProperty("price_usd")
    private double priceUsd;

    private LocalDateTime time;
}
