import static org.junit.Assert.*;
import org.junit.Test;
import com.projectonecs320.Classes.Appointment;
import com.projectonecs320.Classes.Task;
import com.projectonecs320.Services.AppointmentService;
import com.projectonecs320.Services.TaskService;
import com.projectonecs320.Suppliers.AppointmentSupplier;
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

}
