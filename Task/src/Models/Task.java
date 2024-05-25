package Models;

public class Task {
    private int id;
    private int userId;
    private String name;
    private String description;
    private String priority;
    private boolean completed;
    private String creationDate;
    private String completionDate;

    // Constructor sin parámetros
    public Task() {}

    // Constructor con parámetros
    public Task(int id, int userId, String name, String description, String priority, boolean completed, String creationDate, String completionDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", completed=" + completed +
                ", creationDate='" + creationDate + '\'' +
                ", completionDate='" + completionDate + '\'' +
                '}';
    }
}
