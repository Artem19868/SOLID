package service;

import model.Task;
import java.util.List;

public interface TaskService {
    Task createTask(String title, String description);
    void completeTask(Long id);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
}
