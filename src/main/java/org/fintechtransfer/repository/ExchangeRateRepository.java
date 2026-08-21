package org.fintechtransfer.repository;

import org.fintechtransfer.model.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

    Optional<ExchangeRateEntity> findByBaseCurrencyAndQuoteCurrency(String baseCurrency, String quoteCurrency);

    List<ExchangeRateEntity> findByBaseCurrencyOrderByQuoteCurrency(String baseCurrency);
}
