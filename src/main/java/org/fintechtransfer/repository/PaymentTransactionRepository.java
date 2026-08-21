package org.fintechtransfer.repository;

import jakarta.persistence.LockModeType;
import org.fintechtransfer.model.PaymentTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransactionEntity, Long> {

    Optional<PaymentTransactionEntity> findByIdAndUserId(Long id, Long userId);

    Optional<PaymentTransactionEntity> findByIdempotencyKey(String idempotencyKey);

    List<PaymentTransactionEntity> findByUserIdOrderByCreatedAtDesc(Long userId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from PaymentTransactionEntity p join fetch p.wallet join fetch p.user where p.id = :id")
    Optional<PaymentTransactionEntity> findByIdForUpdate(@Param("id") Long id);
}
