package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/28 12:12
 */
public class Translate {

    public static void main(String[] args) {
        String s = "abz";
        int[] shifts = new int[]{3, 5, 9};

        for (int i = 0; i < shifts.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                char c = (char) (s.charAt(j) + shifts[i]);
                if (c > 'z') {
                    int offset = (c - 'z') % 26;
                    c = (char) ('a' + offset - 1);
                }
                sb.append(c);
            }
            String substring = s.substring(i + 1);
            sb.append(substring);
            s = sb.toString();
        }
        System.out.println(s);
    }
}
