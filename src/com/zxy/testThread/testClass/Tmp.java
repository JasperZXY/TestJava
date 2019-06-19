package com.zxy.testThread.testClass;

import com.zxy.testThread.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhongxianyao. Time 2019/5/10 11:02 PM Desc 文件描述
 */
public class Tmp {

    private static class GP {

        long price;

        long time;

        public long getPrice() {
            return price;
        }


        public void setPrice(long price) {
            this.price = price;
        }


        public long getTime() {
            return time;
        }


        public void setTime(long time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        List<GP> gpList = new ArrayList<>();

        long min = gpList.get(0).getPrice();
        int minIndex = 0;

        int maxIndex = -1;
        long max = Long.MIN_VALUE;

        long in = -1;

        List<Long> result = new ArrayList();
        int resultIndex = 0;

        for (int i=1; i<gpList.size(); i++) {
            if (gpList.get(i).getPrice() <= min) {
                min = gpList.get(i).getPrice();
                minIndex = i;
                result.set(resultIndex, (long)minIndex);
            }else {
                resultIndex ++;
                for (int j=i; j<gpList.size(); j++) {
                    if (gpList.get(j).getPrice() >= max) {
                        max = gpList.get(j).getPrice();
                        in = max - min;
                        maxIndex = j;
                        result.set(resultIndex, (long)maxIndex);
                    }else {
                        if (gpList.get(j).getPrice() - min >= in) {
                            max = gpList.get(j).getPrice();
                            maxIndex = j;
                            result.set(resultIndex, (long)maxIndex);
                        }else {

                        }
                        resultIndex ++;
                        result.set(resultIndex, max - min);
                        i = j-1;
                        resultIndex ++;
                        break;
                    }
                }
            }
        }

        if (resultIndex <= 2) {
            System.out.println("没有最佳买卖点");
            return;
        }

        int maxResultIndex = 0;
        long maxResult = result.get(maxResultIndex + 2);

        for (int i=2+3; i<result.size(); i++) {
            if (result.get(i) > maxResult) {
                maxResult = result.get(i);
                maxResultIndex = i - 2;
            }
        }
        System.out.println("买入点:" + gpList.get(maxResultIndex));
        System.out.println("卖出点:" + gpList.get(maxResultIndex + 1));
    }

}
