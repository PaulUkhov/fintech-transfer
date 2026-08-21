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
@Table(name = "ledger_entries",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"wallet_id", "operation_key"})
        })

public class LedgerEntryEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private WalletEntity wallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transfer_id")
    private TransferEntity transfer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentTransactionEntity paymentTransaction;

    @Column(name = "entry_type", nullable = false, length = 8)
    private EntryType type;

    @Column(nullable = false, precision = 28, scale = 12)
    private BigDecimal amount;

    @Column(nullable = false, precision = 28, scale = 12)
    private BigDecimal balanceAfter;
    @Column(nullable = false, length = 3)
    private String currency;

    @Lob
    @Column(length = 500)
    private String description;

    @Column(name = "operation_key", length = 120, nullable = false)
    private String operationKey;

}
