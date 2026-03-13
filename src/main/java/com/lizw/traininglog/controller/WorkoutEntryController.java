package com.lizw.traininglog.controller;

import com.lizw.traininglog.model.WorkoutEntry;
import com.lizw.traininglog.repository.WorkoutEntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workout-entries")
public class WorkoutEntryController {

    private final WorkoutEntryRepository workoutEntryRepository;

    public WorkoutEntryController(WorkoutEntryRepository workoutEntryRepository) {
        this.workoutEntryRepository = workoutEntryRepository;
    }

    @GetMapping
    public List<WorkoutEntry> getAllEntries() {
        return workoutEntryRepository.findAll();
    }

    @GetMapping("/{id}")
    public WorkoutEntry getEntryById(@PathVariable Long id) {
        return workoutEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    @PostMapping
    public WorkoutEntry createEntry(@RequestBody WorkoutEntry workoutEntry) {
        return workoutEntryRepository.save(workoutEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        workoutEntryRepository.deleteById(id);
    }
}
