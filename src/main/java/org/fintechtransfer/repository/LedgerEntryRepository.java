package org.fintechtransfer.repository;

import org.fintechtransfer.model.LedgerEntryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntryEntity, Long> {

    Page<LedgerEntryEntity> findByWalletIdOrderByCreatedAtDescIdDesc(Long walletId, Pageable pageable);

    Optional<LedgerEntryEntity> findFirstByWalletIdOrderByIdDesc(Long walletId);

    boolean existsByWalletIdAndOperationKey(Long walletId, String operationKey);
}
