package lotto;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LottoWinningChecker {

    private final int MINIMUM_NUMBER_OF_WINNING = 3;

    /**
     * 로또 당첨 여부를 체크한다.
     * @param myLotto 구매한 로또 리스트
     * @return 로또 순위 별 당첨 개수가 포함된 Map
     */
    public Map<LottoWinningEnum, Integer> execute(Set<Integer>[] myLotto, Set<Integer> winningNumberSet) {

        Map<LottoWinningEnum, Integer> lottoWinningMap = new TreeMap<>();
        initializeMap(lottoWinningMap);

        for (Set<Integer> myLottoOneLine : myLotto) {
            myLottoOneLine.retainAll(winningNumberSet);

            int result = myLottoOneLine.size();
            if (result >= MINIMUM_NUMBER_OF_WINNING) {
                addResultToWinningMap(lottoWinningMap, result);
            }
        }

        return lottoWinningMap;
    }


    /**
     * 로또 당첨 횟수를 순위마다 0으로 초기화 한다
     * @param lottoWinningMap 로또 당첨 현황 Map
     */
    private void initializeMap(Map<LottoWinningEnum, Integer> lottoWinningMap) {
        lottoWinningMap.put(LottoWinningEnum.THREE, 0);
        lottoWinningMap.put(LottoWinningEnum.FOUR, 0);
        lottoWinningMap.put(LottoWinningEnum.FIVE, 0);
        lottoWinningMap.put(LottoWinningEnum.SIX, 0);
    }


    /**
     * 당첨 순위에 따라 카운트를 1개씩 증가시킨다.
     * @param lottoWinningMap 로또 당첨 현황 Map
     * @param result 로또 한 줄에 당첨된 번호의 수
     */
    private void addResultToWinningMap(Map<LottoWinningEnum, Integer> lottoWinningMap, int result) {
        if (result == 3) {
            lottoWinningMap.put(LottoWinningEnum.THREE, lottoWinningMap.get(LottoWinningEnum.THREE) + 1);
        } else if (result == 4) {
            lottoWinningMap.put(LottoWinningEnum.FOUR, lottoWinningMap.get(LottoWinningEnum.FOUR) + 1);
        } else if (result == 5) {
            lottoWinningMap.put(LottoWinningEnum.FIVE, lottoWinningMap.get(LottoWinningEnum.FIVE) + 1);
        } else {
            // result = 6
            lottoWinningMap.put(LottoWinningEnum.SIX, lottoWinningMap.get(LottoWinningEnum.SIX) + 1);
        }
    }


}
