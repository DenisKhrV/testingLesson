package pro.sky.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UniversityTest {
    private  Student student = new Student("Евгений", true);
    private Student student1;
    private Student student2;
    private Student student3;
    @Mock
    private StudentValueGenerator studentValueGenerator = new StudentValueGenerator();
    private University university;

    @BeforeEach
    public void setUp() {
        student1 = new Student("Евгений", true);
        student2 = new Student("Марина", false);
        student3 = new Student("Алина", false);

        university = new University(studentValueGenerator);

        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
    }

    @Test
    public void getAllStudents() {
        assertNotNull(studentValueGenerator);

        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);

        university.addStudent(student);
        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(3).getAge(), 50);
    }

    @Test
    public void getAllStudentsNotNull() {

        List<Student> expected = university.getAllStudents();

        assertNotNull(expected);

    }

    @Test
    public void getAllStudentsIsMale() {

        List<Student> expected = university.getAllStudents(true);

        List<Student> actual = new ArrayList<Student>();

        actual.add(student1);

        assertEquals(expected, actual);
    }
}
