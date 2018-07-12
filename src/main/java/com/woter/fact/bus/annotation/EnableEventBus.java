package com.woter.fact.bus.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * @author woter
 * @date 2017-8-18 上午10:50:49
 * @version
 */
@Configuration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(EventBusConfiguration.class)
@Documented
public @interface EnableEventBus {

}
 