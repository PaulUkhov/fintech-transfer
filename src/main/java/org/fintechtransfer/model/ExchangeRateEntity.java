package org.fintechtransfer.model;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_currency", nullable = false, length = 3, updatable = false)
    private String baseCurrency;

    @Column(name = "quote_currency", nullable = false, length = 3, updatable = false)
    private String quoteCurrency;

    @Column(nullable = false, precision = 28, scale = 12)
    private BigDecimal rate;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt = Instant.now();

    @PrePersist
    @PreUpdate
    void onPersist() {
        updatedAt = Instant.now();
    }

    public Long getId() { return id; }
    public String getBaseCurrency() { return baseCurrency; }
    public void setBaseCurrency(String baseCurrency) { this.baseCurrency = baseCurrency; }
    public String getQuoteCurrency() { return quoteCurrency; }
    public void setQuoteCurrency(String quoteCurrency) { this.quoteCurrency = quoteCurrency; }
    public BigDecimal getRate() { return rate; }
    public void setRate(BigDecimal rate) { this.rate = rate; }
    public Instant getUpdatedAt() { return updatedAt; }
}
