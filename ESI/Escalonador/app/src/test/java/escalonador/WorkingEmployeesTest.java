package escalonador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkingEmployeesTest {
    private ModernSchedule modernScheduler;
    private static final int NUMBER_OF_HOURS = 10;

    @BeforeEach
    public void init() {
        modernScheduler = new ModernSchedule(NUMBER_OF_HOURS);
        modernScheduler.setRequiredNumber(0, 4, 2);
        modernScheduler.setRequiredNumber(5, 9, 3);
        
        modernScheduler.addWorkingPeriod("Joao", 0, 4);
        modernScheduler.addWorkingPeriod("Francisco", 0, 4);
        modernScheduler.addWorkingPeriod("Rodrigo", 5, 9);
        modernScheduler.addWorkingPeriod("Henrique", 5, 9);
        modernScheduler.addWorkingPeriod("Alexandre", 5, 9);
    }

    @Test
    public void testWorkingEmployeesWithNonOverlappingPeriods() {
        String[] expected = {"Joao", "Francisco"};
        Assertions.assertArrayEquals(expected, modernScheduler.workingEmployees(0, 4));
        String[] expected2 = {"Rodrigo", "Henrique", "Alexandre"};
        Assertions.assertArrayEquals(expected2, modernScheduler.workingEmployees(5, 9));
    }

    @Test
public void testWorkingEmployeesSemFuncionarios() {
    // Configure o agendador sem funcionários trabalhando
    ModernSchedule schedulerSemFuncionarios = new ModernSchedule(5);
    schedulerSemFuncionarios.setRequiredNumber(0, 4, 0);
    // Adicione outras configurações necessárias
    
    // Verifique se a saída é um array vazio
    String[] arrayVazio = new String[0];
    Assertions.assertArrayEquals(arrayVazio, schedulerSemFuncionarios.workingEmployees(0, 4));
}


@Test
public void testarWorkingEmployeesComIndicesInvalidos() {
    // Teste com índices de hora inválidos e certifique-se de que ele lança a exceção correta ou trata-a adequadamente
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> modernScheduler.workingEmployees(-1, 4));
}

@Test
public void testWorkingEmployeesComIndicesMaximosMinimosValidos() {
    // Escolha índices máximos e mínimos válidos e verifique a saída
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> modernScheduler.workingEmployees(Integer.MIN_VALUE, Integer.MAX_VALUE));
}

}

