-- Creating a new database

CREATE DATABASE fitness_tracker;
SHOW DATABASES;
USE fitness_tracker;

-- Creating tables

-- Table 1 - This table stores user information, including login details and account creation date.

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    age INT NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    CHECK (age>=12)
);

-- Table 2 - This table holds information about different workout plans created by users.

CREATE TABLE Workouts (
    workout_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    workout_name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);


-- Table 3 - This table contains details of various exercises that can be included in workout sessions.

CREATE TABLE Exercises (
    exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    exercise_name VARCHAR(100) NOT NULL,
    description TEXT,
    category VARCHAR(50),
    muscle_group VARCHAR(50)
);


-- Table 4 - This table records each workout session, including details like duration, calories burned, and the date of the session.

CREATE TABLE Workout_Sessions (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    workout_id INT,
    exercise_id INT,
    duration_minutes INT,
    calories_burned INT,
    session_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (workout_id) REFERENCES Workouts(workout_id),
    FOREIGN KEY (exercise_id) REFERENCES Exercises(exercise_id)
);

-- Inserting values

INSERT INTO Users (username,age, email, password, created_at, last_login) VALUES
('jessica_l', 21,'jessica@example.com', 'password123', '2024-01-01 08:00:00', '2024-05-17 07:30:00'),
('jane_smith', 16,'jane@example.com', 'securepass', '2024-01-10 09:15:00', '2024-05-16 14:45:00'),
('john_doe', 14,'john@example.com', 'alicepwd', '2024-02-20 12:00:00', '2024-05-18 10:00:00'),
('bob_brown', 15,'bob@example.com', 'bobpass123', '2024-03-05 10:30:00', '2024-05-17 09:00:00'),
('carol_j',18, 'carol@example.com', 'carolpassword', '2024-03-25 14:45:00', '2024-05-15 16:30:00'),
('dave_m',14, 'dave@example.com', 'davepassword', '2024-04-01 08:30:00', '2024-05-17 12:00:00'),
('emma_t',17, 'emma@example.com', 'emmapass', '2024-04-10 11:15:00', '2024-05-18 14:00:00'),
('frank_g',22, 'frank@example.com', 'frankpass', '2024-04-20 15:00:00', '2024-05-17 16:30:00'),
('grace_l',24, 'grace@example.com', 'gracepwd', '2024-04-25 09:00:00', '2024-05-16 10:45:00'),
('henry_o', 28,'henry@example.com', 'henrypass', '2024-05-01 10:15:00', '2024-05-15 08:30:00');

INSERT INTO Workouts (user_id, workout_name, description, created_at) VALUES
(1, 'Morning Routine', 'A basic morning workout routine.', '2024-05-01 06:00:00'),
(2, 'Evening Yoga', 'Relaxing yoga session to end the day.', '2024-05-02 18:30:00'),
(3, 'Strength Training', 'Full body strength training.', '2024-05-03 08:00:00'),
(4, 'Cardio Blast', 'High intensity cardio workout.', '2024-05-04 07:00:00'),
(5, 'Core Workout', 'Exercises focused on the core muscles.', '2024-05-05 09:00:00'),
(3, 'Morning Routine', 'A basic morning workout routine.', '2024-05-10 06:00:00'),
(4, 'Core Workout', 'Exercises focused on the core muscles.', '2024-05-11 18:30:00'),
(1, 'Evening Yoga', 'Relaxing yoga session to end the day.', '2024-05-12 08:00:00'),
(5, 'Strength Training', 'Full body strength training.', '2024-05-13 07:00:00'),
(2, 'Cardio Blast', 'High intensity cardio workout.', '2024-05-14 09:00:00');

INSERT INTO Exercises (exercise_name, description, category, muscle_group) VALUES
('Push-ups', 'Standard push-ups.', 'Strength', 'Chest'),
('Squats', 'Bodyweight squats.', 'Strength', 'Legs'),
('Running', 'Jogging or running.', 'Cardio', 'Legs'),
('Plank', 'Holding plank position.', 'Core', 'Core'),
('Bicep Curls', 'Using dumbbells for curls.', 'Strength', 'Arms'),
('Bench-Press', 'Using dumbbells for press.', 'Strength', 'Chest'),
('Sumo Squats', 'Using dumbells squats.', 'Strength', 'Legs'),
('Treadmill', 'Jogging or running.', 'Cardio', 'Legs'),
('Weighted Plank', 'Holding plank position.', 'Core', 'Core'),
('Hammer Curls', 'Using dumbbells for curls.', 'Strength', 'Arms');

INSERT INTO Workout_Sessions (workout_id, exercise_id, duration_minutes, calories_burned, session_date) VALUES
(2, 1, 10, 50, '2024-05-10 06:30:00'),
(3, 2, 15, 70, '2024-05-11 06:45:00'),
(4, 1, 30, 200, '2024-05-12 19:00:00'),
(5, 4, 10, 40, '2024-05-13 08:30:00'),
(1, 8, 20, 100, '2024-05-14 07:30:00'),
(2, 1, 10, 50, '2024-05-10 06:30:00'),
(3, 7, 15, 70, '2024-05-11 06:45:00'),
(4, 10, 30, 200, '2024-05-12 19:00:00'),
(5, 9, 10, 40, '2024-05-13 08:30:00'),
(1, 5, 20, 100, '2024-05-14 07:30:00');

-- SELECT DISTINCT - This query returns a list of unique workout names from the Workouts table.
SELECT DISTINCT workout_name 
FROM Workouts;

-- WHERE - This query retrieves all workouts created by the user with user_id 1.
SELECT * FROM Workouts 
WHERE user_id = 1;

-- AND and OR - This query retrieves all workouts created by the user with user_id 1 that are named 'Morning Routine' or any workout named 'Evening Yoga' regardless of the user_id.
SELECT * FROM Workouts 
WHERE user_id = 1 AND workout_name = 'Morning Routine' 
OR workout_name = 'Evening Yoga';

-- ORDER BY - This query retrieves all workouts, ordering them by their creation date in descending order, with the most recent workouts listed first.
SELECT * FROM workouts
ORDER BY created_at DESC;

-- UPDATE - This query updates the description of the workout named 'Morning Routine' created by the user with user_id 1.
UPDATE Workouts 
SET description = 'A refreshing morning routine to kickstart your day' 
WHERE workout_name = 'Morning Routine' AND user_id = 1;

-- DELETE - This query deletes the workout named 'Cardio Blast' created by the user with user_id 2 from the Workouts table.
DELETE FROM Workouts 
WHERE workout_name = 'Cardio Blast' AND user_id = 2;

-- LIMIT - This query retrieves only the top 5 rows.
SELECT * FROM Workouts ORDER BY created_at DESC LIMIT 5;

-- "LIKE and WILDCARDS"

-- This query retrieves all users from the Users table whose username starts with the letter 'j'
SELECT * FROM Users WHERE username LIKE 'j%';

-- This query retrieves users from the Users table whose usernames start with 'j' and contain an 'a', with exactly 5 characters in between.
SELECT * FROM Users WHERE username LIKE 'j_____a%';

-- IN - This query retrieves all the users who have opted for the Morning Routine workout
SELECT * FROM Users 
WHERE user_id IN (
    SELECT user_id FROM Workouts WHERE workout_name = 'Morning Routine'
);

-- BETWEEN - This query retrieves all workout sessions from the Workout_Sessions table where the session date falls between May 10, 2024, and May 12, 2024, inclusive.
SELECT * FROM Workout_Sessions WHERE session_date BETWEEN '2024-05-10' AND '2024-05-12';

-- "ALIASES"

-- Aliases for columns
SELECT workout_id AS "ID", workout_name AS "NAME"
FROM workouts;

-- Aliases for tables
SELECT u.username, w.workout_name
FROM Users u
JOIN Workouts w ON u.user_id = w.user_id;

-- Aliases for functions
SELECT AVG(duration_minutes) AS "Average Duration"
FROM Workout_Sessions;


-- "JOINS"

-- Natural Join - This query gives the total calories burnt by each user
SELECT user_id, SUM(calories_burned) FROM
workouts NATURAL JOIN workout_sessions
GROUP BY user_id;

-- Inner Join - This query retrives the users who workout
SELECT DISTINCT user_id FROM
workouts INNER JOIN workout_sessions
ON workouts.workout_id = workout_sessions.workout_id;

-- Left Join and Right Join - These queries gives names of all the exercises even if they don't belong to any workout-session
SELECT exercise_name, workout_id FROM
exercises LEFT JOIN workout_sessions
ON exercises.exercise_id = workout_sessions.exercise_id;

SELECT exercise_name, workout_id FROM
workout_sessions RIGHT JOIN exercises
ON exercises.exercise_id = workout_sessions.exercise_id; 


-- INDEX

CREATE INDEX idx_username ON Users (username);
-- Without index query duration was more
SELECT user_id, age, email, created_at, last_login
FROM Users
WHERE username = 'jessica_l';

-- UNION - This query retrieves all the users who are using the app.
SELECT user_id FROM Users
UNION
SELECT user_id FROM Workouts
ORDER BY user_id;

-- GROUP BY - This query retrieves the number of workouts done by each user.
SELECT user_id, COUNT(*) AS workout_count
FROM Workouts
GROUP BY user_id;

-- NULL FUNCTIONS
INSERT INTO Users (username,age, email, password, created_at) VALUES
('jessica_09', 22,'jess@example.com', 'pass123', '2024-01-01 08:00:00');

SELECT * FROM users WHERE last_login IS NULL;
SELECT * FROM users WHERE last_login IS NOT NULL;

-- HAVING FUNCTIONS
SELECT workout_id, AVG(duration_minutes) AS avg_duration
FROM Workout_sessions
GROUP BY workout_id
HAVING AVG(duration_minutes) > 10;

SELECT workout_name, COUNT(*) AS workout_count
FROM Workouts
GROUP BY workout_name
HAVING COUNT(*) > 1;


-- STORED PROCEDURE
DELIMITER //
CREATE PROCEDURE GetUser(IN userID INT)
BEGIN
    SELECT * FROM Users WHERE user_id = userID;
END //
DELIMITER ;

-- Calling the stored procedure
CALL GetUser(1);

-- VIEWS

-- Creating a view
CREATE VIEW Detailed_Workout_Sessions AS
SELECT 
    ws.session_id,
    u.username,
    w.workout_name,
    e.exercise_name,
    ws.duration_minutes,
    ws.calories_burned,
    ws.session_date
FROM 
    Workout_Sessions ws
JOIN 
    Workouts w ON ws.workout_id = w.workout_id
JOIN 
    Users u ON w.user_id = u.user_id
JOIN 
    Exercises e ON ws.exercise_id = e.exercise_id;

-- Select data from view 
SELECT * FROM Detailed_Workout_Sessions;

-- Filter data from view
SELECT * FROM Detailed_Workout_Sessions
WHERE username = 'jessica_l';

-- Using aggregation on view - This query retrieves total calories burnt by the user
SELECT username, SUM(calories_burned) AS total_calories_burned
FROM Detailed_Workout_Sessions
GROUP BY username;

-- Update data in view
UPDATE Workout_Sessions
SET duration_minutes = 60
WHERE session_id = 1;

-- Delete data from view
DELETE FROM Workout_Sessions
WHERE session_id = 1;


-- DROP

DROP INDEX idx_username ON Users; -- Similarly views, tables and databases can be dropped.







