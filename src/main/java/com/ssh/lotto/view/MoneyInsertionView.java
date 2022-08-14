package com.ssh.lotto.view;

import java.util.Scanner;

public class MoneyInsertionView {

    static public int insertMoney() {
        System.out.println("구매 금액을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        return money;
    }

}
