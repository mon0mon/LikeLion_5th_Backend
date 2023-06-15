package brute_force.pattern_matching;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class BFPatternMatchingTest {

    @Test
    void solution() throws IOException {
        System.setIn(new ByteArrayInputStream(("qwertyuiuiuytrertyuiopopoiuytrqwertyuy"
            + "trertywqwertyuiuytrewqwertyuiiuiuiytrewert").getBytes()));
        System.setIn(new ByteArrayInputStream("qwert".getBytes()));

        BFPatternMatching bfPatternMatching = new BFPatternMatching();
        bfPatternMatching.solution();
    }
}