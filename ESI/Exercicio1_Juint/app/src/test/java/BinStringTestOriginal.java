import org.junit.jupiter.api.*;

public class BinStringTestOriginal {
    private BinString binString;

    @BeforeEach
    public void setUp() {
        binString = new BinString();
    }

    @Test
    public void testSumFunction(){

        int expected = 0;
        Assertions.assertEquals(expected, binString.sum(""), "\"\" should be 0");
        expected = 100;
        Assertions.assertEquals(expected, binString.sum("d"), "d should be 100");
        expected = 265;
        Assertions.assertEquals(expected, binString.sum("Add"), "Add should be 265");
    }

    @Test
    public void testBinariseFunction(){

        String expected = "101";
        Assertions.assertEquals(expected, binString.binarise(5), "5 should be 101");

        expected = "11111100";
        Assertions.assertEquals(expected, binString.binarise(252), "252 should be 11111100");

    }

    @Test
    public void testTotalConversion(){
        String expected = "1000001";
        Assertions.assertEquals(expected, binString.convert("A"), "A should be 1000001");
    }
}
