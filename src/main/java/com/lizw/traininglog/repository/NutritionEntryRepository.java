package com.lizw.traininglog.repository;

import com.lizw.traininglog.model.LogEntry;
import com.lizw.traininglog.model.NutritionEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionEntryRepository extends JpaRepository<NutritionEntry, Long> {
    List<NutritionEntry> findByLogEntry(LogEntry logEntry);
}
