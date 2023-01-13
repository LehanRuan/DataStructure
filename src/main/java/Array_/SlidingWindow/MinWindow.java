package Array_.SlidingWindow;

//leetcode 76:https://leetcode.cn/problems/minimum-window-substring/
public class MinWindow {

    public static void main(String[] args) {
        String p = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(p);
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        //数组用来记录字符串的出现次数
        int[] cnt = new int[128];
        //将t内出现的字符赋值1
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i)]++;
        }
        //count存放还需要扣除几次有用字符
        int count = t.length();
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0, i = 0; j < s.length(); j++) {
            //若遇到为1的字符就count--, 且减去出现的概率，用来筛选无用字符
            if (cnt[s.charAt(j)]-- > 0) {
                count--;
            }
            if (count == 0) {
                //处理到第一个有用字符前的无用字符, 并且再次增加该字符的次数，为了避免将有用的字符多减了
                while (cnt[s.charAt(i)] < 0) {
                    cnt[s.charAt(i++)]++;
                }
                //判断此次的字符串是否比上一次更小
                if (j - i + 1 < min) {
                    //因为最后是截取字符串需要重新赋值start的位置
                    start = i;
                    min = j - i  + 1;
                }
                //将i移动到第一个有用字符所在位置的下一个位置，且在cnt中增加需要被减的有用字符的次数
                cnt[s.charAt(i++)]++;
                count++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
