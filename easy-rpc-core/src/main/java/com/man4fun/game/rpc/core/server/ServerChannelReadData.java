package com.man4fun.game.rpc.core.server;

import com.man4fun.game.rpc.core.common.RpcProtocol;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author peng
 * @Date 2023/3/8
 * @description:
 */
public class ServerChannelReadData {

    private RpcProtocol rpcProtocol;

    private ChannelHandlerContext channelHandlerContext;

    public RpcProtocol getRpcProtocol() {
        return rpcProtocol;
    }

    public void setRpcProtocol(RpcProtocol rpcProtocol) {
        this.rpcProtocol = rpcProtocol;
    }

    public ChannelHandlerContext getChannelHandlerContext() {
        return channelHandlerContext;
    }

    public void setChannelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }
}

