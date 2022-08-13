package com.ssh.lotto;

import java.util.Map;

public class LottoResultReviewer {

    static public double getReturnRate(int money, Map<LottoWinningEnum, Integer> lottoWinningMap) {
        int sum = 0;
        for (LottoWinningEnum lottoAwardEnum : lottoWinningMap.keySet()) {
            sum += lottoAwardEnum.getPrizeMoney() * lottoWinningMap.get(lottoAwardEnum);
        }
        return sum * 1.0 / money * 1.0 * 100;
    }
}
