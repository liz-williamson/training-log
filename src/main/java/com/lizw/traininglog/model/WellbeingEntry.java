package com.lizw.traininglog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "wellbeing_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WellbeingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "log_entry_id", nullable = false)
    private LogEntry logEntry;

    @Column(nullable = false)
    private BigDecimal hoursSlept;

    @Column(nullable = false)
    private Short sleepQuality;

    @Column(nullable = false)
    private Short energyLevel;

    @Column(nullable = false)
    private Short soreness;

    @Column(nullable = false)
    private Short mood;

    private String notes;
}
