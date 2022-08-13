package com.ssh.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 당첨 확인 기계는 ")
class LottoWinningCheckerTest {

    LottoWinningChecker winningChecker = new LottoWinningChecker();
    Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("하나도 못 맞춘 경우, 당첨 로또 개수를 반환한다.")
    @Test
    void noMatchesLineCount() {
        // given
        Set<Integer>[] myLotto = new Set[1];
        HashSet<Integer> lotto = new HashSet<>(Arrays.asList(40, 41, 42, 43, 44, 45));
        myLotto[0] = lotto;

        // when
        Map<LottoWinningEnum, Integer> result =
                winningChecker.execute(myLotto, winningNumberSet);

        // then
        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(0);
    }

    @DisplayName("3개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.")
    @Test
    void threeMatchesLineCount() {
        // given
        Set<Integer>[] myLotto = new Set[1];
        HashSet<Integer> lotto = new HashSet<>(Arrays.asList(1, 2, 3, 11, 12, 13));
        myLotto[0] = lotto;

        // when
        Map<LottoWinningEnum, Integer> result =
                winningChecker.execute(myLotto, winningNumberSet);

        // then
        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(1);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(0);
    }

    @DisplayName("4개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.")
    @Test
    void fourMatchesLineCount() {
        // given
        Set<Integer>[] myLotto = new Set[1];
        HashSet<Integer> lotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 12, 13));
        myLotto[0] = lotto;

        // when
        Map<LottoWinningEnum, Integer> result =
                winningChecker.execute(myLotto, winningNumberSet);

        // then
        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(1);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(0);
    }

    @DisplayName("5개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.")
    @Test
    void fiveMatchesLineCount() {
        // given
        Set<Integer>[] myLotto = new Set[1];
        HashSet<Integer> lotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 13));
        myLotto[0] = lotto;

        // when
        Map<LottoWinningEnum, Integer> result =
                winningChecker.execute(myLotto, winningNumberSet);

        // then
        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(1);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(0);
    }

    @DisplayName("6개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.")
    @Test
    void sixMatchesLineCount() {
        // given
        Set<Integer>[] myLotto = new Set[1];
        HashSet<Integer> lotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        myLotto[0] = lotto;

        // when
        Map<LottoWinningEnum, Integer> result =
                winningChecker.execute(myLotto, winningNumberSet);

        // then
        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(1);
    }


    @DisplayName("3개의 숫자를 1개, 4개를 1개 맞춘 경우 당첨 로또 개수를 반환한다.")
    @Test
    void multipleMatchesLine() {
        // given
        Set<Integer>[] myLotto = new Set[2];
        HashSet<Integer> lotto1 = new HashSet<>(Arrays.asList(1, 2, 3, 14, 15, 16));
        HashSet<Integer> lotto2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16));
        myLotto[0] = lotto1;
        myLotto[1] = lotto2;

        // when
        Map<LottoWinningEnum, Integer> result =
                winningChecker.execute(myLotto, winningNumberSet);

        // then
        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(1);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(1);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(0);
    }

}