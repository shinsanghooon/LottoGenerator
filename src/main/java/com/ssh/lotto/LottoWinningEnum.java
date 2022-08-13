package com.ssh.lotto;


public enum LottoWinningEnum {

    THREE(5000, "3개 일치"),
    FOUR(50000, "4개 일치"),
    FIVE(1500000, "5개 일치"),
    SIX(2000000000, "6개 일치");

    private final String desc;
    private int prizeMoney;

    LottoWinningEnum(int prizeMoney, String desc) {
        this.prizeMoney = prizeMoney;
        this.desc = desc;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDesc() {
        return desc;
    }
}
