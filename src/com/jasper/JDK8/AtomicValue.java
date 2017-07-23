package com.jasper.JDK8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by zxy on 2017/7/23.
 */
public class AtomicValue {
    public static void main(String[] args) {
        AtomicInteger largest = new AtomicInteger();
        // 在某个线程中。。。
        Integer observed = 10;
        largest.set(Math.max(largest.get(), observed)); // 存在竞争条件

        // 如果另一个线程也在更新largest，那么compareAndSet会返回false，程序再次尝试
        Integer oldValue;
        Integer newValue;
        do {
            oldValue = largest.get();
            newValue = Math.max(oldValue, observed);
        } while (!largest.compareAndSet(oldValue, newValue));

        // Java8中可使用lambda改写如下
        largest.updateAndGet(x -> Math.max(x, observed));
        largest.accumulateAndGet(observed, Math::max);

        // 直到最后才计算总值
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        longAdder.add(2);
        System.out.println(longAdder.sum());

        // LongAccumulator
        LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);
        longAccumulator.accumulate(3);
        longAccumulator.accumulate(-1);
        System.out.println(longAccumulator.get());

        System.out.println(Integer.MAX_VALUE);
    }
}
