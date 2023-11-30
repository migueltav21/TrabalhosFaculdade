package escalonador;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetRequiredNumberTest {
    private ModernSchedule workSchedule;

    @BeforeEach
    public void init() {
        workSchedule = new ModernSchedule(10);
    }

    @Test
    public void SetrequiredNumberTestZero() {
        workSchedule.setRequiredNumber(0, 0, 0);
        Assertions.assertEquals(0, workSchedule.readSchedule(0).getRequiredNumber(),
                "deve ser retornado zero visto que foram reservados 0 empregados das 0 horas às 0 horas, neste caso de testes metomos valores nulos em todos os campos");

    }

    @Test
    public void testSetRequiredNumberWithValidInput() {
        // Caso de Teste com Valores Válidos
        workSchedule.setRequiredNumber(2, 5, 3);

        // Verifique se o requiredNumber foi definido corretamente
        for (int i = 2; i <= 5; i++) {
            ModernSchedule.Hour hour = workSchedule.readSchedule(i);
            Assertions.assertEquals(3, hour.getRequiredNumber(),
                    "deve ser retornado 3 uma vez que foram resevados 3 empregados entre as 2 e as 5 horas");
        }

        // Verifique se as outras horas permanecem inalteradas
        for (int i = 0; i < 10; i++) {
            if (i < 2 || i > 5) {
                ModernSchedule.Hour hour = workSchedule.readSchedule(i);
                Assertions.assertEquals(0, hour.getRequiredNumber(),
                        "deve ser retornado 0 uma vez que não foi definido empregados para estas horas");
            }
        }
    }

    @Test
    public void testSetRequiredNumberWithNemployeeZero() {
        // Caso de Teste com nemployee Igual a 0
        workSchedule.setRequiredNumber(0, 3, 0);

        // Verifique se o requiredNumber foi definido corretamente para i entre 0 e 3
        for (int i = 0; i <= 3; i++) {
            ModernSchedule.Hour hour = workSchedule.readSchedule(i);
            assertEquals(0, hour.getRequiredNumber(),
                    "deve ser retornado 0 uma vez que não foi definido empregados para estas horas");
        }

        // Verifique se as outras horas permanecem inalteradas
        for (int i = 4; i < 10; i++) {
            ModernSchedule.Hour hour = workSchedule.readSchedule(i);
            assertEquals(0, hour.getRequiredNumber(),
                    "deve ser retornado 0 uma vez que não foi definido empregados para estas horas");
        }
    }

    @Test
    public void SetrequiredNumberTestEqualsMaximumInteger() {
         Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> workSchedule.setRequiredNumber(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE),
                "deve retornar uma exceção visto que estamos a introduzir os valores mais altos possiveis e fora dos limites nas horas");
  
    }
    
    @Test
    public void SetrequiredNumberTestEqualsMinimumInteger() {
     Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> workSchedule.setRequiredNumber(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE),
                "deve retornar uma exceção visto que estamos a introduzir introduzir os valores mais baixos possiveis e fora dos limites nas horas");
  
    }
    
    @Test
    public void SetrequiredNumberTestMaxHourIndexOutOfBounds() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> workSchedule.setRequiredNumber(0, 17, 4),
                "deve retornar uma exceção visto que estamos a introduzir valores fora dos limites nas horas");
  
    }

    @Test
    public void testSeqRequiredNumberWithInvalidStarttime() {
        // Caso de Teste com starttime inválido (negativo)
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> workSchedule.setRequiredNumber(-1, 4, 4),
                "deve retornar uma exceção visto que estamos a introduzir valores fora dos limites nas horas");
    }
    
}
