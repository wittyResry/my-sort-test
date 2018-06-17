package com.resry.common;

/**
 * @author resry.lqy
 * @version $Id: TestTemplate.java, v 0.1 2018-06-16 22:47 resry.lqy Exp $
 */
public class TestTemplate {
    /**
     * ����С��n��[0, m)����ĸ
     *
     * @param n
     * @return
     */
    protected int[] getRandomNumber(int n, int m) {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = random(m);
        }
        return a;
    }

    /**
     * @param m
     * @return ������ط���[0, m)
     */
    protected int random(int m) {
        return (int) (Math.random() * m);
    }
}
