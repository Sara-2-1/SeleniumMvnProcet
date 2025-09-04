package tasks;

import org.junit.jupiter.api.*;

public class C07_JUnitAnnotations
{
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach()");
    }


    @Test
    void test01() {
        System.out.println("Test01");
    }

    @Test
    void test02() {
        System.out.println("Test02");
    }

    @Test
    @Disabled
    void test03() {
        System.out.println("Test03");
    }

    @Test
    void test04() {
        System.out.println("Test04");
    }

    @Test
    @DisplayName("This is test 05")
    void test05() {
        System.out.println("Test05");
    }
}
