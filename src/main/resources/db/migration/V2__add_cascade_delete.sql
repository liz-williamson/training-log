ALTER TABLE workout_entry
    DROP CONSTRAINT workout_entry_log_entry_id_fkey,
    ADD CONSTRAINT workout_entry_log_entry_id_fkey
    FOREIGN KEY (log_entry_id) REFERENCES log_entry(id) ON DELETE CASCADE;

ALTER TABLE wellbeing_entry
    DROP CONSTRAINT wellbeing_entry_log_entry_id_fkey,
    ADD CONSTRAINT wellbeing_entry_log_entry_id_fkey
    FOREIGN KEY (log_entry_id) REFERENCES log_entry(id) ON DELETE CASCADE;

ALTER TABLE nutrition_entry
    DROP CONSTRAINT nutrition_entry_log_entry_id_fkey,
    ADD CONSTRAINT nutrition_entry_log_entry_id_fkey
    FOREIGN KEY (log_entry_id) REFERENCES log_entry(id) ON DELETE CASCADE;

ALTER TABLE race_result
    DROP CONSTRAINT race_result_log_entry_id_fkey,
    ADD CONSTRAINT race_result_log_entry_id_fkey
    FOREIGN KEY (log_entry_id) REFERENCES log_entry(id) ON DELETE CASCADE;

ALTER TABLE meal_entry
    DROP CONSTRAINT meal_entry_nutrition_entry_id_fkey,
    ADD CONSTRAINT meal_entry_nutrition_entry_id_fkey
    FOREIGN KEY (nutrition_entry_id) REFERENCES nutrition_entry(id) ON DELETE CASCADE;
