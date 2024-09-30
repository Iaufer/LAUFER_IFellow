import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MortyTest {
    private FirstTaskMorty fTM;

    @BeforeEach
    public void setUp() {
        fTM = new FirstTaskMorty();
        fTM.morty();
    }

    @Test
    @DisplayName("Проверка, что расса Морти совпадает с рассой персонажа в последнем эпизоде")
    public void testMortySpecies() {
        Assertions.assertEquals(fTM.getSpecies(), fTM.getLastSpecies());
    }

    @Test
    @DisplayName("Проверка, что местоположение Морти не совпадает с последним местоположением персонажа в последнем эпизоде")
    public void testMortyLocation() {
        Assertions.assertNotEquals(fTM.getLocation(), fTM.getLastLocation());
    }
}
