package com.lizw.traininglog.repository;

import com.lizw.traininglog.model.LogEntry;
import com.lizw.traininglog.model.WellbeingEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WellbeingEntryRepository extends JpaRepository<WellbeingEntry, Long> {
    List<WellbeingEntry> findByLogEntry(LogEntry logEntry);
}
