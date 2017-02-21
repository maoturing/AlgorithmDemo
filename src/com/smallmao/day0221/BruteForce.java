package com.smallmao.day0221;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * 暴风(Brute Force)算法是普通的模式匹配算法，BF算法的思想就是将目标串S的第一个字符与模式串T的第一个字符进行匹配，<br/>
 * 若相等，则继续比较S的第二个字符和 T的第二个字符；若不相等，则比较S的第二个字符和T的第一个字符，依次比较下去，直到得出最后的匹配结果。<br/>
 * BF算法是一种蛮力算法。<br/>
 *
 * <b>得到的起始地址是从1开始计数的d </b> 
 */
public class BruteForce {
    //测试代码
    public static void main(String args[]){
        String str1="maowenqiangwensa";
        String str2="wen";
        List<Integer>indexList=BruteForce.indexOfStr(str1, str2);
        for(Integer index:indexList){
            System.out.println("起始地址:" + index);
        }
        Boolean flag=BruteForce.indexOf(str1, str2);
        System.out.println(str1 + "是否包含" + str2 +": " + flag);
    }

    /**
     * //str1中包含几个str2，返回在str1中的起始地址
     * @param str1
     * @param str2
     * @return
     */
    public static List<Integer> indexOfStr(String str1,String str2){
        char [] charArray1=str1.toCharArray();
        char [] charArray2=str2.toCharArray();
        List<Integer> list=new ArrayList<Integer>();    //存放str2在str1中的起始地址(从1开始计数)
        int k=0;
        for(int i=0;i<=charArray1.length-charArray2.length+1;i++){
            if(charArray1[i]==charArray2[k]){
                k++;
            }else{
                k=0;
            }
            //当char字符匹配数和str2长度相等时添加str2的起始地址
            if(k==charArray2.length){
                k=0;
                //当完全匹配时,第i个字符减去(charArray2.length-1)得到str2的起始地址,+1后获得从1计数的str2的起始地址
                list.add(i-charArray2.length + 1 + 1);
            }
        }
        return list;
    }

    /**
     * 判断str1中是否包含str1,返回boolean值
     * @param str1  目标字符串
     * @param str2  模式字符串
     * @return      str1中是否包含str1的布尔值
     */
    public static Boolean indexOf(String str1,String str2){
        char [] charArray=str1.toCharArray();
        char [] charArray1=str2.toCharArray();
        @SuppressWarnings("unused")
        List<Integer> list=new ArrayList<Integer>();
        int k=0;
        for(int i=0;i<=charArray.length-charArray1.length+1;i++){
            if(charArray[i]==charArray1[k]){
                k++;
            }else{
                k=0;
            }
            if(k==charArray1.length){
                k=0;
                return true;
            }
        }
        return false;
    }

}
