package hu.nye.progtech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LessonsTest {

    private int id;
    private String lesson = "";
    private int start;
    private int finish;
    private String student = "";
    private int grade;
    private Lessons underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Lessons(id, lesson, start, finish, student, grade);
    }

    @Test
    public void testUser() {
        // given
        String actual = "Lessons{id=0, lesson='', start=0, finish=0, student='', grade=0}";
        String expected = underTest.toString();

        // when
        underTest.toString().equalsIgnoreCase("test");

        // then
        Assertions.assertEquals(actual, expected);
    }
}
