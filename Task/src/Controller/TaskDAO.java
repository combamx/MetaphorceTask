package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Models.Task;
import Connection.DatabaseConnection;

public class TaskDAO {

    public void createTask(Task task) throws SQLException {
        String query = "INSERT INTO Tasks (user_id, name, description, priority) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, task.getUserId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getPriority());
            statement.executeUpdate();
        }
    }

    public Task getTask(int id) throws SQLException {
        String query = "SELECT * FROM Tasks WHERE id = ?";
        Task task = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setUserId(resultSet.getInt("user_id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setPriority(resultSet.getString("priority"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setCreationDate(resultSet.getString("creation_date"));
                task.setCompletionDate(resultSet.getString("completion_date"));
            }
        }

        return task;
    }

    public List<Task> getAllTasks() throws SQLException {
        String query = "SELECT * FROM Tasks";
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setUserId(resultSet.getInt("user_id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setPriority(resultSet.getString("priority"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setCreationDate(resultSet.getString("creation_date"));
                task.setCompletionDate(resultSet.getString("completion_date"));
                tasks.add(task);
            }
        }

        return tasks;
    }

    public List<Task> getPendingTasksByUser(int userId) throws SQLException {
        String query = "SELECT * FROM Tasks WHERE completed = 0 AND user_id = ? ORDER BY " +
                "CASE priority WHEN 'high' THEN 1 WHEN 'medium' THEN 2 WHEN 'low' THEN 3 END";
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setUserId(resultSet.getInt("user_id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setPriority(resultSet.getString("priority"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setCreationDate(resultSet.getString("creation_date"));
                task.setCompletionDate(resultSet.getString("completion_date"));
                tasks.add(task);
            }
        }

        return tasks;
    }

    public void updateTask(Task task) throws SQLException {
        String query = "UPDATE Tasks SET name = ?, description = ?, priority = ?, completed = ?, completion_date = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getPriority());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getCompletionDate());
            statement.setInt(6, task.getId());
            statement.executeUpdate();
        }
    }

    public void deleteTask(int id) throws SQLException {
        String query = "DELETE FROM Tasks WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

