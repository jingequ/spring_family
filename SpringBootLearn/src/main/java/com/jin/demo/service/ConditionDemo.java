package com.jin.demo.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

public class ConditionDemo implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String s = conditionContext.getEnvironment().getProperty("condition.test");
        if ("true".equalsIgnoreCase(s)) {
            return true;
        }
        return false;
    }
}
