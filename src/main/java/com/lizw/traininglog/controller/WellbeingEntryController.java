package com.lizw.traininglog.controller;

import com.lizw.traininglog.model.WellbeingEntry;
import com.lizw.traininglog.repository.WellbeingEntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wellbeing-entries")
public class WellbeingEntryController {

    private final WellbeingEntryRepository wellbeingEntryRepository;

    public WellbeingEntryController(WellbeingEntryRepository wellbeingEntryRepository) {
        this.wellbeingEntryRepository = wellbeingEntryRepository;
    }

    @GetMapping
    public List<WellbeingEntry> getAllEntries() {
        return wellbeingEntryRepository.findAll();
    }

    @GetMapping("/{id}")
    public WellbeingEntry getEntryById(@PathVariable Long id) {
        return wellbeingEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    @PostMapping
    public WellbeingEntry createEntry(@RequestBody WellbeingEntry wellbeingEntry) {
        return wellbeingEntryRepository.save(wellbeingEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        wellbeingEntryRepository.deleteById(id);
    }

}
