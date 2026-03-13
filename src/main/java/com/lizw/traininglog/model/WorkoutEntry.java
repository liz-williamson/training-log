package com.lizw.traininglog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "workout_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "log_entry_id", nullable = false)
    private LogEntry logEntry;

    @Column(nullable = false)
    private String workoutType;

    private BigDecimal distance;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private Short effort;

    private String avgPace;

    private String notes;
}
