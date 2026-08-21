package org.fintechtransfer.model;

import jakarta.persistence.*;
import lombok.*;
import org.fintechtransfer.config.Auditable;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "exchange_rates",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"base_currency", "quote_currency"})

        })
public class ExchangeRateEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_currency", nullable = false, length = 3)
    private String baseCurrency;

    @Column(name = "quote_currency", nullable = false, length = 3)
    private String quoteCurrency;

    @Column(nullable = false, precision = 28, scale = 12)
    private BigDecimal rate;

}
