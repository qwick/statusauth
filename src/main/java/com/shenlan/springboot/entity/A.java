package com.shenlan.springboot.entity;

import javax.validation.Valid;

public class A<T> {
    @Valid  // 级联校验B类的属性
    private T b;

    // getter 和 setter
    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }
}


