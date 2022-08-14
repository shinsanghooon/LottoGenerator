package com.ssh.lotto;

import com.ssh.lotto.view.LottoResultPrintView;
import com.ssh.lotto.view.MoneyInsertionView;
import com.ssh.lotto.view.PurchasedLottoListPrintView;
import com.ssh.lotto.view.WinningNumberInsertionView;

import java.util.*;

public class LottoApp {

    private static final int NUMBER_OF_ONE_LINE = 6;

    public static void main(String[] args) {

        // 구매 금액 입력
        int money = MoneyInsertionView.insertMoney();

        // 로또 생성
        LottoGenerator lottoGenerator = new LottoGenerator(NUMBER_OF_ONE_LINE);
        List<Lotto> myLotto = lottoGenerator.getLottos(money);

        // 구매한 로또 번호 출력
        PurchasedLottoListPrintView.print(myLotto);

        // 당첨 번호 입력
        Set<Integer> winningNumberSet = WinningNumberInsertionView.insertWinningNumber(NUMBER_OF_ONE_LINE);

        // 당첨 확인
        LottoWinningChecker winningChecker = new LottoWinningChecker();
        Map<LottoWinningEnum, Integer> result = winningChecker.execute(myLotto, winningNumberSet);

        // 수익률 계산
        double returnRate = LottoResultReviewer.getReturnRate(money, result);

        // 결과 출력
        LottoResultPrintView.printResultInit();
        LottoResultPrintView.printLottoResult(result);
        LottoResultPrintView.calculateReturnRate(returnRate);

    }
}
