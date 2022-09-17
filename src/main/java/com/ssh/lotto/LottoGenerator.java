package com.ssh.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGenerator {

    private static int numberOfOneLine;

    private static int REQUIRED_MONEY_FOR_ONE_LOTTO = 1000;

    public LottoGenerator(int numberOfOneLine) {
        this.numberOfOneLine = numberOfOneLine;
    }

    /**
     * 구매금액을 입력받아 로또 생성 후 리턴한다.
     * @param money 구매 금액
     * @return 생성된 로또 리스트
     */
    public List<Lotto> getLottos(int money) {
        if (money < REQUIRED_MONEY_FOR_ONE_LOTTO) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }

        int generateCnt = money / REQUIRED_MONEY_FOR_ONE_LOTTO;

        List<Lotto> lottoList = Stream
            .generate(LottoGenerator::generateLottoOneLine)
            .limit(generateCnt)
            .collect(Collectors.toList());

        return lottoList;
    }

    /**
     * 로또 1줄을 생성한다.
     * @return 생성된 로또 1줄
     */
    private static Lotto generateLottoOneLine() {
        Set<Integer> set = new TreeSet<>();
        while (!(set.size() == numberOfOneLine)) {
            set.add((int) (Math.random() * 45) + 1);
        }

        return new Lotto(set);
    }
}
