package com.ssh.lotto;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private int CNT_OF_LOTTO = 6;

    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        this.lotto = lotto;
        validateSize(lotto);
        validateDuplicate(lotto);
    }

    // 불변성을 유지 하기 위해 새로운 set를 만들어서 리턴하는게 맞나 ...
    public Set<Integer> getLotto() {
        return new HashSet<Integer>(lotto);
    }

    public int getSize() {
        return lotto.size();
    }

    private void validateSize(Set<Integer> lotto) {
        boolean isLottoSizeSix = lotto.size() == CNT_OF_LOTTO;
        if (!isLottoSizeSix) {
            throw new IllegalArgumentException("로또 한 줄에 포함되어야 하는 숫자는 6개입니다.");
        }
    }

    private void validateDuplicate(Set<Integer> lotto) {
        boolean isLottoRangeValid = lotto.stream().allMatch(v -> v >= 1 & v <= 45);
        if (!isLottoRangeValid) {
            throw new IllegalArgumentException("로또 숫자의 범위는 1~45 까지 입니다.");
        }
    }
}
