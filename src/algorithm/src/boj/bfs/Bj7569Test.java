package boj.bfs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class Bj7569Test {

    @Test
    void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(("5 3 1\n"
            + "0 -1 0 0 0\n"
            + "-1 -1 0 1 1\n"
            + "0 0 0 1 1\n").getBytes()));

        assertEquals(-1, new Bj7569().solution());
    }

    @Test
    void tc2() throws IOException {
        System.setIn(new ByteArrayInputStream(("5 3 2\n"
            + "0 0 0 0 0\n"
            + "0 0 0 0 0\n"
            + "0 0 0 0 0\n"
            + "0 0 0 0 0\n"
            + "0 0 1 0 0\n"
            + "0 0 0 0 0\n").getBytes()));
        assertEquals(4, new Bj7569().solution());
    }

    @Test
    void tc3() throws IOException {
        System.setIn(new ByteArrayInputStream(("4 3 2\n"
            + "1 1 1 1\n"
            + "1 1 1 1\n"
            + "1 1 1 1\n"
            + "1 1 1 1\n"
            + "-1 -1 -1 -1\n"
            + "1 1 1 -1\n").getBytes()));
        assertEquals(0, new Bj7569().solution());
    }
}