package com.man4fun.game.rpc.core.filter;

import com.man4fun.game.rpc.core.common.ChannelFutureWrapper;
import com.man4fun.game.rpc.core.common.RpcInvocation;

import java.util.List;

/**
 * @Author peng
 * @Date 2023/3/4
 * @description: 客户端过滤器
 */
public interface ClientFilter extends Filter {

    /**
     * 执行过滤链
     *
     * @param src
     * @param rpcInvocation
     * @return
     */
    void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation);
}