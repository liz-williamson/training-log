package com.lizw.traininglog.controller;

import com.lizw.traininglog.model.MealEntry;
import com.lizw.traininglog.repository.MealEntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal-entries")
public class MealEntryController {

    private final MealEntryRepository mealEntryRepository;

    public MealEntryController(MealEntryRepository mealEntryRepository) {
        this.mealEntryRepository = mealEntryRepository;
    }

    @GetMapping
    public List<MealEntry> getAllEntries() {
        return mealEntryRepository.findAll();
    }

    @GetMapping("/{id}")
    public MealEntry getEntryById(@PathVariable Long id) {
        return mealEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    @PostMapping
    public MealEntry createEntry(@RequestBody MealEntry mealEntry) {
        return mealEntryRepository.save(mealEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        mealEntryRepository.deleteById(id);
    }

}
