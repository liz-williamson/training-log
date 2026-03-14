package com.lizw.traininglog.repository;

import com.lizw.traininglog.model.MealEntry;
import com.lizw.traininglog.model.NutritionEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealEntryRepository extends JpaRepository<MealEntry, Long> {
    List<MealEntry> findByNutritionEntry(NutritionEntry nutritionEntry);
}
