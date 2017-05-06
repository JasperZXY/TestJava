package com.jasper.mine;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        System.out.println(test());
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        BigDecimal bigDecimal1 = new BigDecimal(19.501);
//        System.out.println(bigDecimal1.setScale(2, BigDecimal.ROUND_HALF_UP));
//        BigDecimal bigDecimal2 = new BigDecimal(19.506);
//        System.out.println(bigDecimal2.setScale(2, BigDecimal.ROUND_HALF_UP));

//        try {
//            Date rel = parse("2016-02-13", "yyyy/MM/dd") ;
//        } catch (ParseException e){
//            e.printStackTrace();
//        }

String text = "[{name:a,category:1},{name:b,category:1},{name:c,category:4},{name:d,category:5}]";
Pattern pattern = Pattern.compile("name:(.*?),category:1");
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}
    }

    private static Date parse(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(dateStr);
    }

    public static String test() {
        try {
            System.out.println("try block");
            return test1();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test1() {
        System.out.println("return statement");
        return "after return";
    }
}


