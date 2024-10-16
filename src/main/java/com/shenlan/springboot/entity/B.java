package com.shenlan.springboot.entity;

import javax.validation.constraints.NotNull;

public class B {
    @NotNull(message = "name 不能为空")
    private String name;

    // getter 和 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

