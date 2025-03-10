import model.Task;
import repository.InMemoryTaskRepository;
import repository.TaskRepository;
import service.TaskService;
import service.TaskServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in, "UTF-8");
        
        TaskRepository repository = new InMemoryTaskRepository();
        TaskService service = new TaskServiceImpl(repository);

        while (true) {
            System.out.println("\nSelect action:");
            System.out.println("1. Create task");
            System.out.println("2. Show all tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    service.createTask(title, description);
                    System.out.println("Task created!");
                    break;

                case "2":
                    for (Task task : service.getAllTasks()) {
                        System.out.printf("[%d] %s - %s%n    Description: %s%n",
                                task.getId(),
                                task.getTitle(),
                                task.isCompleted() ? "Completed" : "In Progress",
                                task.getDescription());
                    }
                    break;

                case "3":
                    System.out.print("Enter task ID: ");
                    try {
                        Long id = Long.parseLong(scanner.nextLine());
                        service.completeTask(id);
                        System.out.println("Task marked as completed!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task ID");
                    }
                    break;

                case "4":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}