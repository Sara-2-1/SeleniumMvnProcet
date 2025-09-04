package tasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;


public class C08_Assertions {
    @Test
    void assertEqualsTest() {
        String actualData = "John";
        String expectedData = "John";
        Assertions.assertEquals(expectedData, actualData, "Names did not match!");
    }

    @Test
    void assertTrueTest() {

        String table = """
                First Name: Raymon
                Last Name: Wolf
                Date of Birth: 2000-05-15
                """;
        Assertions.assertTrue(table.contains("Wolf"), "Table does not contain Wolf!");
    }

    @Test
    void assertFalseTest() {
        String table = """
                First Name: Raymon
                Last Name: Wolf
                Date of Birth: 2000-05-15
                """;
        assertFalse(table.contains("John"), "Tables contains John");
    }

    String name;

    @Test
    void assertNullTest() {
        assertNull(name, "Name is not null!");
    }


}


