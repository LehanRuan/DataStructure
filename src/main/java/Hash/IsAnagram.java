package Hash;

//leetcode 242: https://leetcode.cn/problems/valid-anagram/

public class IsAnagram {


    public boolean isAnagram (String s, String t) {
        int[] ans = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        //将s中的字母存储在ans数组中
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'A']++;
        }

        //将t中存在的s中的字母都消去
        for (int i = 0; i < t.length(); i++) {
            ans[s.charAt(i) - 'A']--;
        }

        for (int i = 0; i < s.length(); i++) {
            if (ans[s.charAt(i) - 'A'] != 0) {
                return false;
            }
        }

        return true;
    }
}
