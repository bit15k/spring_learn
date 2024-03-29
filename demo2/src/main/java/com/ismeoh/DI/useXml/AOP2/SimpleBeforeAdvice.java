package com.ismeoh.DI.useXml.AOP2;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * *****************************************************************************
 *
 * @author : tk
 * @file : null.java
 * @brief : None
 * @attention : None
 * @date : 2023/3/5
 * *****************************************************************************
 */

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before '" + method.getName() + "', tune guitar.");
    }
    public static void main(String... args) {
        Guitarist johnMayer = new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(johnMayer);
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
    }
}
