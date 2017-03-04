package com.smallmao.classical;

/**
 * Created by Administrator on 2017/2/22 0022.
 */

/**
 * kmp算法的复杂度是O(n+m)，可以采用均摊分析来解答，具体可参考算法导论
 * 参考文章:http://blog.csdn.net/yutianzuijin/article/details/11954939/
 */
public class KMPTest {

    public static void main(String[] args) {
        String s = "abacaabacabacabaabb"; // 主串
        String t = "abacab";     // 模式串
        int[] next = getNext(t);
        search(s,t,next);

        String str = "maowenqiangmaowenmao"; // 模式串
        int[] arr = getNext(str);
        for (int i=0;i<arr.length;i++) {
            System.out.println("长度为"+ i +"的模式串" + str.substring(0,i) + "的前缀和后缀最大公共长度:"+ arr[i]);
        }

    }

    /**计算完成next数组之后，我们就可以利用next数组在字符串O中寻找字符串f的出现位置。
     * 匹配的代码和求next数组的代码非常相似，因为匹配的过程和求next数组的过程其实是一样的。
     * 假设现在字符串f的前i个位置都和从某个位置开始的字符串O匹配，现在比较第i+1个位置。
     * 如果第i+1个位置相同，接着比较第i+2个位置；如果第i+1个位置不同，则出现不匹配，
     * 我们依旧要将长度为i的字符串分割，获得其最大公共长度next[i]，然后从next[i]继续比较两个字符串。
     *
     * @param original
     * @param find
     * @param next
     */
    public static void search(String original, String find, int next[]) {
        int j = 0;
        for (int i = 0; i < original.length(); i++) {
            while (j > 0 && original.charAt(i) != find.charAt(j))
                j = next[j];
            if (original.charAt(i) == find.charAt(j))
                j++;
            if (j == find.length()) {
                System.out.println("find at position " + (i - j + 1));
                System.out.println(original.subSequence(i - j + 1, i + 1));
                j = next[j];
            }
        }
    }

    /**
     * 最大公共长度在算法导论里面被记为next数组。在这里要注意一点，next数组表示的是长度，
     * 下标从1开始；但是在遍历原字符串时，下标还是从0开始。
     * 假设我们现在已经求得next[1]、next[2]、……next[i]，分别表示<b>长度为1到i的字符串的前缀和后缀最大公共长度</b>
     * @param b
     * @return
     */
    public static int[] getNext(String b)
    {
        int len=b.length();
        int j=0;

        int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0]=next[1]=0;

        for(int i=1;i<len;i++)//i表示字符串的下标，从0开始
        {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            while(j>0&&b.charAt(i)!=b.charAt(j))j=next[j];
            if(b.charAt(i)==b.charAt(j))j++;
            next[i+1]=j;
        }

        return next;
    }
}
