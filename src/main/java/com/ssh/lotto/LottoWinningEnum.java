package com.ssh.lotto;


public enum LottoWinningEnum {

    THREE(5000, "3개 일치", 3),
    FOUR(50000, "4개 일치", 4),
    FIVE(1500000, "5개 일치", 5),
    SIX(2000000000, "6개 일치", 6);

    private final String desc;
    private int prizeMoney;
    private int correctCnt;

    LottoWinningEnum(int prizeMoney, String desc, int correctCnt) {
        this.prizeMoney = prizeMoney;
        this.desc = desc;
        this.correctCnt = correctCnt;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDesc() {
        return desc;
    }

    public static LottoWinningEnum getResult(int result) {
        for (LottoWinningEnum e : values()) {
            if (e.correctCnt == result) {
                return e;
            }
        }
        return null;
    }

}
