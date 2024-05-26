import static org.junit.Assert.*;
import org.junit.Test;
import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Contact;
import com.projectonecs320.Classes.Task;
import com.projectonecs320.Services.AppointmentService;
import com.projectonecs320.Services.ContactService;
import com.projectonecs320.Services.TaskService;
import com.projectonecs320.Suppliers.AppointmentSupplier;
import com.projectonecs320.Suppliers.ContactSupplier;
import com.projectonecs320.Suppliers.TaskSupplier;

public class SupplierTest {

    @Test
    public void testAppointmentSupplier() {
        AppointmentService appointmentService = new AppointmentService();
        AppointmentSupplier appointmentSupplier = new AppointmentSupplier(appointmentService);

        // Test appointment supplier
        Appointment appointment = appointmentSupplier.get();

        // Check if appointment is not null
        assertNotNull(appointment);
        // Check if appointment ID is generated
        assertNotNull(appointment.getId());
    }

    @Test
    public void testContactSupplier() {
        ContactService contactService = new ContactService();
        ContactSupplier contactSupplier = new ContactSupplier(contactService);

        // Test contact supplier
        Contact contact = contactSupplier.get();

        // Check if contact is not null
        assertNotNull(contact);
        // Check if contact ID is generated
        assertNotNull(contact.getId());
    }

    @Test
    public void testTaskSupplier() {
        TaskService taskService = new TaskService();
        TaskSupplier taskSupplier = new TaskSupplier(taskService);

        // Test task supplier
        Task task = taskSupplier.get();

        // Check if task is not null
        assertNotNull(task);
        // Check if task ID is generated
        assertNotNull(task.getId());
    }

    // Add more test cases as needed
}
