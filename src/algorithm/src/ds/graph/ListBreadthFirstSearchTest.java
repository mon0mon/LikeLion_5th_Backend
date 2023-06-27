package ds.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ListBreadthFirstSearchTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public void setupStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void flushStream() {
        System.out.flush();
    }


    @Test
    void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(("8 10\n"
            + "0 1\n"
            + "0 2\n"
            + "0 3\n"
            + "1 3\n"
            + "1 4\n"
            + "2 5\n"
            + "3 4\n"
            + "4 7\n"
            + "5 6\n"
            + "6 7").getBytes()));
        new ListBreadthFirstSearch().solution();

        final String expected = "[0, 1, 2, 3, 4, 5, 7, 6]";

        assertEquals(expected, outContent.toString().strip());
    }
}