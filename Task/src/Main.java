import java.sql.SQLException;
import java.util.List;
import Models.User;
import Models.Task;
import Controller.UserDAO;
import Controller.TaskDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        TaskDAO taskDAO = new TaskDAO();

        try {
            // Crear usuarios
            User user1 = new User();
            user1.setName("John Doe");
            user1.setEmail("john.doe@example.com");
            userDAO.createUser(user1);

            User user2 = new User();
            user2.setName("Jane Smith");
            user2.setEmail("jane.smith@example.com");
            userDAO.createUser(user2);

            // Crear tareas
            Task task1 = new Task();
            task1.setUserId(1);
            task1.setName("Study for math exam");
            task1.setDescription("Review chapters 1-4 and solve problems");
            task1.setPriority("high");
            taskDAO.createTask(task1);

            Task task2 = new Task();
            task2.setUserId(1);
            task2.setName("Finish the Booster challenge");
            task2.setDescription("Complete all activities and submit them");
            task2.setPriority("high");
            taskDAO.createTask(task2);

            // Obtener todas las tareas pendientes para el usuario 1
            List<Task> pendingTasks = taskDAO.getPendingTasksByUser(1);
            for (Task task : pendingTasks) {
                System.out.println(task);
            }

            // Marcar una tarea como completada
            Task completedTask = taskDAO.getTask(1);
            completedTask.setCompleted(true);
            completedTask.setCompletionDate("2023-05-25 10:00:00");
            taskDAO.updateTask(completedTask);

            // Eliminar una tarea
            taskDAO.deleteTask(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}