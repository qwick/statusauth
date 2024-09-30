package com.shenlan.springboot.aop;

import com.shenlan.springboot.annotation.RequiresPermission;
import com.shenlan.springboot.exception.UnauthorizedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PermissionAspect {

    @Before("@annotation(requiresPermission)")
    public void checkPermission(JoinPoint joinPoint, RequiresPermission requiresPermission) {
        String permission = requiresPermission.value();

        // 模拟获取当前用户权限
        boolean hasPermission = checkUserPermission(permission);

        if (!hasPermission) {
            throw new UnauthorizedException("You do not have permission: " + permission);
        }
    }

    private boolean checkUserPermission(String permission) {
        // 实际逻辑：根据当前用户检查权限
        return false; // 示例：总是返回 false
    }
}

