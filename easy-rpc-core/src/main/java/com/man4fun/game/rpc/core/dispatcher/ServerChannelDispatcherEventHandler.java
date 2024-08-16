package com.man4fun.game.rpc.core.dispatcher;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ServerChannelDispatcherEventHandler {
    private static Map<String, Consumer<ServerChannelDispatcherResultWrapper>> eventHandlerMap = new HashMap<>();

    private static String makeKey(String serviceName, String methodName){
        return serviceName + ":" + methodName;
    }

    public static void register(String serviceName, String methodName, Consumer<ServerChannelDispatcherResultWrapper> consumer){
        String key = makeKey(serviceName, methodName);
        eventHandlerMap.put(key, consumer);
    }

    public static void onInvokeSuccess(ChannelHandlerContext channelHandlerContext, String serviceName, String methodName, Object result){
        String key = makeKey(serviceName, methodName);
        Consumer<ServerChannelDispatcherResultWrapper> consumer = eventHandlerMap.get(key);
        if(consumer == null)
            return;

        ServerChannelDispatcherResultWrapper wrapper = new ServerChannelDispatcherResultWrapper();
        wrapper.serviceName = serviceName;
        wrapper.methodName = methodName;
        wrapper.channelHandlerContext = channelHandlerContext;
        wrapper.result = result;

        consumer.accept(wrapper);
    }
}
