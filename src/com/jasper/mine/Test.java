package com.jasper.mine;

public class Test {
    public static void main(String[] args) {
        System.out.println(m().data);            // 跑通了
        System.out.println(m().data.getClass()); // 抛异常
    }
    static Result<UserInfo> m() {
        Result result = new Result();
        result.data = new Result();
        return result;
    }
    static class Result<T> {
        public T data;
    }
    static class UserInfo {
    }
}


