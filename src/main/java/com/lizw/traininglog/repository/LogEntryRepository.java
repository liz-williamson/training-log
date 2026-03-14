package com.lizw.traininglog.repository;

import com.lizw.traininglog.model.LogEntry;
import com.lizw.traininglog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
    List<LogEntry> findByUser(User user);
}
