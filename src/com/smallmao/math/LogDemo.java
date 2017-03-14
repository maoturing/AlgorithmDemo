package com.smallmao.math;

/**
 * Created by Administrator on 2017/3/15 0015.
 */
public class LogDemo {
    /**
     * 接收一个整型参数N,返回不大于log2N的最大整数(不适用Math库)
     * a^x = N  ==>  x = log2N
     * @param n
     * @return
     */
    public static int lg(int n) {
        //如果n是小于1的整数,那么n不在log函数的定义域内,返回-1
        if (n < 1) {
            return -1;
        }
        
        //如果ax<n,则ax乘2,x统计的是乘2的次数,也就是2^x中的x.
        int ax = 1;
        int x = 0;
        while (ax <= n) {
            ax = ax << 1;
            x++;
        }
        return x-1;
    }

    public static void main(String[] args) {
        System.out.println(lg(10));

    }
}
