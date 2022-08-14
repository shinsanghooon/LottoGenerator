package com.ssh.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 당첨 확인 기계는 ")
class LottoWinningCheckerTest {

    LottoWinningChecker winningChecker = new LottoWinningChecker();
    Set<Integer> winningNumberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private List<Lotto> ArrayList;

    @DisplayName("3개의 숫자를 1개, 4개를 1개 맞춘 경우 당첨 로또 개수를 반환한다.")
    @Test
    void multipleMatchesLine() {
        // given
        List<Lotto> myLotto = new ArrayList<>();
        Lotto lotto1 = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 14, 15, 16)));
        Lotto lotto2 = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16)));
        myLotto.add(lotto1);
        myLotto.add(lotto2);

        // when
        Map<LottoWinningEnum, Integer> result =
                winningChecker.execute(myLotto, winningNumberSet);

        // then
        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(1);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(1);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(0);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideLottoResultList")
    void lottoResultTest(String name, Lotto lotto, int[] results) {

        List<Lotto> myLotto = new ArrayList<>();
        myLotto.add(lotto);

        Map<LottoWinningEnum, Integer> result =
            winningChecker.execute(myLotto, winningNumberSet);

        assertThat(result.get(LottoWinningEnum.THREE)).isEqualTo(results[0]);
        assertThat(result.get(LottoWinningEnum.FOUR)).isEqualTo(results[1]);
        assertThat(result.get(LottoWinningEnum.FIVE)).isEqualTo(results[2]);
        assertThat(result.get(LottoWinningEnum.SIX)).isEqualTo(results[3]);
    }

    private static Stream<Arguments> provideLottoResultList() {
        return Stream.of(
            Arguments.of(
                "하나도 못 맞춘 경우, 당첨 로또 개수를 반환한다.",
                new Lotto(new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16))),
                new int[]{0, 0, 0, 0}),
            Arguments.of(
                "3개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.",
                new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 14, 15, 16))),
                new int[]{1, 0, 0, 0}),
            Arguments.of(
                "4개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.",
                new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16))),
                new int[]{0, 1, 0, 0}),
            Arguments.of(
                "5개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.",
                new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 16))),
                new int[]{0, 0, 1, 0}),
            Arguments.of(
                "6개의 숫자를 1개만 맞춘 경우, 당첨 로또 개수를 반환한다.",
                new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new int[]{0, 0, 0, 1})
        );
    }
}
