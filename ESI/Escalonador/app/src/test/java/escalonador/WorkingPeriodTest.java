package escalonador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkingPeriodTest {
    private ModernSchedule workSchedule;

    @BeforeEach
    public void init() {
        workSchedule = new ModernSchedule(10);
        workSchedule.setRequiredNumber(0, 9, 5);
    }

    @Test
    public void testAddWorkingPeriodInvalidStartTime() {
        assertFalse(workSchedule.addWorkingPeriod("John", -1, 5));
        // Verifique se o cronograma permanece inalterado
        for (int i = 0; i < 10; i++) {
            assertEquals(5, workSchedule.readSchedule(i).getRequiredNumber());
            assertEquals(0, workSchedule.readSchedule(i).getWorkingEmployees().length);
        }
    }

    @Test
    public void testAddWorkingPeriodInvalidEndTime() {
        // Testa se a adição de um período de trabalho com um tempo de término inválido
        // retorna false
        assertFalse(workSchedule.addWorkingPeriod("John", 0, 10));
        // Verifica se o cronograma permanece inalterado
        for (int i = 0; i < 10; i++) {
            assertEquals(5, workSchedule.readSchedule(i).getRequiredNumber(),
                    "o número requerido não deve ser alterado");
            assertEquals(0, workSchedule.readSchedule(i).getWorkingEmployees().length,
                    "o array de funcionários não deve ser alterado");
        }
    }

    @Test
    public void testAddWorkingPeriodEmployeeAlreadyScheduled() {
        // Configura o cronograma com um período de trabalho para "John"
        workSchedule.addWorkingPeriod("John", 2, 5);

        // Tenta adicionar um período de trabalho com um funcionário já agendado
        assertFalse(workSchedule.addWorkingPeriod("John", 3, 7));

        // Verifica se o cronograma permanece inalterado para as horas em que o
        // funcionário já está agendado
        for (int i = 2; i <= 5; i++) {
            assertEquals(5, workSchedule.readSchedule(i).getRequiredNumber(),
                    "o número requerido não deve ser alterado");
            assertEquals(1, workSchedule.readSchedule(i).getWorkingEmployees().length,
                    "o array de funcionários não deve ser alterado");
            assertEquals("John", workSchedule.readSchedule(i).getWorkingEmployees()[0],
                    "o funcionário agendado não deve ser alterado");
        }

        // Verifica se o cronograma permanece inalterado para as horas fora do período
        // do funcionário
        for (int i = 0; i < 10; i++) {
            if (i < 2 || i > 5) {
                assertEquals(5, workSchedule.readSchedule(i).getRequiredNumber(),
                        "o número requerido não deve ser alterado");
                assertEquals(0, workSchedule.readSchedule(i).getWorkingEmployees().length,
                        "o array de funcionários não deve ser alterado");
            }
        }
    }

    @Test
    public void testAddWorkingPeriodSuccess() {
        // Tenta adicionar um período de trabalho com sucesso
        assertTrue(workSchedule.addWorkingPeriod("John", 2, 5));
        // Verifica se o cronograma foi atualizado corretamente
        for (int i = 2; i <= 5; i++) {
            assertEquals(5, workSchedule.readSchedule(i).getRequiredNumber(),
                    "o número requerido deve manter se igual");
            assertEquals(1, workSchedule.readSchedule(i).getWorkingEmployees().length,
                    "o array de funcionários deve ser atualizado para conter 1 funcionário");
            assertEquals("John", workSchedule.readSchedule(i).getWorkingEmployees()[0],
                    "o funcionário agendado deve ser John");
        }
        // Verifica se o restante do cronograma permanece inalterado
        for (int i = 0; i < 10; i++) {
            if (i < 2 || i > 5) {
                assertEquals(5, workSchedule.readSchedule(i).getRequiredNumber(),
                        "o número requerido não deve ser alterado");
                assertEquals(0, workSchedule.readSchedule(i).getWorkingEmployees().length,
                        "o array de funcionários não deve ser alterado");
            }
        }
    }    

}
