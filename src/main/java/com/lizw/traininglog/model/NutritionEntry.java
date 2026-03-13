package com.lizw.traininglog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nutrition_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "log_entry_id", nullable = false)
    private LogEntry logEntry;

    @Column(nullable = false)
    private Short numMeals;

    @Column(nullable = false)
    private Integer waterOz;

    private String supplements;

    private String notes;
}
