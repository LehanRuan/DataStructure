package String_;

// leetcode 541:https://leetcode.cn/problems/reverse-string-ii/
public class ReverseStr2 {
    public String reverseStr(String s, int k) {
        StringBuffer result = new StringBuffer();
        int firstK = 0;
        int secondK = 0;
        int start = 0;
        int length = s.length();
        while (start < length) {
            StringBuffer temp = new StringBuffer();
            firstK = start + k > length ? length : start + k;
            secondK = firstK +  k > length ? length : firstK + k;

            temp.append(s.substring(start, firstK));
            result.append(temp.reverse());

            if (firstK < secondK) {
                result.append(s.substring(firstK, secondK));
            }

            start += 2 * k;
        }

        return String.valueOf(result);
    }
}
