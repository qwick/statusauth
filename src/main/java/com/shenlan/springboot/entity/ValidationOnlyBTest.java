package com.shenlan.springboot.entity;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidationOnlyBTest {
    public static void main(String[] args) {
        // 假设你只能访问A类，不能修改
        A a = new A();
        B b = (B) a.getB();  // 从A类中获取B类对象

        if (b != null) {
            // 创建Validator实例
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            // 手动校验B类
            Set<ConstraintViolation<B>> violations = validator.validate(b);

            // 输出校验结果
            for (ConstraintViolation<B> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
        } else {
            System.out.println("B对象为空");
        }
    }
}
