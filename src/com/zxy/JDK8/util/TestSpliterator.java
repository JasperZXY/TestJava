package com.zxy.JDK8.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by zxy on 2018/3/18.
 *
 * @see java.util.Spliterator
 * <p>
 * 参考
 * https://segmentfault.com/q/1010000007087438
 * http://ifeve.com/java8-stream-中spliterator的使用一/
 * http://ifeve.com/java8-stream-中spliterator的使用二/
 * <p>
 * Spliterator（splitable iterator可分割迭代器）接口是Java为了并行遍历数据源中的元素而设计的迭代器，
 * 这个可以类比最早Java提供的顺序遍历迭代器Iterator，但一个是顺序遍历，一个是并行遍历
 */
public class TestSpliterator {
    public static void main(String[] args) {
        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
//        Spliterator<Character> stream = IntStream.range(0, arr.length()).mapToObj(String::charAt);
//        System.out.println("ordered total: " + countNum(stream));

        Spliterator<Character> spliterator = new NumCounterSpliterator(0, arr, true);
        // 传入true表示是并行流
        Stream<Character> parallelStream = StreamSupport.stream(spliterator, true);
        System.out.println("parallel total: " + countNum(parallelStream));
    }

    private static int countNum(Stream<Character> stream) {
        NumCounter numCounter = stream.reduce(new NumCounter(0, 0, false), NumCounter::accumulate, NumCounter::combine);
        return numCounter.getSum();
    }

    static class NumCounter {
        private int num;
        private int sum;
        // 是否当前是个完整的数字
        private boolean isWholeNum;

        public NumCounter(int num, int sum, boolean isWholeNum) {
            this.num = num;
            this.sum = sum;
            this.isWholeNum = isWholeNum;
        }

        public NumCounter accumulate(Character c) {
            System.out.println(Thread.currentThread().getName());
            if (Character.isDigit(c)) {
                return isWholeNum ? new NumCounter(Integer.parseInt("" + c), sum, false) : new NumCounter(Integer.parseInt("" + num + c), sum, false);
            } else {
                return new NumCounter(0, sum + num, true);
            }
        }

        public NumCounter combine(NumCounter numCounter) {
            return new NumCounter(0, this.getSum() + numCounter.getSum(), numCounter.isWholeNum);
        }

        public int getSum() {
            return sum + num;
        }
    }

    static class NumCounterSpliterator implements Spliterator<Character> {

        private String str;
        private int currentChar = 0;
        private boolean canSplit = true;

        public NumCounterSpliterator(int currentChar, String str, boolean canSplit) {
            this.str = str;
            this.currentChar = currentChar;
            this.canSplit = canSplit;
        }


        public void forEachRemaining(Consumer<? super Character> action) {
            do {
            } while (tryAdvance(action));
        }

        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            if (str.equals("")) {
                return false;
            }
            action.accept(str.charAt(currentChar++));
            return currentChar < str.length();
        }

        @Override
        public Spliterator<Character> trySplit() {
            int i = currentChar;
            for (; canSplit && i < str.length(); ++i) {

                //第一个不是数字的pos，进行分割
                if (!Character.isDigit(str.charAt(i))) {
                    String str1 = str;
                    this.str = str1.substring(currentChar, i);
                    canSplit = false;
                    if (i + 1 < str1.length()) {
                        return new NumCounterSpliterator(0, str1.substring(i + 1, str1.length()), true);
                    } else {
                        return null;
                    }
                }
            }

            canSplit = false;
            return null;
        }

        @Override
        public long estimateSize() {
            return str.length() - currentChar;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
        }

    }
}
