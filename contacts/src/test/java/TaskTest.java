import org.junit.Test;

import com.projectonecs320.Classes.Task;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testTaskConstructor() {
        Task task = new Task("1");

        assertEquals("1", task.getId());
        assertEquals("task", task.getName());
        assertEquals("description", task.getDescription());

    }

    @Test
    public void testSetIdValid() {
        Task task = new Task("1");

        assertEquals("2", task.getId());
    }

    @Test
    public void testSetIdTooLong() {
        Task task = new Task("1");

        assertThrows(IllegalArgumentException.class, () -> {
        });
    }

    @Test
    public void testSetNameValid() {
        Task task = new Task("1");

        task.setName("Jane");
        assertEquals("Jane", task.getName());
    }

    @Test
    public void testSetNameTooLong() {
        Task task = new Task("1");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("ThisIsTooLongForTheTaskNameAsItIsLongerThanTwenty");
        });
    }

    @Test
    public void testSetDescriptionValid() {
        Task task = new Task("1");

        task.setDescription("task");
        assertEquals("task", task.getDescription());
    }

    @Test
    public void testSetDescriptionTooLong() {
        Task task = new Task("1");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(
                    "ThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLong");
        });
    }

}
