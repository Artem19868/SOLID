package service;

import model.Task;
import repository.TaskRepository;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task createTask(String title, String description) {
        Task task = new Task(null, title, description);
        return repository.save(task);
    }

    @Override
    public void completeTask(Long id) {
        repository.findById(id).ifPresent(task -> {
            task.setCompleted(true);
            repository.save(task);
        });
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }
}
