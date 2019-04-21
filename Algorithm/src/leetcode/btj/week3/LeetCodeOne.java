package leetcode.btj.week3;

public class LeetCodeOne {


 //     leetcode 125、验证回文串
//    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//    说明：本题中，我们将空字符串定义为有效的回文串。
//
//    示例 1:
//
//    输入: "A man, a plan, a canal: Panama"
//    输出: true
//    示例 2:
//
//    输入: "race a car"
//    输出: false


    /**
     * 保证左右都是数字或字母时相等就Ok了
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        boolean le = false;
        boolean lg = false;
        String a = "";
        String b = "";
        for(int left = 0 , right = s.length() - 1; left < right ; left ++ ,right --) {
            if (Character.isLetterOrDigit(s.charAt(left))) {
                le = true;
                a = String.valueOf(s.charAt(left));
            }
            if (Character.isLetterOrDigit(s.charAt(right))) {
                lg = true;
                b =  String.valueOf(s.charAt(right));
            }

            if (le && lg) {
                if (! a.equalsIgnoreCase(b)) {
                    return false;
                }
                le = false;
                lg = false;
            } else if (!le && lg) {
                right ++;
            } else if (le && !lg) {
                left --;
            }
        }
        if ((lg && !le)|| (le && !lg)) {
            return false;
        }
        return true;
    }

    /**
     * 对上面的方法的优化
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        int left = 0 ;
        int right = s.length() - 1;
       while (left < right) {
           if (!Character.isLetterOrDigit(s.charAt(left))) {
               left ++;
           }
           if (!Character.isLetterOrDigit(s.charAt(right))) {
               right --;
           }
           if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
               if (s.charAt(left) != s.charAt(right)) {
                   return false;
               }
               left ++;
               right --;
           }

       }
        return true;
    }
    /**
     * 直接通过stringBuilder的反转判断是否相等
     * @param s
     * @return
     */
    public static boolean isPalindrome3(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    public static void main(String[] args) {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);

    }
}
