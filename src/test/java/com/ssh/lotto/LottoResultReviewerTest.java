package com.ssh.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultReviewerTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideLottoReturnRate")
    void returnRateTest(String name, int result, int money, Map<LottoWinningEnum, Integer> lottoWinningMap) {

        int returnRate = LottoResultReviewer.getReturnRate(money, lottoWinningMap);

        assertThat(returnRate).isEqualTo(result);

    }

    private static Stream<Arguments> provideLottoReturnRate() {
        return Stream.of(
            Arguments.of(
                "1000원으로 5000원의 당첨된 경우 수익률은 500% 이다.",
                500,
                1000,
                new HashMap<LottoWinningEnum, Integer>(){{
                    put(LottoWinningEnum.THREE, 1);
                    put(LottoWinningEnum.FOUR, 0);
                    put(LottoWinningEnum.FIVE, 0);
                    put(LottoWinningEnum.SIX, 0);
                }}),
            Arguments.of(
                "5000원으로 0원의 당첨된 경우 수익률은 0% 이다.",
                0,
                5000,
                new HashMap<LottoWinningEnum, Integer>(){{
                    put(LottoWinningEnum.THREE, 0);
                    put(LottoWinningEnum.FOUR, 0);
                    put(LottoWinningEnum.FIVE, 0);
                    put(LottoWinningEnum.SIX, 0);
                }}),
            Arguments.of(
                "6000원으로 5000원의 당첨된 경우 수익률은 83% 이다.",
                83,
                6000,
                new HashMap<LottoWinningEnum, Integer>(){{
                    put(LottoWinningEnum.THREE, 1);
                    put(LottoWinningEnum.FOUR, 0);
                    put(LottoWinningEnum.FIVE, 0);
                    put(LottoWinningEnum.SIX, 0);
                }}),
            Arguments.of(
                "1000원으로 50000원의 당첨된 경우 수익률은 5000% 이다.",
                5000,
                1000,
                new HashMap<LottoWinningEnum, Integer>(){{
                    put(LottoWinningEnum.THREE, 0);
                    put(LottoWinningEnum.FOUR, 1);
                    put(LottoWinningEnum.FIVE, 0);
                    put(LottoWinningEnum.SIX, 0);
                }})
        );
    }

}
