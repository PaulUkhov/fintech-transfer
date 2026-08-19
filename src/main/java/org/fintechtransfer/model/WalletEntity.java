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
@Table(name = "wallets",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "currency"})
        })
@Entity
public class WalletEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false, precision = 28, scale = 12)
    private BigDecimal balance;

    @Column(nullable = false, length = 16)
    private WalletStatus status;

    @Column(nullable = false)
    private long version;
}
