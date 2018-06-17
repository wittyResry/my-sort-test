package com.resry.select;

/**
 * @author resry.lqy
 * @version $Id: MySelect.java, v 0.1 2018-06-16 22:36 resry.lqy Exp $
 */
public interface MySelect {

    /**
     * 选择第id大小的元素
     *
     * @param a 目标数组
     * @param id 排名第id的元素，id取值在[1,a.length]之间
     * @return
     */
    int select(int[] a, int id);
}
