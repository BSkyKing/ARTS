package leetcode.btj.week2;

import java.util.HashMap;

public class LeetCodeOne {


    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     *
     * 例如，
     *
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     * 示例 1:
     *
     * 输入: "A"
     * 输出: 1
     * 示例 2:
     *
     * 输入: "AB"
     * 输出: 28
     * 示例 3:
     *
     * 输入: "ZY"
     * 输出: 701
     */



//    执行用时 : 6 ms, 在Excel Sheet Column Number的Java提交中击败了47.04% 的用户
//内存消耗 : 36.5 MB, 在Excel Sheet Column Number的Java提交中击败了34.93% 的用户
    //AB = 26*1+ 2 ZB = 26 * 26 + 2  AAB = 26*26*1 + 26*1 + 2; 实质就是26进制转化为10进制
    public static int titleToNumber(String s) {
        int sum = 0;
        int length = s.length();
        for (int i = 0 ; i < length ; i++) {
            sum +=  (Math.pow(26,length - i - 1)) * (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }

    /**
     * 实质也是26进制转化为10进制。。从最低位开始加
     * @param s
     * @return
     */
   public static int titleToNumber2(String s) {
       int sum = 0;
       int base = 1;
       for (int i = s.length() - 1 ; i >= 0 ; i--) {
           sum += (s.charAt(i)-'A'+1)*base;
           base = base * 26;
       }
        return sum;

   }

    /**
     * 实质也是26进制转化为10进制。。
     * 从最高位开始。。这个实现思路是 每循环一次。。所有的位数都乘以26。。 最高位乘的最多
     * @param s
     * @return
     */
   public static int titleToNumber3(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() ; i++) {
            sum = sum * 26 + s.charAt(i) - 'A' + 1;
        }
        return sum;
   }

    public static void main(String[] args) {

        int an = titleToNumber("AN");
        System.out.println(an);
    }
}
