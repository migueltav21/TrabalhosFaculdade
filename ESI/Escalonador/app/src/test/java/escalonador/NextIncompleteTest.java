package escalonador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NextIncompleteTest {
    private ModernSchedule modernScheduler;
    private static final int NUMBER_OF_HOURS = 10;
    private static final int NEXT_VALID = 5;
    private static final int INVALID = -1;

    @BeforeEach
    public void init() {
        modernScheduler = new ModernSchedule(NUMBER_OF_HOURS);
        modernScheduler.setRequiredNumber(0, 9, 5);
        modernScheduler.addWorkingPeriod("João", 0, 4);
        modernScheduler.addWorkingPeriod("Francisco", 0, 4);
        modernScheduler.addWorkingPeriod("Rodrigo", 0, 4);
        modernScheduler.addWorkingPeriod("Henrique", 0, 4);
        modernScheduler.addWorkingPeriod("Alexandre", 0, 4);
    }

    @Test
    public void testNextIncompleteWithZeroIndex() {
        Assertions.assertEquals(NEXT_VALID, modernScheduler.nextIncomplete(0));
    }

    @Test
    public void testNextIncompleteWithMaximumIntegerAsIndex() {
        Assertions.assertEquals(INVALID, modernScheduler.nextIncomplete(Integer.MAX_VALUE));
    }

    @Test
    public void testNextIncompleteWithMinimumIntegerAsIndex() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            modernScheduler.nextIncomplete(Integer.MIN_VALUE);
        });
    }

    @Test
    void testNextIncompleteWithValidHourIndex() {
        Assertions.assertEquals(NEXT_VALID, modernScheduler.nextIncomplete(1));
    }

    @Test
    public void testNextIncompleteWithLastHourIndex() {
        // Assuming there are 10 hours, the last hour index is 9.
        Assertions.assertEquals(9, modernScheduler.nextIncomplete(9));
    }

    @Test
    public void testNextIncompleteWithAllHoursComplete() {
        // Set all hours to have the required number of working employees.
        modernScheduler.setRequiredNumber(0, 9, 1);
        modernScheduler.addWorkingPeriod("TestEmployee", 0, 9);

        // Since all hours are complete, the result should be -1.
        Assertions.assertEquals(INVALID, modernScheduler.nextIncomplete(0));
    }

    @Test
    public void testNextIncompleteWithEmptySchedule() {
        ModernSchedule emptyScheduler = new ModernSchedule(5);

        // The schedule is empty, so the result should be 0 (the first hour).
        Assertions.assertEquals(INVALID, emptyScheduler.nextIncomplete(0));
    }

    @Test
    public void testNextIncompleteWithHourIndexOutOfRange() {
        // Assuming there are 10 hours, index 10 is out of range, should return -1.
        Assertions.assertEquals(INVALID, modernScheduler.nextIncomplete(10));
    }
}
