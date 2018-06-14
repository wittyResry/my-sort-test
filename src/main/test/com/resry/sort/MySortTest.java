package com.resry.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author resry.lqy
 * @version $Id: MySortTest.java, v 0.1 2018-04-22 21:29 resry.lqy Exp $
 */
public class MySortTest {

    /**
     * 测试数据集大小
     */
    private static final int SIZE = 4000;

    /**
     * run time: 3.5s
     */
    @Test
    public void insertSort() {
        sort(new InsertSort(), SIZE);
    }

    /**
     * run time: 8s
     */
    @Test
    public void selectionSort() {
        sort(new SelectionSort(), SIZE);
    }

    /**
     * run time: 1.7s
     */
    @Test
    public void mergeSort() {
        sort(new MergeSort(), SIZE);
    }

    /**
     * run time: 1.4s
     */
    @Test
    public void heapSort() {
        sort(new HeapSort(), SIZE);
    }

    /**
     * run time: 1.5s
     */
    @Test
    public void priorityQueueSort() {
        sort(new PriorityQueueSort(), SIZE);
    }

    /**
     * run time: 1.2s
     */
    @Test
    public void quickSort() {
        //sort(100000000, new RadixSort(), Integer.MAX_VALUE);//runtime: 34.785s
        sort(new QuickSort(), SIZE);
    }

    /**
     * run time: 1.3s
     */
    @Test
    public void randomizedQuickSort() {
        sort(new RandomizedQuickSort(), SIZE);
    }

    /**
     * run time: 1.3s
     */
    @Test
    public void hoareQuickSort() {
        sort(new HoareQuickSort(), SIZE);
    }

    /**
     * run time: 23.713s
     */
    @Test
    public void bubbleSort() {
        sort(new BubbleSort(), SIZE);
    }

    /**
     * run time: 993ms
     */
    @Test
    public void countSort() {
        sort(new CountSort(), SIZE, true);
    }

    /**
     * run time: 1.25 s
     */
    @Test
    public void radixSort() {
        //sort(100000000, new RadixSort(), Integer.MAX_VALUE);//runtime: 35.521s
        sort(new RadixSort(), SIZE);
    }

    /**
     * 排序验证
     *
     * @param mySort
     */
    private void sort(MySort mySort, int n) {
        sort(mySort, n, false);
    }

    /**
     * 排序验证
     *
     * @param mySort
     * @param n
     * @param keepMax 是否需要控制最大值在n以内
     */
    private void sort(MySort mySort, int n, boolean keepMax) {
        for (int i = 0; i < n; ++i) {
            sort(i, mySort, keepMax ? i : Integer.MAX_VALUE);
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

    private void sort(int n, MySort mySort, int maxValue) {
        int[] a = getRandomNumber(n, maxValue);
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
     *
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