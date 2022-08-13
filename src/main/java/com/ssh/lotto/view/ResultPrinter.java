package com.ssh.lotto.view;

import com.ssh.lotto.LottoWinningEnum;

import java.util.Map;

public class ResultPrinter {

    static public void printResultInit() {
        System.out.println("당첨 통계");
        System.out.println("-----------------");
    }

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

    static public void calculateReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "% 입니다.");
    }
}
