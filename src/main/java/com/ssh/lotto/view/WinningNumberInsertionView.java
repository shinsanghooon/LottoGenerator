package com.ssh.lotto.view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WinningNumberInsertionView {

    static public Set<Integer> insertWinningNumber(int numberOfLine) {
        Scanner sc = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        Set<Integer> winningNumberSet = new HashSet<>();
        for (int i = 0; i < numberOfLine; i++) {
            String next = sc.next().split(",")[0];
            winningNumberSet.add(Integer.parseInt(next));
        }

        System.out.println();

        return winningNumberSet;
    }

}
