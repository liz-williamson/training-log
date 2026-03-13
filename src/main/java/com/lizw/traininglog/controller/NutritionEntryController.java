package com.lizw.traininglog.controller;

import com.lizw.traininglog.model.NutritionEntry;
import com.lizw.traininglog.repository.NutritionEntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition-entries")
public class NutritionEntryController {

    private final NutritionEntryRepository nutritionEntryRepository;

    public NutritionEntryController(NutritionEntryRepository nutritionEntryRepository) {
        this.nutritionEntryRepository = nutritionEntryRepository;
    }

    @GetMapping
    public List<NutritionEntry> getAllEntries() {
        return nutritionEntryRepository.findAll();
    }

    @GetMapping("/{id}")
    public NutritionEntry getEntryById(@PathVariable Long id) {
        return nutritionEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    @PostMapping
    public NutritionEntry createEntry(@RequestBody NutritionEntry nutritionEntry) {
        return nutritionEntryRepository.save(nutritionEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        nutritionEntryRepository.deleteById(id);
    }

}
