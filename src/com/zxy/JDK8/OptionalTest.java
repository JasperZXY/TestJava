package com.zxy.JDK8;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optional 测试
 *
 * 这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 *
 * 例子来自：http://www.importnew.com/6675.html
 *
 */
public class OptionalTest {

    public static void main(String[] args) {
        // of() 为非null的值创建一个Optional。
        Optional<String> optionalName = Optional.of("zxy");
        try {
            Optional<String> optionalNull = Optional.of(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // ofNullable 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println("ofNullable isPresent " + optionalNull.isPresent());

        // isPresent 如果值存在返回true，否则返回false。
        // get 如果Optional有值则将其返回，否则抛出NoSuchElementException。
        if (optionalName.isPresent()) {
            System.out.println(optionalName.get());
        }
        try {
            System.out.println(optionalNull.get());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        // ifPresent 如果Optional实例有值则为其调用consumer，否则不做处理
        optionalName.ifPresent(val -> {
            System.out.println(val + " length:" + val.length());
        });

        // orElse 如果有值则将其返回，否则返回指定的其它值。
        System.out.println(optionalName.orElse("optionalName.orElse"));
        System.out.println(optionalNull.orElse("optionalNull.orElse"));

        // orElseGet 与orElse方法类似，可以接受Supplier接口的实现用来生成默认值
        System.out.println("=====orElseGet=====");
        System.out.println(optionalName.orElseGet(() -> "optionalName.orElseGet"));
        System.out.println(optionalNull.orElseGet(() -> "optionalNull.orElseGet"));

        // orElseThrow
        System.out.println("=====orElseThrow=====");
        try {
            optionalNull.orElseThrow(IndexOutOfBoundsException::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // map flatMap
        System.out.println("=====map flatMap=====");
        System.out.println(optionalName.map(String::toUpperCase).orElse("optionalName is null"));
        System.out.println(optionalNull.map(String::toUpperCase).orElse("optionalNull is null"));
        System.out.println(optionalName.flatMap(val -> Optional.of(val.toUpperCase())).orElse("optionalName is null"));
        System.out.println(optionalNull.flatMap(val -> Optional.of(val.toUpperCase())).orElse("optionalNull is null"));

        // filter 如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
        System.out.println("=====filter=====");
        System.out.println(optionalName.filter(val -> val.length() > 3).orElse("orElse more than 3"));
        System.out.println(optionalName.filter(val -> val.length() <= 3).orElse("orElse less than 3"));

    }
}
