package boj.greedy;

import boj.greedy.Bj2798;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class Bj2798Test {
    @Test
    void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(("5 21\n"
            + "5 6 7 8 9\n").getBytes()));

        Assertions.assertEquals(21, new Bj2798().solution());
    }

    @Test
    void tc2() throws IOException {
        System.setIn(new ByteArrayInputStream(("10 500\n"
            + "93 181 245 214 315 36 185 138 216 295\n").getBytes()));

        Assertions.assertEquals(497, new Bj2798().solution());
    }
}