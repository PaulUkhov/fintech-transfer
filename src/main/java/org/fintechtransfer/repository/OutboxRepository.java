package org.fintechtransfer.repository;


import org.fintechtransfer.model.OutboxEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Repository
public interface OutboxRepository extends JpaRepository<OutboxEventEntity, Long> {

    /**
     * Claims a batch of pending events, atomically removing them from the
     * concurrent pollers via SELECT ... FOR UPDATE SKIP LOCKED.
     */
    @Query(value = """
            select * from outbox_events
            where status = 'PENDING' and available_at <= :now
            order by id
            limit :limit
            for update skip locked
            """, nativeQuery = true)
    List<OutboxEventEntity> lockNextBatch(@Param("now") Instant now, @Param("limit") int limit);

    long countByStatus(OutboxEventEntity status);

    Optional<OutboxEventEntity> findFirstByEventTypeOrderByIdDesc(String eventType);
}
