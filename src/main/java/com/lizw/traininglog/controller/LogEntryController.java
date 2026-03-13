package com.lizw.traininglog.controller;

import com.lizw.traininglog.model.LogEntry;
import com.lizw.traininglog.repository.LogEntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/log-entries")
public class LogEntryController {

    private final LogEntryRepository logEntryRepository;

    public LogEntryController(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @GetMapping
    public List<LogEntry> getAllEntries() {
        return logEntryRepository.findAll();
    }

    @GetMapping("/{id}")
    public LogEntry getEntryById(@PathVariable Long id) {
        return logEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    @PostMapping
    public LogEntry createEntry(@RequestBody LogEntry logEntry) {
        return logEntryRepository.save(logEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        logEntryRepository.deleteById(id);
    }

}
