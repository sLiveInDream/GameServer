package com.man4fun.game.rpc.core.dispatcher;

import io.netty.channel.ChannelHandlerContext;

public class ServerChannelDispatcherResultWrapper {
    public String serviceName;
    public String methodName;
    public ChannelHandlerContext channelHandlerContext;
    public Object result;
}
