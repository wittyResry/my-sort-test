package com.resry.select;

import java.util.Arrays;

/**
 * @author resry.lqy
 * @version $Id: SortSelect.java, v 0.1 2018-06-17 08:05 resry.lqy Exp $
 */
public class SortSelect implements MySelect {
    /**
     * 思路：先排序后返回结果，平均时间复杂度O(N*logN)
     */
    @Override
    public int select(int[] a, int id) {
        Arrays.sort(a);
        return a[id - 1];
    }
}
