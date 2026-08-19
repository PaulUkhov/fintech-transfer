package org.fintechtransfer.repository;

import jakarta.persistence.LockModeType;
import org.fintechtransfer.model.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

    Optional<TransferEntity> findByIdAndUserId(Long id, Long userId);

    List<TransferEntity> findByUserIdOrderByCreatedAtDesc(Long userId);

    Optional<TransferEntity> findByIdempotencyKey(String idempotencyKey);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select t from TransferEntity t join fetch t.fromWallet where t.id = :id")
    Optional<TransferEntity> findByIdForUpdate(@Param("id") Long id);
}
