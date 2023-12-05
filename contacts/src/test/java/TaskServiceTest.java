
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.*;

import com.projectonecs320.Task;
import com.projectonecs320.TaskService;

public class TaskServiceTest {
    private TaskService taskService;
    private Task task;

    @Before
    public void setUp() {
        taskService = new TaskService();
        task = new Task(taskService.generateId(), "task", "description");
    }

    @Test
    public void testAddtask() {
        taskService.addTask(task);
        assertEquals(1, taskService.getAllTasks().size());
    }

    @Test
    public void testUpdateName() {
        taskService.addTask(task);
        taskService.updateTaskName(task.getId(), "task");
        assertEquals("task", task.getName());
    }

    @Test
    public void testUpdateDescription() {
        taskService.addTask(task);
        taskService.updateTaskDescription(task.getId(), "NewDescription");
        assertEquals("NewDescription", task.getDescription());
    }

    @Test
    public void testFindtaskById() {
        taskService.addTask(task);

        Task foundtask = taskService.findTaskById(task.getId());
        assertNotNull(foundtask);
        assertEquals(task, foundtask);
    }

    @Test
    public void testUpdateNameWithInvalidName() {
        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName(task.getId(), "ThisIsTooLongforthetasknameandwillproduceanerror");
        });
        assertEquals("task", task.getName());
    }

    @Test
    public void testUpdateDescriptionWithInvalidName() {
        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription(task.getId(),
                    "1234567890123456789012345678901234567890123456789012345678901234567890");
        });
        assertEquals("description", task.getDescription());
    }

    @Test
    public void testDeletetask() {
        taskService.addTask(task);

        taskService.deleteTask(task.getId());
        assertEquals(0, taskService.getAllTasks().size());
    }
}
