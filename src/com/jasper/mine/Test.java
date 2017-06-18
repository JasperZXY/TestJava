package com.jasper.mine;


import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "你好";
        System.out.println(str.length());
        System.out.println(str.getBytes().length);
        try {
            System.out.println(Charset.defaultCharset().name());
            System.out.println(str.getBytes("GBK").length);
            System.out.println(str.getBytes("UTF-8").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}


