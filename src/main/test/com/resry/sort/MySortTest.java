package com.resry.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author resry.lqy
 * @version $Id: MySortTest.java, v 0.1 2018-04-22 21:29 resry.lqy Exp $
 */
public class MySortTest {

    /** 测试数据集大小 */
    private static final int SIZE = 4000;

    /**
     * run time: 3.5s
     */
    @Test
    public void insertSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new InsertSort());
        }
    }

    /**
     * run time: 8s
     */
    @Test
    public void selectionSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new SelectionSort());
        }
    }

    /**
     * run time: 1.7s
     */
    @Test
    public void mergeSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new MergeSort());
        }
    }

    /**
     * run time: 1.4s
     */
    @Test
    public void heapSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new HeapSort());
        }
    }

    /**
     * run time: 1.5s
     */
    @Test
    public void priorityQueueSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new PriorityQueueSort());
        }
    }

    /**
     * run time: 1.2s
     */
    @Test
    public void quickSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new QuickSort());
        }
    }

    /**
     * run time: 1.3s
     */
    @Test
    public void randomizedQuickSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new RandomizedQuickSort());
        }
    }

    /**
     * run time: 23.713s
     */
    @Test
    public void bubbleSort() {
        for (int i = 0; i < SIZE; ++i) {
            sort(i, new BubbleSort());
        }
    }


    @Test
    public void arrayCopy() {
        Integer[] a = new Integer[10];
        for (int i = 0; i < 10; ++i) {
            a[i] = 10 - i;
        }
        Integer[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        for (int i = 0; i < 10; ++i) {
            Assert.assertEquals("Arrays.copyOf测试", 11, a[i] + b[i]);
        }
    }

    private void sort(int n, MySort mySort) {
        int[] a = getRandomNumber(n, Integer.MAX_VALUE);
        int[] b = Arrays.copyOf(a, a.length);
        //使用库排序和标准的排序进行比较
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