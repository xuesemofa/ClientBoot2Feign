package org.client.com.util.base64;

public class Base64Test {

    public static void main(String[] args) {
        try {

            String s1 = Base64Util.decode("MTIzNDU2N2FB");
            String s = Base64Util.encode("1234567aA");
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
