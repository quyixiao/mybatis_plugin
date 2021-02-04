package com.admin.crawler.utils;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isUpperCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static String getDataBaseColumn(String javaName) {
        StringBuilder sb = new StringBuilder();
        char[] javaNames = javaName.toCharArray();
        int i = 0;
        for (char c : javaNames) {
            if (i != 0 && isUpperCase(c)) {
                sb.append("_");
            }
            sb.append((c + "").toLowerCase());
            i++;
        }
        return sb.toString();
    }


    public static String field2JavaCode(String field) {
        String javaCode = field;

        javaCode = javaCode.toLowerCase();
        javaCode = javaCode.trim();

        if (javaCode.contains("_")) {
            String[] codes = javaCode.split("_");
            if (codes.length > 1) {
                for (int i = 1; i < codes.length; i++) {
                    codes[i] = (codes[i].substring(0, 1)).toUpperCase()
                            + codes[i].substring(1);
                }
                javaCode = "";
                for (int i = 0; i < codes.length; i++) {
                    javaCode += codes[i];
                }
            }
            return javaCode;

        }
        return field;
    }


    public static void main(String[] args) {
        String a = "AbcA";
        System.out.println(getDataBaseColumn(a));
    }
}
