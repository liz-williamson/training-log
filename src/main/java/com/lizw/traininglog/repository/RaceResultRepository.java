package com.lizw.traininglog.repository;

import com.lizw.traininglog.model.LogEntry;
import com.lizw.traininglog.model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
    List<RaceResult> findByLogEntry(LogEntry logEntry);
}
