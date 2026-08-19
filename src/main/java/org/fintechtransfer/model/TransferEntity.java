package org.fintechtransfer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.fintechtransfer.config.Auditable;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class TransferEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String idempotencyKey;
    BigDecimal amount;
    BigDecimal fee;
    TransferStatus status;
}
