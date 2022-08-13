package com.ssh.lotto;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class LottoGenerator {

    private int numberOfOneLine;

    public LottoGenerator(int numberOfOneLine) {
        this.numberOfOneLine = numberOfOneLine;
    }

    /**
     * 구매금액을 입력받아 로또 생성 후 리턴한다.
     * @param money 구매 금액
     * @return 생성된 로또 리스트
     */
    public ArrayList<Lotto> getLotto(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }

        int generate_cnt = money / 1000;

        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < generate_cnt; i++) {
            lottos.add(generateLottoOneLine());
        }

        return lottos;
    }

    /**
     * 로또 1줄을 생성한다.
     * @return 생성된 로또 1줄
     */
    private Lotto generateLottoOneLine() {
        Set<Integer> set = new TreeSet<>();
        while (!(set.size() == numberOfOneLine)) {
            set.add((int) (Math.random() * 45) + 1);
        }
        return new Lotto(set);
    }
}
