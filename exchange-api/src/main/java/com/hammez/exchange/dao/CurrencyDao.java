package com.hammez.exchange.dao;

import com.hammez.exchange.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyDao extends JpaRepository<Currency, Long> {
}
