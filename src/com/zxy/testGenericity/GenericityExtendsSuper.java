package com.zxy.testGenericity;

import com.zxy.testGenericity.domain.Apple;
import com.zxy.testGenericity.domain.Fruit;
import com.zxy.testGenericity.domain.Orange;
import com.zxy.testGenericity.domain.RedApple;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * ? 通配符类型
 * <? extends T> 表示类型的上界，表示参数化类型的可能是T 或是 T的子类；适用用“读”的情况
 * <? super T> 表示类型下界（Java Core中叫超类型限定），
 *      表示参数化类型是此类型的超类型（父类型），直至Object；适用用“写”的情况
 * </pre>
 */
public class GenericityExtendsSuper {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple());
        apples.add(new RedApple());
        List<? extends Fruit> fruits = apples;
        System.out.println(fruits);
        System.out.println(fruits.get(0));

        List<? super RedApple> redApples = apples;
        System.out.println(redApples);

        List<Apple> apples2 = new ArrayList<Apple>();
        write(apples2);
        read(apples2);
    }

    public static void write(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new RedApple());
//		apples.add(new Fruit());
//      Apple apple = apples.get(0);
    }

    public static void read(List<? extends Apple> apples) {
        Apple apple = apples.get(0);
        System.out.println(apple);
//      apples.add(new Apple());
    }

    // 赋值
    public static void assign() {
        List<? extends Fruit> list1 = new ArrayList<Fruit>();
        List<? extends Fruit> list2 = new ArrayList<Apple>();
        List<? extends Fruit> list3 = new ArrayList<Orange>();
//        List<? extends Apple> list = new ArrayList<Fruit>();  // error

        List<? super Orange> list4 = new ArrayList<Orange>();
        List<? super Orange> list5 = new ArrayList<Fruit>();
        List<? super Apple> list6 = new ArrayList<Fruit>();
//        List<? super Fruit> list = new ArrayList<Apple>();    // error
    }


}
