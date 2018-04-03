package org.client.com.util.sl4j;

import org.client.com.util.date.Dates2;

import java.util.StringJoiner;

public class Sl4jToString {

    public static String info(int lx, String services, String methods, String parameters, int resultCode, String resultMessge) {
        StringJoiner sj = new StringJoiner("");
        String str = "---";

        switch (lx) {
            case 1:
                sj.add("==>  [");
                sj.add("入参");
                break;
            case 2:
                sj.add("<==  [");
                sj.add("出参");
                break;
            default:
                sj.add("未知类型");
                break;
        }
        sj.add(Dates2.getDateTimeString());
        sj.add("]");
        sj.add(str);

        sj.add("service:[");
        sj.add(services);
        sj.add("]");
        sj.add(str);

        sj.add("method:[");
        sj.add(methods);
        sj.add("]");
        sj.add(str);

        sj.add("parameters:[");
        sj.add(parameters);
        sj.add("]");
        sj.add(str);

        sj.add("resultCode:[");
        sj.add(resultCode + "");
        sj.add("]");
        sj.add(str);
        sj.add("resultMessge:[");
        sj.add(resultMessge == null ? "" : resultMessge);
        sj.add("]");

        return sj.toString();
    }
}
