import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Timeout;


public class RunTest {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Tests is run!");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Tests completed!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is complete");
        Assertions.assertEquals("AW", "AW");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 is complete");
        Assertions.assertEquals("AW", "A@W");
    }

    @Test
    @Disabled("The test is temporarily disabled")
    public void disableTest(){
        //Данный тест не будет выполняться по какой-либо причине(например: мы знаем, что тест непроходит и не даем ему запускаться)
        System.out.println("!!!");
    }

    @Test
    @Timeout(2)
    public void timeoutTest() throws InterruptedException{
        // Какая-то логика теста, допустим, что-то в цикле просходит
        for (int i = 0; i < 5; i++){
            Thread.sleep(100); // Имитация выполнения теста, сдерживаем каждую итерацию на 100 мс
        }
        // В итоге оказалось, что тест выполнялся меньше чем за 2 секунду и исключение не выбросится
    }

    @Test
    public void testArrayIsSorted(){
        System.out.println("Sorting test is complete");
        Assertions.assertTrue(Main.IsSorted());
    }

    @Test
    public void testArrayMaxValue(){
        int expected = Main.findMax();

        Assertions.assertEquals(expected, 92);

        System.out.println("Test for maximum value is complete: " + "Expected: " + expected + " " + "Actual: " + 92);
    }

    @Test
    public void negativeTestArrayMinValue() {
        int actualMin = Main.findMin();  // Предположим, Main.findMin() возвращает минимальный элемент массива

        Assertions.assertNotEquals(4, actualMin, "The minimum value should not be 4");

        System.out.println("Negative test for minimum value is complete: " + "Actual: " + actualMin + " Unexpected: 4");
    }
}