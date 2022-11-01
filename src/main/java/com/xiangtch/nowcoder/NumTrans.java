package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/28 21:13
 */
public class NumTrans {

    private static String[] units = new String[]{"", "十", "百", "千", "万", "十", "百", "千", "亿"};
    private static String[] nums = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static void main(String[] args) {
        System.out.println(translate("12304"));
    }

    private static String translate(String numStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            int num = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if (num != 0) {
                String unit = units[numStr.length() - i - 1];
                result.append(nums[num]).append(unit);
            } else {
                if (i < numStr.length() - 1 && Integer.parseInt(String.valueOf(numStr.charAt(i + 1))) != 0) {
                    result.append(nums[0]);
                }
            }

        }
        return result.toString();
    }
}
