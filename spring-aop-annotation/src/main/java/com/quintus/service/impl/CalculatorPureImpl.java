package com.quintus.service.impl;

import com.quintus.service.Calculator;
import org.springframework.stereotype.Component;

/**
 *  aop - 只针对ioc容器的对象 - 创建代理对象 -> 代理兑现存储到ioc容器
 * */

@Component
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
