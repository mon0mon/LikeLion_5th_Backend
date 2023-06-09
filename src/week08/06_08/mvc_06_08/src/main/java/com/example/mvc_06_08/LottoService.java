package com.example.mvc_06_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class LottoService {
    private int hits = 0;
    private List<List<Integer>> history = new ArrayList<>();

    public int addHit() {
        hits++;
        return hits;
    }

    public List<Integer> getLottos() {
        Random random = new Random();
        List<Integer> lotto = List.of(
            random.nextInt(1, 46),
            random.nextInt(1, 46),
            random.nextInt(1, 46),
            random.nextInt(1, 46),
            random.nextInt(1, 46),
            random.nextInt(1, 46)
        );
        history.add(lotto);

        return lotto;
    }
}
