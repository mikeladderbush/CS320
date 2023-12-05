import org.junit.Test;

import com.projectonecs320.Task;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testTaskConstructor() {
        Task task = new Task("1", "task", "description");

        assertEquals("1", task.getId());
        assertEquals("task", task.getName());
        assertEquals("description", task.getDescription());

    }

    @Test
    public void testSetIdValid() {
        Task task = new Task("1", "task", "description");

        task.setId("2");
        assertEquals("2", task.getId());
    }

    @Test
    public void testSetIdTooLong() {
        Task task = new Task("1", "task", "description");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setId("12345678901");
        });
    }

    @Test
    public void testSetNameValid() {
        Task task = new Task("1", "task", "description");

        task.setName("Jane");
        assertEquals("Jane", task.getName());
    }

    @Test
    public void testSetNameTooLong() {
        Task task = new Task("1", "task", "description");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("ThisIsTooLongForTheTaskNameAsItIsLongerThanTwenty");
        });
    }

    @Test
    public void testSetDescriptionValid() {
        Task task = new Task("1", "task", "description");

        task.setDescription("task");
        assertEquals("task", task.getDescription());
    }

    @Test
    public void testSetDescriptionTooLong() {
        Task task = new Task("1", "task", "description");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(
                    "ThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLong");
        });
    }

}
