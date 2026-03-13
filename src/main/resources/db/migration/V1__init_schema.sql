CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE log_entry (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    date DATE NOT NULL,
    is_race_day BOOLEAN NOT NULL DEFAULT FALSE,
    meet_name VARCHAR(150),
    notes VARCHAR(255),
    UNIQUE (user_id, date)
);

CREATE TABLE workout_entry (
    id BIGSERIAL PRIMARY KEY,
    log_entry_id BIGINT NOT NULL REFERENCES log_entry(id),
    workout_type VARCHAR(30) NOT NULL,
    distance NUMERIC(10,2),
    duration VARCHAR(11) NOT NULL,
    effort SMALLINT NOT NULL,
    avg_pace VARCHAR(11),
    notes VARCHAR(255)
);

CREATE TABLE wellbeing_entry (
    id BIGSERIAL PRIMARY KEY,
    log_entry_id BIGINT NOT NULL REFERENCES log_entry(id),
    hours_slept NUMERIC(4,1) NOT NULL,
    sleep_quality SMALLINT NOT NULL,
    energy_level SMALLINT NOT NULL,
    soreness SMALLINT NOT NULL,
    mood SMALLINT NOT NULL,
    notes VARCHAR(255)
);

CREATE TABLE nutrition_entry (
    id BIGSERIAL PRIMARY KEY,
    log_entry_id BIGINT NOT NULL REFERENCES log_entry(id),
    num_meals SMALLINT NOT NULL,
    water_oz INTEGER NOT NULL,
    supplements VARCHAR(100),
    notes VARCHAR(255)
);

CREATE TABLE meal_entry (
    id BIGSERIAL PRIMARY KEY,
    nutrition_entry_id BIGINT NOT NULL REFERENCES nutrition_entry(id),
    type VARCHAR(30) NOT NULL,
    time TIME,
    size CHAR(1),
    description VARCHAR(200) NOT NULL,
    quality_rating SMALLINT
);

CREATE TABLE race_result (
    id BIGSERIAL PRIMARY KEY,
    log_entry_id BIGINT NOT NULL REFERENCES log_entry(id),
    event VARCHAR(50) NOT NULL,
    race_type VARCHAR(50) NOT NULL,
    distance NUMERIC(10,2) NOT NULL,
    finish_time VARCHAR(11) NOT NULL,
    is_pr BOOLEAN NOT NULL DEFAULT FALSE,
    place SMALLINT,
    priority CHAR(1),
    notes VARCHAR(255)
);


