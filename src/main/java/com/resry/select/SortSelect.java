package com.resry.select;

import java.util.Arrays;

/**
 * @author resry.lqy
 * @version $Id: SortSelect.java, v 0.1 2018-06-17 08:05 resry.lqy Exp $
 */
public class SortSelect implements MySelect {
    /**
     * ˼·��������󷵻ؽ����ƽ��ʱ�临�Ӷ�O(N*logN)
     */
    @Override
    public int select(int[] a, int id) {
        Arrays.sort(a);
        return a[id - 1];
    }
}
