package com.man4fun.game.rpc.core.filter.client;

import com.man4fun.game.rpc.core.common.ChannelFutureWrapper;
import com.man4fun.game.rpc.core.common.RpcInvocation;
import com.man4fun.game.rpc.core.filter.ClientFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author peng
 * @Date 2023/3/4
 * @description: 客户端模块的过滤链设计
 */
public class ClientFilterChain {

    private static List<ClientFilter> clientFilterList = new ArrayList<>();

    public void addClientFilter(ClientFilter iClientFilter) {
        clientFilterList.add(iClientFilter);
    }

    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        for (ClientFilter iClientFilter : clientFilterList) {
            iClientFilter.doFilter(src, rpcInvocation);
        }
    }

}
