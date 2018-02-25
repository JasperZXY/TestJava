package com.zxy.testClass;

import java.io.*;
import java.util.Arrays;

/**
 * 序列化跟反序列化
 */
public class TestSerializable {

    public static void main(String[] args) throws Exception {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setName("bean");
        System.out.println(bean);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(bean);    // 必须实现Serializable才能执行，不然会报错！

        /**
         * 从运行结果看，
         * 如果打印成字符串，则两者“看起来”相同;
         * 如果是byte数组，则有点不同。
         *
         * 鉴于上述的结论，所以在用ByteArrayInputStream时要用ByteArrayOutputStream的toByteArray输出的结果。
         */
        System.out.println(baos.toString());
        System.out.println(new String(baos.toByteArray()));
        System.out.println(Arrays.toString(baos.toString().getBytes()));
        System.out.println(Arrays.toString(baos.toByteArray()));

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object objectFromStream = ois.readObject();
        System.out.println(objectFromStream);

        System.out.println(objectFromStream.getClass());

    }


    static class Bean implements Serializable {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
