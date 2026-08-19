package org.fintechtransfer.repository;

import jakarta.persistence.LockModeType;
import org.fintechtransfer.model.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

    List<WalletEntity> findByUserIdOrderByIdAsc(Long userId);

    Optional<WalletEntity> findByIdAndUserId(Long id, Long userId);

    boolean existsByUserIdAndCurrency(Long userId, String currency);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select w from WalletEntity w join fetch w.user where w.id = :id")
    Optional<WalletEntity> findByIdForUpdate(@Param("id") Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select w from Wallet w join fetch w.user where w.user.email = :email and w.currency = :currency")
    Optional<WalletEntity> findSystemWallet(@Param("email") String ownerEmail, @Param("currency") String currency);
}