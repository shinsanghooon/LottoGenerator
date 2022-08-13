package com.ssh.lotto;

import java.util.Map;

public class LottoResultReviewer {

    /**
     * 로또 결과를 프린트한다.
     * @param lottoWinningMap 로또 결과가 담긴 Map
     */
    static public void printLottoResult(Map<LottoWinningEnum, Integer> lottoWinningMap) {
        for (LottoWinningEnum lottoAwardEnum : lottoWinningMap.keySet()) {
            int count = lottoWinningMap.get(lottoAwardEnum);
            System.out.println(lottoAwardEnum.getDesc() + " (" + lottoAwardEnum.getPrizeMoney() + "원) - " + count + "개");
        }
    }

    /**
     * 수익률을 프린트한다.
     * @param money 로또 구매에 사용한 금액
     * @param lottoWinningMap 로또 결과가 담긴 Map
     */
    static public void calculateReturnRate(int money, Map<LottoWinningEnum, Integer> lottoWinningMap) {
        int sum = 0;
        for (LottoWinningEnum lottoAwardEnum : lottoWinningMap.keySet()) {
            sum += lottoAwardEnum.getPrizeMoney() * lottoWinningMap.get(lottoAwardEnum);
        }
        System.out.println("총 수익률은 " + sum * 1.0 / money * 1.0 * 100 + "% 입니다.");
    }
}
