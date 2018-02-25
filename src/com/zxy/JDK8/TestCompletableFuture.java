package com.zxy.JDK8;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * Created by zxy on 2017/7/23.
 */
public class TestCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> downloadImg("http://xxx"))
                .thenApply(TestCompletableFuture::rendering)
                .thenAcceptAsync(data -> System.out.println(Arrays.toString(data)));
        System.out.println("end");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static byte[] downloadImg(String url) {
        System.out.println("download start...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("download end...");
        return new byte[]{1, 2};
    }

    public static byte[] rendering(byte[] image) {
        System.out.println("rendering start...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rendering end...");
        image[0] = 10;
        return image;
    }
}
