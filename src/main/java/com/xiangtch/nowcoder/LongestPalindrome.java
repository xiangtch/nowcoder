package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 10:52
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        // 获取最长回文子串
        System.out.println(getLongestPalindrome("abbba"));
    }

    private static int getLongestPalindrome(String str) {
        int maxlength = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            maxlength = Math.max(maxlength, Math.max(getLength(str, i, i), getLength(str, i, i + 1)));
        }
        return maxlength;
    }

    /**
     * 以 begin end 为中心获取最长回文长度
     * @param str
     * @param begin
     * @param end
     * @return
     */
    private static int getLength(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        return end - begin - 1;
    }
}
