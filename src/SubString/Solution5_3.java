package SubString;

/**
 * @description: 最长回文子串，中心扩散法
 * @author: Yuner
 * @create: 2020-11-15 16:43
 **/
public class Solution5_3 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        char[] chars = s.toCharArray();
        int maxLen = 0;
        String res = "";
        int start = 0;

        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if (maxLen < (j - i + 1)) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

}
