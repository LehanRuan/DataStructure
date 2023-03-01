package Hash;

//leetcode 383:https://leetcode.cn/problems/ransom-note/

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[25];
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
