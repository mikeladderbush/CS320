import static org.junit.Assert.*;
import org.junit.Test;
import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Classes.Task;
import com.projectonecs320.Factories.AppointmentFactory;
import com.projectonecs320.Factories.ContactFactory;
import com.projectonecs320.Factories.TaskFactory;
import com.projectonecs320.Services.AppointmentService;
import com.projectonecs320.Services.ContactService;
import com.projectonecs320.Services.TaskService;

public class ServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = ContactFactory.createContact(builder -> {
        });
        contactService.addContact(contact);
        assertEquals(1, contactService.getAllContacts().size());
        assertTrue(contactService.getAllContacts().contains(contact));
    }

    @Test
    public void testAddAppointmentToContact() {
        AppointmentService appointmentService = new AppointmentService();
        ContactService contactService = new ContactService();

        // Create appointment
        Appointment appointment = AppointmentFactory.createAppointment(builder -> {
        });
        appointment.setId("1");
        appointmentService.addAppointment(appointment);

        // Create contact
        Contact contact = ContactFactory.createContact(builder -> {
        });
        contact.setId("1");
        contactService.addContact(contact);

        // Add appointment to contact
        contactService.addAppointmentToContact(contact, appointment);

        // Check if appointment is added to contact
        assertEquals(1, contact.getAppointments().size());
        assertTrue(contact.getAppointments().contains(appointment));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAppointmentToContactWithNoContact() {
        AppointmentService appointmentService = new AppointmentService();
        ContactService contactService = new ContactService();

        // Create appointment
        Appointment appointment = AppointmentFactory.createAppointment(builder -> {
        });
        appointmentService.addAppointment(appointment);

        Contact contact = null;

        // Add appointment to non-existent contact
        contactService.addAppointmentToContact(contact, appointment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAppointmentToContactWithNoAppointment() {
        ContactService contactService = new ContactService();

        // Create contact
        Contact contact = ContactFactory.createContact(builder -> {
        });
        contactService.addContact(contact);

        Appointment appointment = null;

        // Add non-existent appointment to contact
        contactService.addAppointmentToContact(contact, appointment);
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact1 = ContactFactory.createContact(builder -> {
        });
        Contact contact2 = ContactFactory.createContact(builder -> {
        });

        // Add contacts
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Delete contact
        contactService.deleteContact(contact1.getId());

        // Check if contact is deleted
        assertEquals(1, contactService.getAllContacts().size());
        assertFalse(contactService.getAllContacts().contains(contact1));
    }

    @Test
    public void testAddAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = AppointmentFactory.createAppointment(builder -> {
        });
        appointment.setId("1");
        appointmentService.addAppointment(appointment);
        assertEquals(1, appointmentService.getAllAppointments().size());
        assertTrue(appointmentService.getAllAppointments().contains(appointment));
    }

    @Test
    public void testAddTaskToAppointment() {
        TaskService taskService = new TaskService();
        AppointmentService appointmentService = new AppointmentService();

        // Create task
        Task task = TaskFactory.createTask(builder -> {
        });
        task.setId("1");
        taskService.addTask(task);

        // Create appointment
        Appointment appointment = AppointmentFactory.createAppointment(builder -> {
        });
        appointment.setId("1");
        appointmentService.addAppointment(appointment);

        // Add task to appointment
        appointmentService.addTaskToAppointment(appointment, task);

        // Check if task is added to appointment
        assertEquals(1, appointment.getTasks().size());
        assertTrue(appointment.getTasks().contains(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskToAppointmentWithNoAppointment() {
        TaskService taskService = new TaskService();
        AppointmentService appointmentService = new AppointmentService();

        // Create task
        Task task = TaskFactory.createTask(builder -> {
        });
        task.setId("1");
        taskService.addTask(task);

        Appointment appointment = null;

        // Add task to non-existent appointment
        appointmentService.addTaskToAppointment(appointment, task);
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment1 = AppointmentFactory.createAppointment(builder -> {
        });
        appointment1.setId("1");
        Appointment appointment2 = AppointmentFactory.createAppointment(builder -> {
        });
        appointment2.setId("2");

        // Add appointments
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);

        // Delete appointment
        appointmentService.deleteAppointment("1");

        // Check if appointment is deleted
        assertEquals(1, appointmentService.getAllAppointments().size());
        assertFalse(appointmentService.getAllAppointments().contains(appointment1));
    }

    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = TaskFactory.createTask(builder -> {
        });
        task.setId("1");
        taskService.addTask(task);
        assertEquals(1, taskService.getAllTasks().size());
        assertTrue(taskService.getAllTasks().contains(task));
    }

    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService();
        Task task = TaskFactory.createTask(builder -> {
        });
        task.setId("1");
        taskService.addTask(task);

        // Update task name
        taskService.updateTaskName("1", "New Name");

        // Check if task name is updated
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService();
        Task task = TaskFactory.createTask(builder -> {
        });
        task.setId("1");
        taskService.addTask(task);

        // Update task description
        taskService.updateTaskDescription("1", "New Description");

        // Check if task description is updated
        assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task1 = TaskFactory.createTask(builder -> {
        });
        task1.setId("1");
        Task task2 = TaskFactory.createTask(builder -> {
        });
        task2.setId("2");

        // Add tasks
        taskService.addTask(task1);
        taskService.addTask(task2);

        // Delete task
        taskService.deleteTask("1");

        // Check if task is deleted
        assertEquals(1, taskService.getAllTasks().size());
        assertFalse(taskService.getAllTasks().contains(task1));
    }

}
