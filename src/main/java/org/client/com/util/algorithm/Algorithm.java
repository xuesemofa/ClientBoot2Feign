package org.client.com.util.algorithm;

public class Algorithm {

    public static String en(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 300);
        }
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 2000);
        }
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ 5000);
        }
        return new String(c);
    }
}
