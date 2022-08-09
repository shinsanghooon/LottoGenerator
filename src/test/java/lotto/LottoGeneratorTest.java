package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 생성기는 ")
class LottoGeneratorTest {

    int NUMBER_OF_ONE_LINE = 6;
    LottoGenerator lottoGenerator = new LottoGenerator(NUMBER_OF_ONE_LINE);
    int validMoney = 1000;
    int validMoney2 = 5000;
    int invalidMoney = 900;

    @DisplayName("입력된 금액에 맞게 로또 개수를 생성해야 한다.")
    @Test
    void generateLottoWithEnoughMoney() {

        // when
        Set<Integer>[] lotto = lottoGenerator.getLotto(validMoney);
        Set<Integer>[] lotto2 = lottoGenerator.getLotto(validMoney2);

        // then
        assertThat(lotto.length).isEqualTo(1);
        assertThat(lotto2.length).isEqualTo(5);
    }

    @DisplayName("1000원 미만을 입력하는 경우, 예외를 던진다.")
    @Test
    void generateLottoWithNotEnoughMoney() {
        // when
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> lottoGenerator.getLotto(invalidMoney));

        // then
        assertThat(illegalArgumentException.getMessage())
                .isEqualTo("구입 금액은 1000원 이상이어야 합니다.");
    }

    @DisplayName("로또 한 줄에 6개의 숫자를 생성해야하며 모두 중복이 없어야 한다.")
    @Test
    void lottoNumberSize() {
        //when
        Set<Integer>[] lottoArr = lottoGenerator.getLotto(validMoney);
        Set<Integer> lotto = lottoArr[0];

        //then
        assertThat(lotto.size()).isEqualTo(6);
    }

    @DisplayName("로또 한 줄에 1 ~ 45 범위의 숫자를 생성해야 한다.")
    @Test
    void lottoNumberRangeTest() {
        //when
        Set<Integer>[] lottoArr = lottoGenerator.getLotto(validMoney);
        Set<Integer> lotto = lottoArr[0];

        //then
        assertThat(lotto.stream().allMatch(v -> v >= 1 & v <= 45)).isTrue();
    }

}