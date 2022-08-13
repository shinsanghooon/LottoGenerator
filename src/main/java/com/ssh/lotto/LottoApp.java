package com.ssh.lotto;

import java.util.*;

public class LottoApp {

    private static final int NUMBER_OF_ONE_LINE = 6;

    public static void main(String[] args) {

        System.out.println("구매 금액을 입력해 주세요.");
        
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        LottoGenerator lottoGenerator = new LottoGenerator(NUMBER_OF_ONE_LINE);
        ArrayList<Lotto> myLotto = lottoGenerator.getLotto(money);

        System.out.println(myLotto.size() + "개를 구매했습니다.");

        for (Lotto lotto : myLotto) {
            System.out.println(lotto.toString());
        }

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        Set<Integer> winningNumberSet = new HashSet<>();
        for (int i = 0; i < NUMBER_OF_ONE_LINE; i++) {
            String next = sc.next().split(",")[0];
            winningNumberSet.add(Integer.parseInt(next));
        }

        LottoWinningChecker winningChecker = new LottoWinningChecker();
        Map<LottoWinningEnum, Integer> result = winningChecker.execute(myLotto, winningNumberSet);

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-----------------");
        LottoResultReviewer.printLottoResult(result);
        LottoResultReviewer.calculateReturnRate(money, result);

    }
}
