package leetcode.btj.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeOne {

//    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//    返回 s 所有可能的分割方案。
//
//    示例:
//
//    输入: "aab"
//    输出:
//            [
//            ["aa","b"],
//            ["a","a","b"]
//            ]
//    public List<List<String>> partition(String s) {
//        List<List<String>> list = new ArrayList<>();
//
//        char[] chars = s.toCharArray();
//
//        s.get()
//
//    }

    public static void main(String[] args) {
        String s = "abc";
        List<List<String>> lists = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
       // partition1(s,lists,list);
        char[] chars = s.toCharArray();
        partition2(chars,0,lists,list);
        System.out.println(lists);
}


// 这个方法需要20多秒
    public  static void partition1(String s ,List<List<String>> lists, LinkedList<String> list) {

        for (int i = 0 ; i < s.length() ; i++) {
            String x = s.substring(0,i+1);
            //之前使用的是StringBuilder（耗时比较长）判断是不是回文。。
            if (isBackText(x)) {
                String b = s.substring(i + 1);
                list.add(x);
                if (b.equals("")) {
                    lists.add(list);
                    return ;
                }
                LinkedList<String> clist = new LinkedList<>(list);
                partition1(b,lists,clist);
                //退回时，需要把之前的加入的x移除掉
                list.removeLast();
            }
        }
    }

    public static boolean isBackText(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    //直接通过下标的方式更快一点
    public  static void partition2(char[] chars,int start ,List<List<String>> lists, LinkedList<String> list) {
        if (start == chars.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start ; i < chars.length ; i ++) {
            if (isPaLine(chars,start, i )) {
                list.add(new String(chars,start ,i - start + 1));
                partition2(chars,i + 1,lists,list);
                list.removeLast();
            }
        }

    }

    private static boolean isPaLine(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left ++]!= chars[right--] ) {
                return false;
            }
        }
        return true;
    }


}
