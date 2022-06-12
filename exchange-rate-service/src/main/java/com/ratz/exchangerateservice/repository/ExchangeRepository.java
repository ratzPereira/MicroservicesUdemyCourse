package com.ratz.exchangerateservice.repository;

import com.ratz.exchangerateservice.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

  Exchange findByFromAndTo (String from, String to);
}
