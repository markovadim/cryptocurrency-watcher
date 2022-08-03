package by.markov.cryptocurrencywatcher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Size(min = 3, message = "Username cannot be less 3 characters")
    private String username;

    @Size(min = 3, message = "Currency symbol cannot be less 3 characters")
    private String symbol;
}
