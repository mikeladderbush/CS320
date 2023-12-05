import static org.junit.Assert.assertEquals;
import java.util.Date;

import org.junit.*;

import com.projectonecs320.Appointment;
import com.projectonecs320.AppointmentService;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Appointment appointment;

    public Date date;

    @Before
    public void setUp() {
        appointmentService = new AppointmentService();
        appointment = new Appointment(appointmentService.generateId(), date, "Description Default");
    }

    @Test
    public void testAddAppointment() {
        appointmentService.addAppointment(appointment);
        assertEquals(1, appointmentService.getAllAppointments().size());
    }

    @Test
    public void testDeleteAppointment() {
        appointmentService.addAppointment(appointment);

        appointmentService.deleteAppointment(appointment.getId());
        assertEquals(0, appointmentService.getAllAppointments().size());
    }
}
