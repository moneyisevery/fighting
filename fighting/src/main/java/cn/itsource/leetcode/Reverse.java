package cn.itsource.leetcode;

import java.util.Arrays;

/**
 * @author yb
 * @date 2020/11/15 0015 10:54
 * @Description:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * @Version:1.0
 */
public class Reverse {

    public static void main(String[] args) {

        char[] str = {'y','a','n','g','b','o'};
        str =  doublePointer(str,0,str.length-1);
        System.out.println(Arrays.toString(str));
    }

    /**
     * 递归解法
     * @param str
     * @param L
     * @param R
     * @return
     */
    private static char[] reverse(char[] str, int L, int R) {
        //递归退出条件
        if(L>=R){
            return str;
        }
        //交换位置
        char temp=str[L];
        str[L]=str[R];
        str[R]=temp;
        L++;R--;
        return reverse(str,L,R);
    }

    /**
     * 双指针
     *
     */
    private  static char[] doublePointer(char[] str, int L, int R){
       while (L<R){
           char temp=str[L];
           str[L]=str[R];
           str[R]=temp;
           L++;R--;
       }
       return str;
    }

}
