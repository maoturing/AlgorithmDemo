package com.smallmao.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class CountNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        Map map = new HashMap();
        int count = 0;
        if(array == null) return 0;
        //这一行很关键，如果数组只有一个数，那么下面的循环无法得到正确结果
        if(array.length == 1) return array[0];
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                count = (int) map.get(array[i]);
                map.put(array[i], ++count);
                if (count > array.length / 2) {
                    System.out.println(array[i]);
                    return array[i];
                }
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println(array[0]);
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 1, 1};
        CountNum c = new CountNum();
        c.MoreThanHalfNum_Solution(array);
    }
}