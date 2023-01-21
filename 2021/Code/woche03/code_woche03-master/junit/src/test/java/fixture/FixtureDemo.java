package fixture;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FixtureDemo {


    @BeforeAll
    static void beforeall1() {
        System.out.println("BeforeAll 1");
    }

    @AfterAll
    static void afterall1() {
        System.out.println("AfterAll 1");
    }

    @BeforeAll
    static void before_all2() {
        System.out.println("BeforeAll 2");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }

    @BeforeEach
    void before_each1() {
        System.out.println("BeforeEach 1");
    }

    @BeforeEach

    void before_each2() {
        System.out.println("BeforeEach 2");
    }

    @AfterEach
    void after_each1() {
        System.out.println("AfterEach 1");
    }

    @AfterEach
    void after_each2() {
        System.out.println("AfterEach 2");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
    }



}




