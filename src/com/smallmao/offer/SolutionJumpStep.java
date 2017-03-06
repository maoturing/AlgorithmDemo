package com.smallmao.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by Administrator on 2017/3/6 0006.
 */
public class SolutionJumpStep {

    /**
     * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、...到跳n级
     * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
     * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
     * 所以f(n)=f(n-1)+f(n-2)+...+f(1)
     * 因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
     * 所以f(n)=2*f(n-1)
     * 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
     *            1       ,(n=0 ) 
     * f(n) =     1       ,(n=1 )
     *            2*f(n-1),(n>=2)
     *
     * @param target
     * @return
     */
    public static int jumpStep(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpStep(target - 1);
        }
    }

    public static void main(String[] args) {
        int count = jumpStep(5);
        System.out.println(count);
    }
}
