package com.shenlan.springboot.controller;

//import com.shenlan.springboot.entity.A;
//import com.shenlan.springboot.entity.B;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api")
//public class ValidController {
//    @PostMapping("/submit")
//    public String submitData(@Valid @RequestBody A<B> request) {
//        // 如果 B 的 name 为空，这里将自动触发校验异常
//        return "Success";
//    }
//
//}


import com.shenlan.springboot.entity.A;
import com.shenlan.springboot.entity.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RestController
@RequestMapping("/api")
@Validated
public class ValidController {

    @Autowired
    private Validator validator;

    @PostMapping("/submit")
    public String submitData(@RequestBody A<B> request) {
        // 手动获取A类中的B对象
        B b = request.getB();

        // 使用Validator校验B类
        Set<ConstraintViolation<B>> violations = validator.validate(b);

        // 如果有校验错误，返回错误信息
        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder();
            for (ConstraintViolation<B> violation : violations) {
                errorMessage.append(violation.getPropertyPath()).append(" ").append(violation.getMessage()).append("\n");
            }
            return errorMessage.toString();
        }

        return "Success";
    }
}
