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
@Table(name = "payment_transaction")

public class PaymentTransactionEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private WalletEntity wallet;

    @Column(name = "type", nullable = false, length = 16)
    private PaymentType paymentType;

    @Column(nullable = false, precision = 28, scale = 12)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false, length = 16)
    private PaymentStatus status;

    @Column(name = "external_payment_id", length = 64)
    private String externalPaymentId;

    @Lob
    @Column(name = "failure_reason", length = 1000)
    private String failureReason;

    @Column(nullable = false)
    private Integer attempts;

    @Version
    @Column(nullable = false)
    private Long version;

}
