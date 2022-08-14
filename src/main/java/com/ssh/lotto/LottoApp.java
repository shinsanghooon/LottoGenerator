package com.ssh.lotto;

import com.ssh.lotto.view.LottoResultPrintView;
import com.ssh.lotto.view.MoneyInsertionView;
import com.ssh.lotto.view.PurchasedLottoListPrintView;
import com.ssh.lotto.view.WinningNumberInsertionView;

import java.util.*;

public class LottoApp {

    private static final int NUMBER_OF_ONE_LINE = 6;

    public static void main(String[] args) {

        int money = MoneyInsertionView.insertMoney();

        LottoGenerator lottoGenerator = new LottoGenerator(NUMBER_OF_ONE_LINE);
        List<Lotto> myLotto = lottoGenerator.getLotto(money);

        PurchasedLottoListPrintView.print(myLotto);

        Set<Integer> winningNumberSet = WinningNumberInsertionView.insertWinningNumber(NUMBER_OF_ONE_LINE);
        LottoWinningChecker winningChecker = new LottoWinningChecker();
        Map<LottoWinningEnum, Integer> result = winningChecker.execute(myLotto, winningNumberSet);

        // 결과 출력
        double returnRate = LottoResultReviewer.getReturnRate(money, result);
        LottoResultPrintView.printResultInit();
        LottoResultPrintView.printLottoResult(result);
        LottoResultPrintView.calculateReturnRate(returnRate);

    }
}
