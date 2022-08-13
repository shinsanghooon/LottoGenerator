package com.ssh.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 객체는 불변이어야 한다.")
    @Test
    void unmodifiableTest() {
        Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(40, 41, 42, 43, 44, 45)));
        Set<Integer> lottoSet = lotto.getLotto();
        lottoSet.add(10);
        lottoSet.add(20);

        assertThat(lotto.getLotto().size()).isEqualTo(6);
        assertThat(lottoSet.size()).isEqualTo(8);

    }

}
