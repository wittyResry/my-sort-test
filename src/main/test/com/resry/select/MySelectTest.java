package com.resry.select;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.resry.common.TestTemplate;

/**
 * @author resry.lqy
 * @version $Id: MySelectTest.java, v 0.1 2018-06-16 22:46 resry.lqy Exp $
 */
public class MySelectTest extends TestTemplate {

    /**
     * 测试数据集大小
     */
    private static final int SIZE = 4000;

    @Test
    public void randomSelect() {
        select(new RandomSelect(), SIZE, false);
    }


    /**
     * 排序验证
     *
     * @param mySelect
     * @param n
     * @param keepMax  是否需要控制最大值在n以内
     */
    private void select(MySelect mySelect, int n, boolean keepMax) {
        for (int i = 1; i < n; ++i) {
            select(i, mySelect, keepMax ? i : Integer.MAX_VALUE);
        }
    }

    private void select(int n, MySelect myMyselect, int maxValue) {
        int[] a = getRandomNumber(n, maxValue);
        int[] b = Arrays.copyOf(a, a.length);
        //使用库排序和标准的排序进行比较
        int id = random(a.length);
        int x = myMyselect.select(a, id + 1);
        Arrays.sort(b);
        int y = b[id];
        Assert.assertEquals("判断相等", x, y);
    }
}