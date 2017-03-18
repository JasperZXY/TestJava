package com.jasper.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 设有N个人依次围成一圈，从第1个人开始报数，第M个人出列，
 * 然后从出列的下一个人开始报数，数到第M个人又出列，...，
 * 如此反复到所有的人全部出列为止，设N个人的编号分别为1，2，...，N，
 * 打印出出列的顺序，要求用java实现。
 */
public class CircleMN {
    public static void main(String[] args) {
        circle(5, 1);
        circle(5, 2);
        circle(5, 7);
    }

    private static void circle(int n, int m) {
        if (n <= 0 || m <= 0) {
            return;
        }

        System.out.println();
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (!list.isEmpty()) {
            index = (index + m - 1) % list.size();
            System.out.printf(list.get(index) + " ");
            list.remove(index);
        }
    }

}
