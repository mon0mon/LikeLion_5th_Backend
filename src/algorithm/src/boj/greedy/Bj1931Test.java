package boj.greedy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class Bj1931Test {
    @Test
    void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(("11\n"
            + "1 4\n"
            + "3 5\n"
            + "0 6\n"
            + "5 7\n"
            + "3 8\n"
            + "5 9\n"
            + "6 10\n"
            + "8 11\n"
            + "8 12\n"
            + "2 13\n"
            + "12 14\n").getBytes()));

        Assertions.assertEquals(4, new Bj1931().solution());
    }
}