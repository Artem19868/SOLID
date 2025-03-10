package service;

import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TaskRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {
    private TaskRepository repository;
    private TaskService service;

    @BeforeEach
    void setUp() {
        repository = mock(TaskRepository.class);
        service = new TaskServiceImpl(repository);
    }

    @Test
    void createTask_ShouldSaveTask() {
        // Arrange
        String title = "Test Task";
        String description = "Test Description";
        Task task = new Task(1L, title, description);
        when(repository.save(any(Task.class))).thenReturn(task);

        // Act
        Task result = service.createTask(title, description);

        // Assert
        assertNotNull(result);
        assertEquals(title, result.getTitle());
        assertEquals(description, result.getDescription());
        verify(repository).save(any(Task.class));
    }
}
