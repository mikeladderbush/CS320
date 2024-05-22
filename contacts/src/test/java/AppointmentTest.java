import org.junit.Test;

import com.projectonecs320.Classes.Appointment;

import static org.junit.Assert.*;

import java.util.Date;

public class AppointmentTest {
    Date date = new Date(2000, 1, 1);

    @Test
    public void testAppointmentConstructor() {
        Appointment appointment = new Appointment("1");

        assertEquals("1", appointment.getId());
        assertEquals(date, appointment.getDate());
        assertEquals("blank", appointment.getDescription());

    }

    @Test
    public void testSetIdValid() {
        Appointment appointment = new Appointment("1");

        assertEquals("2", appointment.getId());
    }

    @Test
    public void testSetIdTooLong() {
        Appointment appointment = new Appointment("1");

        assertThrows(IllegalArgumentException.class, () -> {
        });
    }

    @Test
    public void testDateValid() {
        Appointment appointment = new Appointment("1");

        appointment.setDate(date);
        assertEquals(date, appointment.getDate());
    }

    @Test
    public void testDescriptionValid() {
        Appointment appointment = new Appointment("1");

        appointment.setDescription("Jane");
        assertEquals("Jane", appointment.getDescription());
    }

    @Test
    public void testDescriptionTooLong() {
        Appointment appointment = new Appointment("1");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(
                    "ThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLong ThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLongThisIsTooLong");
        });
    }

}
