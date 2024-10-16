package com.shenlan.springboot.entity;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidationTest {
    public static void main(String[] args) {
        // 创建Validator实例
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 创建A类对象，并且B类属性未初始化（会触发NotNull校验）
        A a = new A();
        B b = new B();
        a.setB(b); // 设置B对象，但没有设置B的name属性，触发校验

        // 执行校验
        Set<ConstraintViolation<A>> violations = validator.validate(a);

        // 输出校验结果
        for (ConstraintViolation<A> violation : violations) {
            System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
        }
    }
}

