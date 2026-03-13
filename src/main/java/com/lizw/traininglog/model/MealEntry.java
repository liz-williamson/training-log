package com.lizw.traininglog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "meal_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nutrition_entry_id", nullable = false)
    private NutritionEntry nutritionEntry;

    @Column(nullable = false)
    private String type;

    private LocalTime time;

    private Character size;

    @Column(nullable = false)
    private String description;

    private Short qualityRating;

}
