package com.resry.select;

/**
 * @author resry.lqy
 * @version $Id: MySelect.java, v 0.1 2018-06-16 22:36 resry.lqy Exp $
 */
public interface MySelect {

    /**
     * ѡ���id��С��Ԫ��
     *
     * @param a Ŀ������
     * @param id ������id��Ԫ�أ�idȡֵ��[1,a.length]֮��
     * @return
     */
    int select(int[] a, int id);
}
