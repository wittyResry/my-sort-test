package com.resry.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author resry.lqy
 * @version $Id: InsertSortTest.java, v 0.1 2018-04-22 21:29 resry.lqy Exp $
 */
public class InsertSortTest {

    @Test
    public void insertSort() {
        for (int i = 0; i < 1000; ++i) {
            sort(i, new InsertSort());
        }
    }

    @Test
    public void selectionSort() {
        for (int i = 0; i < 1000; ++i) {
            sort(i, new SelectionSort());
        }
    }

    private void sort(int n, MySort mySort) {
        int[] a = getRandomNumber(n, Integer.MAX_VALUE);
        int[] b = Arrays.copyOf(a, a.length);
        mySort.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; ++i) {
            if (a[i] != b[i]) {
                System.out.print("a:");
                for (int j = 0; j < n; ++j) {
                    System.out.print(a[j] + " ");
                }
                System.out.print("\nb:");
                for (int j = 0; j < n; ++j) {
                    System.out.print(b[j] + " ");
                }
                System.out.print("\n");
            }
            Assert.assertEquals("元素不相等", a[i], b[i]);
        }
    }

    /**
     * 生成小于n个[0,m)的字母
     * @param n
     * @return
     */
    private int[] getRandomNumber(int n, int m) {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = (int) (Math.random() * m);
        }
        return a;
    }
}