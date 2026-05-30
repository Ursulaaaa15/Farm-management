package com.example.service.repository;

import com.example.service.model.HarvestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HarvestRecordRepository extends JpaRepository<HarvestRecord, Long> {
    List<HarvestRecord> findByDate(LocalDate date);
    List<HarvestRecord> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
