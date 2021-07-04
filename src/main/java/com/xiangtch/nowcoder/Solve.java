package com.xiangtch.nowcoder;

/**
 *  大数加法 - 字符串从尾部插入
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/6/28 0:58
 */
public class Solve {

    public static void main(String[] args) {
        String s = "1", t = "99";
        System.out.println(sumBigNum(s, t));

    }

    private static String sumBigNum(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry !=0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        return stringBuilder.reverse().toString();
    }
}
