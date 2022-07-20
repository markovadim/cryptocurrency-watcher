package by.markov.cryptocurrencywatcher.dao;

import by.markov.cryptocurrencywatcher.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
