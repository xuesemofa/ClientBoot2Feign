package org.client.com.util.jvm;

import java.util.StringJoiner;

public class Bytes {
    /**
     * 由于String.subString对汉字处理存在问题（把一个汉字视为一个字节)，因此在
     * 包含汉字的字符串时存在隐患，现调整如下：
     *
     * @param src       要截取的字符串
     * @param start_idx 开始坐标（包括该坐标)
     * @param end_idx   截止坐标（包括该坐标）
     * @return
     */
    public static String substring(String src, int start_idx, int end_idx) {
        StringJoiner tgt = new StringJoiner("");
        if (src != null && !src.isEmpty()) {
            try {
                byte[] b = src.getBytes("UTF-8");
                for (int i = start_idx; i <= end_idx; i++) {
                    tgt.add(String.valueOf((char) b[i]));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tgt.toString();
    }
}
