package com.lizw.traininglog.repository;

import com.lizw.traininglog.model.LogEntry;
import com.lizw.traininglog.model.WorkoutEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutEntryRepository extends JpaRepository<WorkoutEntry, Long> {
    List<WorkoutEntry> findByLogEntry(LogEntry logEntry);
}
