package com.man4fun.game.rpc.starter.common;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author peng
 * @Date 2023/3/11
 * @description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface EasyRpcService {
    //限流
    int limit() default 0;
    //服务权重[100的倍数] (该参数和路由策略有关，只有随机策略才会使用)
    int weight() default 100;
    //服务分组
    String group() default "default";
    //令牌校验
    String serviceToken() default "";
}
