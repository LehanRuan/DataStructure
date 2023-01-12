package Array_.RemoveElem;

 /*
    leetcode : https://leetcode.cn/problems/backspace-string-compare/
  */

public class BackspaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        //
        int sl = s.length() - 1;
        int tl = t.length() - 1;
        int skips = 0;
        int skipt = 0;

        //有时也要从后往前进行双指针，根据题目的要求灵活应变
        while (sl >= 0 || tl >= 0) {
            /*
            如若遇到#,则让skip++，指针位置往前移动
            若skip > 0 则代表#消除字母没消耗完，继续往前移动
             */

            while (sl >= 0) {
                if (s.charAt(sl) == '#') {
                    skips++;
                    sl--;
                }else if (skips > 0) {
                    skips--;
                    sl--;
                }else {
                    break;
                }
            }
            while (tl >= 0) {
                if (t.charAt(tl) == '#') {
                    skipt++;
                    tl--;
                }else if (skipt > 0) {
                    skipt--;
                    tl--;
                }else {
                    break;
                }
            }
            if (sl >= 0 && tl >= 0) {
                if (t.charAt(tl) != s.charAt(sl)) {
                    //两字母不等返回false
                    return false;
                }
                //有一方移动结束，代表也不相同返回false
            } else if (sl >= 0 || tl >= 0) {
                return false;
            }
            sl--;
            tl--;
        }
        return true;
    }
}
