package com.lizw.traininglog.controller;

import com.lizw.traininglog.model.RaceResult;
import com.lizw.traininglog.repository.RaceResultRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/race-results")
public class RaceResultController {

    private final RaceResultRepository raceResultRepository;

    public RaceResultController(RaceResultRepository raceResultRepository) {
        this.raceResultRepository = raceResultRepository;
    }

    @GetMapping
    public List<RaceResult> getAllEntries() {
        return raceResultRepository.findAll();
    }

    @GetMapping("/{id}")
    public RaceResult getEntryById(@PathVariable Long id) {
        return raceResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    @PostMapping
    public RaceResult createEntry(@RequestBody RaceResult raceResult) {
        return raceResultRepository.save(raceResult);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        raceResultRepository.deleteById(id);
    }

}
