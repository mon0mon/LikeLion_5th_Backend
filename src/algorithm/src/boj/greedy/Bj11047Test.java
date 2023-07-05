package boj.greedy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class Bj11047Test {
    @Test
    void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(("10 4200\n"
            + "1\n"
            + "5\n"
            + "10\n"
            + "50\n"
            + "100\n"
            + "500\n"
            + "1000\n"
            + "5000\n"
            + "10000\n"
            + "50000\n").getBytes()));

        Assertions.assertEquals(6, new Bj11047().solution());
    }

    @Test
    void tc2() throws IOException {
        System.setIn(new ByteArrayInputStream(("10 4790\n"
            + "1\n"
            + "5\n"
            + "10\n"
            + "50\n"
            + "100\n"
            + "500\n"
            + "1000\n"
            + "5000\n"
            + "10000\n"
            + "50000\n").getBytes()));

        Assertions.assertEquals(12, new Bj11047().solution());
    }
}