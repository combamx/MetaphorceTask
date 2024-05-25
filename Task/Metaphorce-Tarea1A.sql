use [Metaphorce1]

/*
-- Crear la tabla Users
CREATE TABLE Users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL UNIQUE
);

-- Crear la tabla Tasks
CREATE TABLE Tasks (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    name NVARCHAR(255) NOT NULL,
    description NVARCHAR(255) NOT NULL,
    priority NVARCHAR(10) CHECK (priority IN ('low', 'medium', 'high')) NOT NULL,
    completed BIT DEFAULT 0,
    creation_date DATETIME DEFAULT GETDATE(),
    completion_date DATETIME NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);
*/
-- Registrar nuevos usuarios
INSERT INTO Users (name, email)
VALUES
('John Doe', 'john.doe@example.com'),
('Jane Smith', 'jane.smith@example.com');

-- Registrar nuevas tareas para los usuarios
INSERT INTO Tasks (user_id, name, description, priority)
VALUES
(1, 'Study for math exam', 'Review chapters 1-4 and solve problems', 'high'),
(1, 'Finish the Booster challenge', 'Complete all activities and submit them', 'high'),
(2, 'Make doctor appointment', 'Call the clinic to schedule an appointment', 'medium'),
(2, 'Schedule interview with Metaphorce', 'Contact Metaphorce to schedule an interview', 'medium');

-- Marcar una tarea como completada (ejemplo para la tarea con id = 1)
UPDATE Tasks
SET completed = 1, completion_date = GETDATE()
WHERE id = 1;

-- Eliminar una tarea (ejemplo para la tarea con id = 2)
DELETE FROM Tasks
WHERE id = 2;

-- Mostrar un listado de tareas pendientes ordenadas por prioridad para un usuario (ejemplo para usuario con id = 1)
SELECT id, name, description, priority, creation_date
FROM Tasks
WHERE completed = 0 AND user_id = 1
ORDER BY 
    CASE priority
        WHEN 'high' THEN 1
        WHEN 'medium' THEN 2
        WHEN 'low' THEN 3
    END;
