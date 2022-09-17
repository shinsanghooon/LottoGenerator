package com.ssh.lotto.view;

import com.ssh.lotto.Lotto;
import com.ssh.lotto.LottoWinningEnum;

import java.util.List;
import java.util.Map;

public class PurchasedLottoListPrintView {

    static public void print(List<Lotto> myLotto) {
        System.out.println(myLotto.size() + "개 로또를 구매했습니다.");
        myLotto.stream().forEach(System.out::println);
        System.out.println();
    }
}
